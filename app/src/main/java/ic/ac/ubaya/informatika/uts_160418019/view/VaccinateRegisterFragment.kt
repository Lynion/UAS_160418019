package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.databinding.FragmentVaccinateRegisterBinding
import ic.ac.ubaya.informatika.uts_160418019.databinding.FragmentVaccineDetailBinding
import ic.ac.ubaya.informatika.uts_160418019.databinding.VaccineListItemBinding
import ic.ac.ubaya.informatika.uts_160418019.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_vaccinate_register.*
import kotlinx.android.synthetic.main.fragment_vaccine_detail.*


class VaccinateRegisterFragment : Fragment(), FinalRegisClick{
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentVaccinateRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentVaccinateRegisterBinding>(inflater,R.layout.fragment_vaccinate_register,container,false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.selectUser("asd")
        viewModel.selectVac(VaccinateRegisterFragmentArgs.fromBundle(requireArguments()).vaccineId)
        dataBinding.finalRegisListener = this
        observeViewModel()
//        if(arguments!=null){
//            vacNameTxt.text = VaccinateRegisterFragmentArgs.fromBundle(requireArguments()).vaccineName
//        }
//
//        registerVaccinationBtn.setOnClickListener{
//
//        }
    }
    fun observeViewModel(){
        viewModel.vaccine.observe(viewLifecycleOwner,{
            dataBinding.vaccine = it
        })
        viewModel.user.observe(viewLifecycleOwner,{
            dataBinding.user = it
        })
    }

    override fun onFinalRegisClick(v: View) {
        viewModel.updateUser(unameTxt.text.toString(),vacNameTxt.text.toString(),dateTxt.text.toString())
    }
}