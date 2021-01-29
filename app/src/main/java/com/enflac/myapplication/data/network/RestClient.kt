package com.enflac.myapplication.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestClient {

    private var retrofit: Retrofit? = null

    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.MINUTES)
            .readTimeout(15, TimeUnit.MINUTES).writeTimeout(15, TimeUnit.MINUTES)
            .build()

     val client: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl("https://reqres.in/api/")
                    .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return this.retrofit!!
        }


    fun getService():WebserviceInterface {
        return client.create(WebserviceInterface::class.java)
    }

}