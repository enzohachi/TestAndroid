package cl.enzo86.novaera2.data.internal

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "tablaDetalleTelefono")
data class DetalleTelefonoEntity (
    @SerializedName("id")
    @PrimaryKey val id: Int,
    @SerializedName("image")
    val imagenDetalle: String,
    @SerializedName("name")
    val nombreDetalle: String,
    @SerializedName("price")
    val precioDetalle: Int,
    @SerializedName("credit")
    val creditoDetalle: Boolean?,
    @SerializedName("description")
    val descripcionDetalle: String?,
    @SerializedName("lastPrice")
    val ultimoPrecioDetalle: Int?
)