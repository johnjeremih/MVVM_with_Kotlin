package com.johnjeremih.mvvmwithkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johnjeremih.mvvmwithkotlin.databinding.ListItemBinding
import com.johnjeremih.mvvmwithkotlin.model.Employee
import com.johnjeremih.mvvmwithkotlin.view.DetailFragment
import kotlin.collections.ArrayList

class DetailAdapter(
    private val mHandler: DetailFragment,
    private val employeesList: ArrayList<Employee>?
) :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
    // Remember the ListItemBinding is auto created from the xml file
    private var binding: ListItemBinding? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        // Inflating the layout and adding viewBinding.
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DetailViewHolder(binding!!.root)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val employee = employeesList!![position]

        // Getting the textViews from the list_item.xml
        binding!!.itemNameEmployee.text = employee.name
        binding!!.nameDescriptionEmployee.text = employee.Description
    }

    override fun getItemCount(): Int {

        return employeesList?.size!!
    }

    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        override fun onClick(v: View) {
            val employee = employeesList!![adapterPosition]
            mHandler.onClickListener(employee)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    interface DetailAdapterClickHandler {
        fun onClickListener(employee: Employee?)
    }
}