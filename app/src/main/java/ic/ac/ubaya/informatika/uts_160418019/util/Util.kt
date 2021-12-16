package ic.ac.ubaya.informatika.uts_160418019.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ic.ac.ubaya.informatika.uts_160418019.model.VaccineDatabase

val DB_NAME = "newuserdb"
fun buildDb(context: Context):VaccineDatabase {
    val db = Room.databaseBuilder(context, VaccineDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}

val MIGRATION_1_2: Migration=object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS 'Vaccine'('uuid' INTEGER NOT NULL, 'name' TEXT NOT NULL, 'detail' TEXT NOT NULL, PRIMARY KEY('uuid'))")
    }
}
