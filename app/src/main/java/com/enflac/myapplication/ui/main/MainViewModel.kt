package com.enflac.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enflac.myapplication.data.network.response.LoginResponse
import com.enflac.myapplication.data.repository.MainRepository
import com.enflac.myapplication.utils.Coroutines

class MainViewModel(var aMainRepository: MainRepository) : ViewModel() {

    val TAG = MainViewModel::class.java.simpleName

    var aUserLoggedin = MutableLiveData<LoginResponse>()

    init {

        val alog = LoginResponse()
        alog.token = "qwqwqwqwqwqw"
        aUserLoggedin.postValue(alog) //postvalue value update immediate but waiting for main thread ui update

        val alog1 = LoginResponse()
        alog1.token = "aaaaaaaaa"
        aUserLoggedin.value = alog1   //setvalue immediately setvalue
    }


    fun callsimple() {
        Coroutines.io {
            try {
                val aLoginResponse = aMainRepository.userLogin("eve.holt@reqres.in", "cityslicka")
                aUserLoggedin.postValue(aLoginResponse)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}