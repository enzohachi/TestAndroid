package cl.enzo86.novaera2.data.internal

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "tablaTelefono")
data class TelefonoEntity (
@SerializedName("id")
@PrimaryKey
val id: Int,
@SerializedName("image")
val imagen: String,
@SerializedName("name")
val nombre: String,
@SerializedName("price")
val precio: Int
)