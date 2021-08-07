package com.example.jsmall.mvvmarchitecture

import androidx.lifecycle.MutableLiveData
import com.example.jsmall.apicall.DataService
import com.example.jsmall.modelclass.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository() {



    val proData : MutableLiveData<ArrayList<DataModel>> = MutableLiveData()
    val errmsg : MutableLiveData<String> = MutableLiveData()

    fun getData() : MutableLiveData<ArrayList<DataModel>>{

        val dataIn = DataService.DataInstace.getProductData()
        dataIn.enqueue(object : Callback<ArrayList<DataModel>>{
                override fun onResponse(
                    call: Call<ArrayList<DataModel>>,
                    response: Response<ArrayList<DataModel>>
                ) {
                    proData.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<DataModel>>, t: Throwable) {
                    errmsg.value = t.message
                }
            })
        return proData
    }

}