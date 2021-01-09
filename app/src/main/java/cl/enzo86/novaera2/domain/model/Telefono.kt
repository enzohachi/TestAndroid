package cl.enzo86.novaera2.domain.model

import com.google.gson.annotations.SerializedName

data class Telefono(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val imagen: String,
    @SerializedName("name")
    val nombre: String,
    @SerializedName("price")
    val precio: Int
)