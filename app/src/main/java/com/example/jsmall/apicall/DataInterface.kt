package com.example.jsmall.apicall

import com.example.jsmall.modelclass.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "http://fakestoreapi.com/"
interface DataInterface {

    @GET("products")
    fun getProductData(): Call<ArrayList<DataModel>>
}

object DataService{

     val DataInstace : DataInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        DataInstace = retrofit.create(DataInterface::class.java)
    }
}