package com.example.jsmall.mvvmarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jsmall.modelclass.DataModel

class DataViewModel :ViewModel(){

    fun getData() : LiveData<ArrayList<DataModel>>{
        val dataRepo = DataRepository()
        return dataRepo.getData()
    }
}