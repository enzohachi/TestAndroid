package cl.enzo86.novaera2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.enzo86.novaera2.domain.ObtenerDetalleTelefonoUseCase
import cl.enzo86.novaera2.domain.ObtenerTelefonoUseCase

class DetalleViewModelFactory (
    private val obtenerDetalleTelefonoUseCase: ObtenerDetalleTelefonoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerTelefonoUseCase::class.java)
            .newInstance(obtenerDetalleTelefonoUseCase)
    }


}