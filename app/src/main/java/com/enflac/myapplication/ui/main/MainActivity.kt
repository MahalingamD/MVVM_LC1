package com.enflac.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enflac.myapplication.R
import com.enflac.myapplication.SecondActivity
import com.enflac.myapplication.databinding.ActivityMainBinding
import com.enflac.myapplication.utils.CoRoutineAsyncTask
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        mViewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
        mBinding.mainActivity = this

        mViewModel.aUserLoggedin.observe(this, Observer {
            Log.e("token", it.token)
        })

        Log.e("cycle", "onCreate")


        val amulti = { aNumber: Int ->
            val sq = aNumber * aNumber
            sq
        }

        Log.e("Lamdafunction", "" + amulti(9))

        val aaa: (Int) -> String = { aNumber: Int ->
            aNumber.toString()
        }

        val add ={a:ArrayList<String>,b:String->
            (a+b).toString()
        }
        //  finish()
       GetAsyncTask().execute()
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
        Log.e("buttonClick", "buttonClick")

      //  mViewModel.callsimple()

        val aIntent = Intent(this, SecondActivity::class.java)
        // aIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
          startActivity(aIntent)
    }


    inner class GetAsyncTask : CoRoutineAsyncTask<Int, Int, String>() {

        private val SPLASH_DELAY_TIME: Long = 10000
       lateinit var aProgress:ProgressBar
        override fun onPreExecute() {
            super.onPreExecute()
            mainprogress.visibility=View.VISIBLE

            Log.e("cycle","onPreExecute")
        }

          override suspend fun doInBackground(vararg values: Int?): String {
              Log.e("cycle","doInBackground")

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
            Log.e("cycle","onPostExecute")
            if (result == "DONE") {
               // aProgress.visibility=View.GONE
                mainprogress.visibility=View.GONE
                button.visibility=View.VISIBLE
                button.text = "Done"
                Log.e("cycle","DONE")
            }
        }

    }
}
