package cl.enzo86.novaera2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.enzo86.novaera2.domain.ObtenerTelefonoUseCase

class TelefonoViewModelFactory (
    private val obtenerTelefonoUseCase: ObtenerTelefonoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerTelefonoUseCase::class.java)
            .newInstance(obtenerTelefonoUseCase)
    }

}