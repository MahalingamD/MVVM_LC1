package com.enflac.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.enflac.myapplication.databinding.ActivitySecondBinding
import com.enflac.myapplication.utils.ThemeHelper
import com.enflac.myapplication.utils.toast

class SecondActivity : AppCompatActivity() {

    lateinit var mBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mBinding.secondactivity = this

        getBundle()

        lamdafun()

      //  Log.e("Secondcycle", "onCreate")
    }

    private fun getBundle() {
        val bundle: Bundle? = intent.extras
        val aRecValue = bundle?.getString("Passvalue") ?: ""
        toast(aRecValue)
    }

    private fun lamdafun() {

        val amulti = { aNumber: Int ->
            val sq = aNumber * aNumber
            sq
        }

        Log.e("Lamdafunction", "" + amulti(9))

        val aaa: (Int) -> String = { aNumber: Int ->
            aNumber.toString()
        }

        val add = { a: ArrayList<String>, b: String ->
            (a + b).toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("Secondcycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Secondcycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Secondcycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Secondcycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Secondcycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Secondcycle", "onRestart")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("Secondcycle", "onNewIntent")
    }

    fun onNextActivity(aView: View) {
        val aIntent = Intent(this, ThirdActivity::class.java)
        // aIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(aIntent)
    }

    fun onCheckedchange(aBool: Boolean) {
        if (aBool) {
            //  ThemeHelper.applyTheme("darkMode")
            //   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            // val aIntent=intent
            // intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            //  finish()
            //  startActivity(aIntent)
        } else {
            ThemeHelper.applyTheme("lightMode")
            val aIntent = intent
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish()
            startActivity(aIntent)
        }
        //Log.e("ASSSSSSSSS",""+aBool)
    }
}
