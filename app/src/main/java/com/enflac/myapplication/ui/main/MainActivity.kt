package com.enflac.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enflac.myapplication.R
import com.enflac.myapplication.SecondActivity
import com.enflac.myapplication.databinding.ActivityMainBinding
import com.enflac.myapplication.utils.callIntent
import com.enflac.myapplication.utils.toast

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mViewModel: MainViewModel


    var mUserName = ""
    var mPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //For Night UI
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        mViewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
        mBinding.mainActivity = this
        mBinding.bool = true

        mBinding.viewmodel = mViewModel

        mUserName = "eve.holt@reqres.in"
        mPassword = "cityslicka"

        mViewModel.aUserLoggedin.observe(this, Observer {

            if (it.token.isNotEmpty()) {
                mBinding.bool = true
               // val aIntent = Intent(this, SecondActivity::class.java)
              //  startActivity(aIntent)

                val aBundle=Bundle()
                aBundle.putString("Passvalue","123")

                callIntent(this,SecondActivity::class,aBundle)
            } else {
                toast(it.error)
                mBinding.bool = true
            }
        })

        Log.e("cycle", "onCreate")

        //  finish()

    }


    override fun onStart() {
        super.onStart()
        Log.e("cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("cycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("cycle", "onRestart")
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("cycle", "onNewIntent")
    }

    fun onNextActivity() {
        // Log.e("buttonClick", "buttonClick")
        mBinding.bool = false

        mUserName = mBinding.UserNameEdit.text.toString()
        mPassword = mBinding.PasswordEdit.text.toString()

        mViewModel.callsimple(mUserName, mPassword)
    }


    /*  inner class GetAsyncTask : CoRoutineAsyncTask<Int, Int, String>() {

          private val SPLASH_DELAY_TIME: Long = 10000
          lateinit var aProgress: ProgressBar
          override fun onPreExecute() {
              super.onPreExecute()
              mainprogress.visibility = View.VISIBLE

              Log.e("cycle", "onPreExecute")
          }

          override suspend fun doInBackground(vararg values: Int?): String {
              Log.e("cycle", "doInBackground")

              try {
                  Thread.sleep(SPLASH_DELAY_TIME)
              } catch (e: Exception) {
                  e.printStackTrace()
              }

              return "DONE"
          }

          override suspend fun onProgressUpdate(vararg values: Int?) {
              val progress = values[0] ?: 0

          }

          override fun onPostExecute(result: String?) {
              super.onPostExecute(result)
              Log.e("cycle", "onPostExecute")
              if (result == "DONE") {
                  // aProgress.visibility=View.GONE
                  mainprogress.visibility = View.GONE
                  button.visibility = View.VISIBLE
                //  button.text = "Done"
                  Log.e("cycle", "DONE")
              }
          }

      }*/
}
