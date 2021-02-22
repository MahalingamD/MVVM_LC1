package com.enflac.myapplication

import android.app.Application

class InitAppcation : Application() {

    companion object {
        var aSingleTon: InitAppcation? = null

        fun getInstance(): InitAppcation {
            if (aSingleTon == null) {
                aSingleTon = InitAppcation()
            }
            return aSingleTon as InitAppcation
        }
    }

    override fun onCreate() {
        super.onCreate()
        aSingleTon = this
    }
}