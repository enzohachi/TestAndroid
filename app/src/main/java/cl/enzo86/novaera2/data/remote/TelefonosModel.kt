package cl.enzo86.novaera2.data.remote

import com.google.gson.annotations.SerializedName

data class TelefonosModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("image") val imagen: String,
    @SerializedName("price") val precio: Int
)