package ic.ac.ubaya.informatika.uts_160418019.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ic.ac.ubaya.informatika.uts_160418019.model.Users
import ic.ac.ubaya.informatika.uts_160418019.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val userList = MutableLiveData<List<Users>>()
    val loadingBar = MutableLiveData<Boolean>()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun read(){
        loadingBar.value = true
        launch {
            val db = buildDb(getApplication())
            userList.value = db.usersDao().selectAllUsers()
        }
    }
}