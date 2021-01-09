package cl.enzo86.novaera2.domain.model

import com.google.gson.annotations.SerializedName

data class DetalleTelefono(
    @SerializedName("id")
    val idDetalle: Int,
    @SerializedName("name")
    val nombreDetalle: String,
    @SerializedName("price")
    val precioDetalle: Int,
    @SerializedName("image")
    val imagenDetalle: String,
    @SerializedName("description")
    val descripcionDetalle: String,
    @SerializedName("lastPrice")
    val ultimoPrecioDetalle: Int,
    @SerializedName("credit")
    val creditoDetalle: Boolean
)