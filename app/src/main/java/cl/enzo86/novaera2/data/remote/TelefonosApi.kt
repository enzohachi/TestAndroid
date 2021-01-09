package cl.enzo86.novaera2.data.remote

import cl.enzo86.novaera2.domain.TelefonoRepository
import cl.enzo86.novaera2.domain.model.DetalleTelefono
import cl.enzo86.novaera2.domain.model.Telefono
import retrofit2.http.GET



interface TelefonosApi {

    @GET("products/")
    suspend fun getTelefonoApi(): List<Telefono>

    @GET("details/{idDetalle}")
    suspend fun getDetalleApi() : List<DetalleTelefono>

}
