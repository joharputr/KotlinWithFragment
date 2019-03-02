package com.example.mybinarapp.common

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

fun Context.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
fun Fragment.toast(message: String){
  requireContext().toast(message)
}
