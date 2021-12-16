package ic.ac.ubaya.informatika.uts_160418019.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import ic.ac.ubaya.informatika.uts_160418019.model.Users
import ic.ac.ubaya.informatika.uts_160418019.model.Vaccine
import ic.ac.ubaya.informatika.uts_160418019.model.VaccineDatabase
import ic.ac.ubaya.informatika.uts_160418019.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application:  Application)
    :AndroidViewModel(application), CoroutineScope  {
    private val job = Job()
    val user = MutableLiveData<Users>()
    val vaccine = MutableLiveData<Vaccine>()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    fun addUser(users: Users) {
        launch {
            val db = buildDb(getApplication())
            db.usersDao().insertAll(users)
        }
    }

    fun selectUser(username:String){
        launch{
            val db = buildDb(getApplication())
            user.value=db.usersDao().selectUser(username)
        }
    }

    fun checkLogin(username: String,pw:String){
        launch {
            val db = buildDb(getApplication())
            user.value = db.usersDao().loginUser(username,pw)
        }
    }

    fun updateUser(uname:String, vacName:String, date:String) {
        launch {
            val db = buildDb(getApplication())
            db.usersDao().update(vacName,date,uname)

        }
    }

    fun DeleteUser(user:Users){
        launch {
            val db = buildDb(getApplication())
            db.usersDao().deleteUser(user)
        }
    }

    fun vacDbInit(vacList:List<Vaccine>){
        launch {
            val db = buildDb(getApplication())
            db.vaccineDao().insertAll(*vacList.toTypedArray())
        }
    }

    fun selectVac(uuid:Int){
        launch {
            val db = buildDb(getApplication())
           vaccine.value = db.vaccineDao().selectVaccine(uuid)
        }
    }

    fun updateVac(name:String,detail:String,uuid:Int){
        launch {
            val db = buildDb(getApplication())
            db.vaccineDao().updateVaccine(name,detail,uuid)
        }
    }

}