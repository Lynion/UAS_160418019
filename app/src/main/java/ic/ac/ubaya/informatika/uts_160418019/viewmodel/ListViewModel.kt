package ic.ac.ubaya.informatika.uts_160418019.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class ListViewModel(application: Application)
    :AndroidViewModel(application), CoroutineScope {
    val vaccineLoad = MutableLiveData<List<Vaccine>>()
    val vaccine = MutableLiveData<Vaccine>()
    val loadingBar = MutableLiveData<Boolean>()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh(){
        launch {
            val db = buildDb(getApplication())
            vaccineLoad.value = db.vaccineDao().selectAllVaccine()
            loadingBar.value = true
        }
    }

    fun init(list:List<Vaccine>){
        launch {
            val db = buildDb(getApplication())
            db.vaccineDao().insertAll(*list.toTypedArray())
            refresh()
        }
    }
    fun boom(){
        launch {
            val db = buildDb(getApplication())
            db.vaccineDao().boom()
        }
    }

    fun selectVaccine(uuid:Int){
        launch {
            val db = buildDb(getApplication())
            db.vaccineDao().selectVaccine(uuid)
        }
    }



}