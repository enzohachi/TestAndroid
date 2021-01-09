package cl.enzo86.novaera2.presentation

import cl.enzo86.novaera2.domain.model.DetalleTelefono


sealed class DetalleUiState (open val result: List <DetalleTelefono>? = null){

    object LoadingDetalleUiState: DetalleUiState()
    object EmptyListDetalleUiState: DetalleUiState()
    data class Success (override val result: List<DetalleTelefono>): DetalleUiState(result)
    object ErrorServerDetalleUiState: DetalleUiState()
}