package com.enflac.myapplication.data.network

import com.enflac.myapplication.data.network.response.LoginResponse
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface WebserviceInterface {

    @POST("login")
    suspend fun userLogin(@Body aJson: JsonObject): Response<LoginResponse>

}