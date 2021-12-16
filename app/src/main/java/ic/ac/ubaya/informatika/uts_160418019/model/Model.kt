package ic.ac.ubaya.informatika.uts_160418019.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Vaccine(
@ColumnInfo(name="name")
    val name : String,
@ColumnInfo(name="detail")
    val detail : String,
)
{
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}
@Entity
data class Users(
    @ColumnInfo(name="username")
    val username : String,
    @ColumnInfo(name="password")
    val password : String,
    @ColumnInfo(name="registered")
    var vaccineName:String,
    @ColumnInfo(name="date")
    var Date:String)
{
    @PrimaryKey(autoGenerate = true)
    var uid : Int = 0
}