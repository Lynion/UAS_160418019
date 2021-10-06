package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ic.ac.ubaya.informatika.uts_160418019.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton.setOnClickListener{
            val action = MainFragmentDirections.actionToLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }
        registerButton.setOnClickListener{
            val action = MainFragmentDirections.actionToRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}