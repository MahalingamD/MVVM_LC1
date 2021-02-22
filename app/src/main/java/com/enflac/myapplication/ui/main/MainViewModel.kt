package com.enflac.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enflac.myapplication.data.network.response.LoginResponse
import com.enflac.myapplication.data.repository.MainRepository
import com.enflac.myapplication.utils.Coroutines

class MainViewModel(private var aMainRepository: MainRepository) : ViewModel() {

    private val TAG: String = MainViewModel::class.java.simpleName

    var aUserLoggedin = MutableLiveData<LoginResponse>()


    init {

        val alog = LoginResponse()
        //  alog.token = "qwqwqwqwqwqw"
        aUserLoggedin.postValue(alog) //postvalue value update immediate but waiting for main thread ui update

        val alog1 = LoginResponse()
        // alog1.token = "aaaaaaaaa"
        aUserLoggedin.value = alog1   //setvalue immediately setvalue

        //callsimple()
    }


    fun callsimple(mUserName: String, mPassword: String) {
        Coroutines.io {
            try {
                val aLoginResponse = aMainRepository.userLogin(mUserName, mPassword)
                aUserLoggedin.postValue(aLoginResponse)
            } catch (e: Exception) {
                val aLoginResponse = LoginResponse()
                aLoginResponse.error = e.toString()
                aLoginResponse.token = ""
                aUserLoggedin.postValue(aLoginResponse)
                e.printStackTrace()
            }
        }

    }

}