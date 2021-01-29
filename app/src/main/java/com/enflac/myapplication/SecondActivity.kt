package com.enflac.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.enflac.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var mBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        mBinding.secondactivity = this

        Log.e("Secondcycle", "onCreate")
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
}
