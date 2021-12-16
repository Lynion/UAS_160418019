package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.model.Users
import ic.ac.ubaya.informatika.uts_160418019.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        loginBtn.setOnClickListener{
            viewModel.checkLogin(usernameTxt.text.toString(),passTxt.text.toString())
            val user = viewModel.user
            //Toast.makeText(context,user.value?.username.toString(),Toast.LENGTH_SHORT).show()
            if(user.value?.username != null && user.value?.password!=null)
            {
                val action = LoginFragmentDirections.actionLoginToVaccineListFragment()
                Navigation.findNavController(it).navigate(action)
            }


        }
    }

}