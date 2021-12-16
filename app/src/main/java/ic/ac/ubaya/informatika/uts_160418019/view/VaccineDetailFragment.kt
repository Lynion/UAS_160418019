package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.databinding.FragmentVaccineDetailBinding
import ic.ac.ubaya.informatika.uts_160418019.databinding.FragmentVaccineDetailBindingImpl
import ic.ac.ubaya.informatika.uts_160418019.viewmodel.DetailViewModel
import ic.ac.ubaya.informatika.uts_160418019.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_vaccine_detail.*


class VaccineDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding:FragmentVaccineDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentVaccineDetailBinding>(inflater,R.layout.fragment_vaccine_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.selectVac(VaccineDetailFragmentArgs.fromBundle(requireArguments()).vaccineId)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.vaccine.observe(viewLifecycleOwner,{
            dataBinding.vaccine = it
        })
    }
}