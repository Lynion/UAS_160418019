package ic.ac.ubaya.informatika.uts_160418019.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ic.ac.ubaya.informatika.uts_160418019.R
import ic.ac.ubaya.informatika.uts_160418019.model.Vaccine
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.fragment_vaccinate_register.view.*
import kotlinx.android.synthetic.main.vaccine_list_item.view.*

class VaccineListAdapter(val vaccineList:ArrayList<Vaccine>): RecyclerView.Adapter<VaccineListAdapter.VaccineViewHolder>(){
    class VaccineViewHolder(val view:View):RecyclerView.ViewHolder(view)
    fun updateList(newVaccineList:List<Vaccine>){
        vaccineList.clear()
        vaccineList.addAll(newVaccineList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v =inflater.inflate(R.layout.vaccine_list_item,parent,false)
        return VaccineViewHolder(v)
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        holder.view.vaccineNameLabel.text =vaccineList[position].name
        holder.view.detailBtn.setOnClickListener{
            val action = VaccineListFragmentDirections.actionToVaccineDetailFragment(vaccineList[position].name, vaccineList[position].detail)
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.registerVaccinateBtn.setOnClickListener{
            val action = VaccineListFragmentDirections.actionToVaccineRegisterFragment(vaccineList[position].name)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }
}