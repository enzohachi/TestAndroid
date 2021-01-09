package cl.enzo86.novaera2.data.remote

import cl.enzo86.novaera2.domain.TelefonoRepository
import cl.enzo86.novaera2.domain.model.DetalleTelefono
import cl.enzo86.novaera2.domain.model.Telefono

class RemoteTelefonoRepository (
    private val TelefonoApi: TelefonosApi
) : TelefonoRepository {

    override suspend fun getAllTelefonos(): List<Telefono> {
        return TelefonoApi.getTelefonoApi()
    }

    override suspend fun getAllDetalle(): List<DetalleTelefono> {
        return TelefonoApi.getDetalleApi()
    }

}