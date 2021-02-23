package com.johnjeremih.mvvmwithkotlin.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.johnjeremih.mvvmwithkotlin.viewmodel.HomeViewModel
import com.johnjeremih.mvvmwithkotlin.R
import com.johnjeremih.mvvmwithkotlin.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment) {

    companion object {
        fun newInstance() = HomeFragment()
    }


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = HomeFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.currentNumber.observe(viewLifecycleOwner, {
            binding.homeValueTextView.text = it.toString()
        })

        binding.homeToDetailButton.setOnClickListener {

            Navigation.findNavController(binding.root).navigate(R.id.toDetailFragment)
        }
        incrementText()
    }

    private fun incrementText(){

        binding.homeHitMeButton.setOnClickListener{

            viewModel.currentNumber.value = ++viewModel.number
        }


    }

}