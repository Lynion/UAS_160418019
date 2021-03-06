package ic.ac.ubaya.informatika.uts_160418019.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.databinding.VaccineListItemBinding
import ic.ac.ubaya.informatika.uts_160418019.model.Vaccine
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.fragment_vaccinate_register.view.*
import kotlinx.android.synthetic.main.vaccine_list_item.view.*

class VaccineListAdapter(val vaccineList:ArrayList<Vaccine>): RecyclerView.Adapter<VaccineListAdapter.VaccineViewHolder>(),DetailsClick,RegisterClick {
    class VaccineViewHolder(var view:VaccineListItemBinding):RecyclerView.ViewHolder(view.root)
    fun updateList(newVaccineList:List<Vaccine>){
        vaccineList.clear()
        vaccineList.addAll(newVaccineList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v =DataBindingUtil.inflate<VaccineListItemBinding>(inflater, R.layout.vaccine_list_item, parent, false)

        return VaccineViewHolder(v)
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
//        holder.view.vaccineNameLabel.text =vaccineList[position].name
//        holder.view.detailBtn.setOnClickListener{
//            val action = VaccineListFragmentDirections.actionToVaccineDetailFragment(vaccineList[position].name, vaccineList[position].detail)
//            Navigation.findNavController(it).navigate(action)
//        }
//        holder.view.registerVaccinateBtn.setOnClickListener{
//            val action = VaccineListFragmentDirections.actionToVaccineRegisterFragment(vaccineList[position].name)
//            Navigation.findNavController(it).navigate(action)
//        }
        holder.view.vaccine=vaccineList[position]
        holder.view.detailListener = this
        holder.view.registerListener = this
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }

    override fun onDetailClick(v: View) {
        val action = VaccineListFragmentDirections.actionToVaccineDetailFragment(v.tag.toString().toInt())
            Navigation.findNavController(v).navigate(action)
    }

    override fun onRegisterClick(v: View) {
        val action = VaccineListFragmentDirections.actionToVaccineRegisterFragment(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }
}