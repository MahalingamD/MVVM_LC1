package com.enflac.myapplication.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.enflac.myapplication.SecondActivity
import kotlin.reflect.KClass

fun Context.toast(aMsg: String) {
    Toast.makeText(this, aMsg, Toast.LENGTH_SHORT).show()
}


fun callIntent(aContext: Context, aClass: KClass<SecondActivity>,aBundle: Bundle) {
    val aIntent =Intent(aContext,aClass.java)
    aIntent.putExtras(aBundle)
    aContext.startActivity(aIntent)
}