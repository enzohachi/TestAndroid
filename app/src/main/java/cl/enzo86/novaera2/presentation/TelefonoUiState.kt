package cl.enzo86.novaera2.presentation

import cl.enzo86.novaera2.domain.model.Telefono

sealed class TelefonoUiState (open val result: List <Telefono>? = null){

    object LoadingTelefonoUiState: TelefonoUiState()
    object EmptyListTelefonoUiState: TelefonoUiState()
    data class Success (override val result: List<Telefono>): TelefonoUiState(result)
    object ErrorServerTelefonoUiState: TelefonoUiState()
}