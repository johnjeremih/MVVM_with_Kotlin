package com.johnjeremih.mvvmwithkotlin.data

import androidx.lifecycle.MutableLiveData
import com.johnjeremih.mvvmwithkotlin.model.Employee
import java.util.*

class Repository {


    private var instance: Repository? = null
    private val dataSet: ArrayList<Employee> = ArrayList<Employee>()

    fun getInstance(): Repository? {
        if (instance == null) {
            instance = Repository()
        }
        return instance
    }


    //Pretending to retrieve the data from the web services
    fun getEmployees(): MutableLiveData<ArrayList<Employee>> {
        setDataSet()

        val data: MutableLiveData<ArrayList<Employee>> = MutableLiveData<ArrayList<Employee>>()

        data.value = dataSet

        return data
    }



    //Assuming this is the data that comes from a online source.
    private fun setDataSet() {

        dataSet.add(Employee("Juan Pablo", "Great Employee, Hard Worker"))
        dataSet.add(Employee("Anne Wilson", "Very Brilliant person"))
        dataSet.add(Employee("Anthony Rambo", "Likes to talk a lot"))
        dataSet.add(Employee("Randy Petro", "Doesn't hesitate to ask questions"))
        dataSet.add(Employee("Barbara Hillsongs", "Love to contribute with her ideas"))
        dataSet.add(Employee("Maria Rosa", "She is always giving her all"))
        dataSet.add(Employee("Brama Can", "Great Employee, Hard Worker"))
        dataSet.add(Employee("Ana Weu", "Very Brilliant person"))
        dataSet.add(Employee("Rodrigo Pepe", "Likes to talk a lot"))
        dataSet.add(Employee("Shawn Mark", "Doesn't hesitate to ask questions"))
        dataSet.add(Employee("Mark Dante", "Love to contribute with her ideas"))
        dataSet.add(Employee("Mary Rose", "She is always giving her all"))
    }


}

