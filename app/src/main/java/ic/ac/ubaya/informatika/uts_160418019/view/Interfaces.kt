package ic.ac.ubaya.informatika.uts_160418019.view

import android.view.View
import ic.ac.ubaya.informatika.uts_160418019.model.Users
import ic.ac.ubaya.informatika.uts_160418019.model.Vaccine

interface RegisterClick {
    fun onRegisterClick(v:View)
}

interface DetailsClick{
    fun onDetailClick(v:View)
}

interface FinalRegisClick {
    fun onFinalRegisClick(v:View)

}
