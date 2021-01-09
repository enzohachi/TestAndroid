package cl.enzo86.novaera2.domain

class ObtenerDetalleTelefonoUseCase (
    private val repository: TelefonoRepository
) {
    suspend fun executeDetalle() = repository.getAllDetalle()
}

