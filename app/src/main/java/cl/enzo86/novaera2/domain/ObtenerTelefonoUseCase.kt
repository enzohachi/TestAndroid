package cl.enzo86.novaera2.domain

class ObtenerTelefonoUseCase (
    private val repository: TelefonoRepository
) {
    suspend fun execute() = repository.getAllTelefonos()
}