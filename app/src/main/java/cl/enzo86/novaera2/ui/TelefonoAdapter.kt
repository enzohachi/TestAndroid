package cl.enzo86.novaera2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.enzo86.novaera2.databinding.ItemTelefonosBinding
import cl.enzo86.novaera2.domain.model.Telefono

class TelefonoAdapter(
    private val telefono: List<Telefono>,
    private val itemClickTelefono: TelefonosFragment
) : RecyclerView.Adapter<TelefonoViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonoViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemTelefonosBinding.inflate(inflate,parent, false)
        return TelefonoViewHolder(binding, itemClickTelefono)
    }

    override fun onBindViewHolder(holder: TelefonoViewHolder, position: Int) {
        holder.bind(telefono[position])
    }

    override fun getItemCount() = telefono.size

}