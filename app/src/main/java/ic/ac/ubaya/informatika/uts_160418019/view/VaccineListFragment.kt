package ic.ac.ubaya.informatika.uts_160418019.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_vaccine_list.*


class VaccineListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val vaccineListAdapter = VaccineListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vaccine_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        vaccineListRecView.layoutManager=LinearLayoutManager(context)
        vaccineListRecView.adapter = vaccineListAdapter
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.vaccineLoad.observe(viewLifecycleOwner, Observer {
            vaccineListAdapter.updateList(it)
        })
        viewModel.loadingBar.observe(viewLifecycleOwner, Observer {
            if(it==true){
                vaccineListRecView.visibility=View.GONE
                progressBar.visibility = View.VISIBLE
            }
            else{
                vaccineListRecView.visibility=View.VISIBLE
                progressBar.visibility = View.GONE
            }
        })
    }

}