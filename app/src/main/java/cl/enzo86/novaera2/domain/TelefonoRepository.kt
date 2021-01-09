package cl.enzo86.novaera2.domain

import cl.enzo86.novaera2.domain.model.DetalleTelefono
import cl.enzo86.novaera2.domain.model.Telefono

interface TelefonoRepository {
    suspend fun getAllTelefonos() : List<Telefono>
    suspend fun getAllDetalle() : List<DetalleTelefono>
}