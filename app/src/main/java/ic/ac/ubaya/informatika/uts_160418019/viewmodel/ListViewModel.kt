package ic.ac.ubaya.informatika.uts_160418019.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ic.ac.ubaya.informatika.uts_160418019.model.Vaccine

class ListViewModel:ViewModel() {
    val vaccineLoad = MutableLiveData<List<Vaccine>>()
    val loadingBar = MutableLiveData<Boolean>()

    fun refresh(){
        val vaccine1 = Vaccine("Sinovac","Made in China")
        val vaccine2 = Vaccine("Astrazeneca","Made in United Kingdom")
        val vaccine3 = Vaccine("Pfizer","Made in Germany")
        val vaccineList : ArrayList<Vaccine> = arrayListOf<Vaccine>(vaccine1,vaccine2,vaccine3)

        vaccineLoad.value = vaccineList
        loadingBar.value = false

    }
}