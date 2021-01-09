package cl.enzo86.novaera2.data.internal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.enzo86.novaera2.domain.model.DetalleTelefono
import cl.enzo86.novaera2.domain.model.Telefono

@Dao
interface TelefonoDao {
    @Query("SELECT * FROM tablaTelefono")
    fun getSmallInfo() : LiveData<List<Telefono>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phoneList : List<TelefonoEntity>)

    @Query("SELECT * FROM tablaDetalleTelefono WHERE id=:id")
    fun getSingleDetail(id: Int) : LiveData<DetalleTelefono>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailPhone(phoneDetail : DetalleTelefonoEntity)
}