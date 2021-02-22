package com.enflac.myapplication.data.repository

import com.enflac.myapplication.data.network.RestClient
import com.enflac.myapplication.data.network.SafeApiRequest
import com.enflac.myapplication.data.network.response.LoginResponse
import com.google.gson.JsonObject
import okhttp3.ResponseBody

class MainRepository : SafeApiRequest() {

   suspend fun userLogin(aEmail: String, aPassword: String): LoginResponse {
        val aJsonObj = JsonObject()
        aJsonObj.addProperty("email", aEmail)
        aJsonObj.addProperty("password", aPassword)
        return apiRequest{RestClient.getService().userLogin(aJsonObj)}
    }
}