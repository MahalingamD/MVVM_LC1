package com.enflac.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.enflac.myapplication.databinding.ActivityThirdBinding
import kotlinx.android.synthetic.main.activity_third.view.*

class ThirdActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_third)
        mBinding.thirdActivity = this
        mBinding.thirdActivity = this


        val aDrawerLayout = mBinding.drawerLayout

        val aNavigationView = mBinding.navView
        val aMenuRecyclerview = aNavigationView.menu_rv

        Log.e("Thirdcycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Thirdcycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Thirdcycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Thirdcycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Thirdcycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Thirdcycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Thirdcycle", "onRestart")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("Thirdcycle", "onNewIntent")
    }

    fun onNextActivity(aView: View) {
        val aIntent = Intent(this, SecondActivity::class.java)
        aIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(aIntent)
    }
}
