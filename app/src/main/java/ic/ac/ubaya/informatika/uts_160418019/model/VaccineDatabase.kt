package ic.ac.ubaya.informatika.uts_160418019.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class,Vaccine::class), version =  2)
abstract class VaccineDatabase:RoomDatabase() {
    abstract fun usersDao(): UserDao
    abstract fun vaccineDao():VaccineDao

    companion object {
        @Volatile private var instance: VaccineDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                VaccineDatabase::class.java,
                "newuserdb").build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}
