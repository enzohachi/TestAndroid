package cl.enzo86.novaera2.data.internal

import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = arrayOf(TelefonoEntity::class, DetalleTelefonoEntity::class), version = 1)
abstract class TelefonoDatabase {

    abstract fun telefonoDao(): TelefonoDao

    companion object{

        private var INSTANCE: TelefonoDatabase? = null

        fun getDatabase(context: Context): TelefonoDatabase {
          //  INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext,TelefonoDatabase::class.java,"tabla_telefono").build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}