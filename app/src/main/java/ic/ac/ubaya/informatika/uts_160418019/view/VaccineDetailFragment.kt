package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ic.ac.ubaya.informatika.uts_160418019.R
import kotlinx.android.synthetic.main.fragment_vaccine_detail.*


class VaccineDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vaccine_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            vaccineNameTxt.text = VaccineDetailFragmentArgs.fromBundle(requireArguments()).vaccineName
            detailTxt.text = VaccineDetailFragmentArgs.fromBundle(requireArguments()).details
        }
    }

}