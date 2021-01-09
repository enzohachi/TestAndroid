package cl.enzo86.novaera2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.enzo86.novaera2.R
import cl.enzo86.novaera2.data.remote.RemoteTelefonoRepository
import cl.enzo86.novaera2.data.remote.RetrofitHandler
import cl.enzo86.novaera2.databinding.FragmentTelefonosBinding
import cl.enzo86.novaera2.databinding.ItemTelefonosBinding
import cl.enzo86.novaera2.domain.ObtenerTelefonoUseCase
import cl.enzo86.novaera2.domain.model.Telefono
import cl.enzo86.novaera2.presentation.TelefonoUiState
import cl.enzo86.novaera2.presentation.TelefonoViewModel
import cl.enzo86.novaera2.presentation.TelefonoViewModelFactory

class TelefonosFragment : Fragment(R.layout.fragment_telefonos) {

    private lateinit var viewModel: TelefonoViewModel
    private lateinit var viewModelFactory: TelefonoViewModelFactory
    private lateinit var binding: FragmentTelefonosBinding
    private lateinit var binding2: ItemTelefonosBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentTelefonosBinding.bind(view)
        setupRecyclerView()
        setupLiveData()


    }

    private fun setupDependencies() {
        viewModelFactory = TelefonoViewModelFactory(
            ObtenerTelefonoUseCase(
                RemoteTelefonoRepository(
                    RetrofitHandler.getTelefonoApi()
                )
            )
        )

        viewModel = ViewModelProvider(this, viewModelFactory).get(TelefonoViewModel::class.java)


    }

    private fun setupRecyclerView() {
        binding.apply {
            rvListadoCopete.setHasFixedSize(true)
            val layoutManager = LinearLayoutManager(context)
            rvListadoCopete.layoutManager = layoutManager
            rvListadoCopete.addItemDecoration(
                DividerItemDecoration(
                    context,
                    layoutManager.orientation
                )
            )
        }
    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer {
                it?.let { safeState -> handleState(safeState) }
            }
        )
        viewModel.obtenerProductos()
    }

    private fun handleState(safeState: TelefonoUiState) {
        when (safeState) {
            is TelefonoUiState.LoadingTelefonoUiState -> showLoading()
            is TelefonoUiState.ErrorServerTelefonoUiState -> showErrorServer()
            is TelefonoUiState.Success -> loadResult(safeState.result)
            is TelefonoUiState.EmptyListTelefonoUiState -> showEmptyList()
        }
    }

    private fun showEmptyList() {
        Toast.makeText(context, "Empty List", Toast.LENGTH_SHORT).show()
    }

    private fun loadResult(telefono: List<Telefono>?) {
        telefono?.let { safeTelefono ->
            binding.rvListadoCopete.adapter = TelefonoAdapter(safeTelefono, this)
        }
    }

    private fun showErrorServer() {
        Toast.makeText(context, "No hay coneccion con el servidor", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        Toast.makeText(context, "Cargando.....", Toast.LENGTH_SHORT).show()
    }

    fun onItemCLickProducto(telefono: Telefono) {

    }
}