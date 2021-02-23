package com.johnjeremih.mvvmwithkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johnjeremih.mvvmwithkotlin.data.Repository
import com.johnjeremih.mvvmwithkotlin.model.Employee
import kotlin.collections.ArrayList

/* Made by John De la cruz
*  2/21/21
*/
 public class DetailViewModel : ViewModel() {

    private var employees: MutableLiveData<ArrayList<Employee>>? = null

    /*
    * Initiation Method. This will check whether the Mutable data is null or not
    * If the data is null then it will get the instance form the Repository class
     */
    fun init() {
        if (employees != null) {
            return
        }

        // Get the instance form the Repository class
        val repository: Repository? = Repository().getInstance()
        if (repository != null) {
            employees = repository.getEmployees()
        }
    }

    val employee: LiveData<ArrayList<Employee>>?
        get() = employees
}
