package com.example.k1109_chc_test

import android.app.Application
import com.example.k1109_chc_test.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application(){

    companion object {

        //add....................................
        var networkService: NetworkService

        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/6260000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        init {
            networkService = retrofit.create(NetworkService::class.java)
        }
    }
}