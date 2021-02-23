package com.johnjeremih.mvvmwithkotlin.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johnjeremih.mvvmwithkotlin.R
import com.johnjeremih.mvvmwithkotlin.adapter.DetailAdapter
import com.johnjeremih.mvvmwithkotlin.databinding.FragmentDetailBinding
import com.johnjeremih.mvvmwithkotlin.model.Employee
import com.johnjeremih.mvvmwithkotlin.viewmodel.DetailViewModel


class DetailFragment : Fragment(R.layout.fragment_detail), DetailAdapter.DetailAdapterClickHandler {



    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    private lateinit var mAdapter: DetailAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.init()

        viewModel.employee!!.observe(viewLifecycleOwner,{ mAdapter.notifyDataSetChanged() })


        binding.detailToolbar.title = "Detail Activity"
        binding.detailToolbar.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_back_button, null)
        binding.detailToolbar.setNavigationOnClickListener { Navigation.findNavController(binding.root).navigateUp() }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = DetailAdapter(this, viewModel.employee!!.value)

        val linearLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.detailRecycleView.layoutManager = linearLayoutManager
        binding.detailRecycleView.adapter = mAdapter


    }

    override fun onClickListener(employee: Employee?) {
        Toast.makeText(context,"The Employee name is "+ employee!!.name,Toast.LENGTH_LONG).show()
    }


}