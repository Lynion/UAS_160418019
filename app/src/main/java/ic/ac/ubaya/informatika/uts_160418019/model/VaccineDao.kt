package ic.ac.ubaya.informatika.uts_160418019.model

import androidx.room.*

@Dao
interface VaccineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg vaccine: Vaccine)

    @Query("SELECT * FROM Vaccine")
    suspend fun selectAllVaccine(): List<Vaccine>

    @Query("SELECT * FROM Vaccine WHERE uuid= :uuid")
    suspend fun selectVaccine(uuid:Int): Vaccine

    @Query ("update Vaccine set name = :name, detail = :detail where uuid = :id")
    suspend fun updateVaccine(name:String,detail:String,id:Int)

    @Delete
    suspend fun deleteVaccine(vaccine: Vaccine)

    @Query ("delete from Vaccine")
    suspend fun boom()
}