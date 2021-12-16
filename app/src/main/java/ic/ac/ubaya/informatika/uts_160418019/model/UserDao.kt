package ic.ac.ubaya.informatika.uts_160418019.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: Users)

    @Query("SELECT * FROM users")
    suspend fun selectAllUsers(): List<Users>

    @Query("SELECT * FROM users WHERE username= :uname")
    suspend fun selectUser(uname:String): Users

    @Query("SELECT * FROM users WHERE username= :uname AND password = :pw")
    suspend fun loginUser(uname:String,pw:String): Users

    @Query("UPDATE Users SET date=:date, registered=:vacName WHERE username =:uname")
    suspend fun update(vacName:String, date:String, uname:String)

    @Delete
    suspend fun deleteUser(users:Users)
}