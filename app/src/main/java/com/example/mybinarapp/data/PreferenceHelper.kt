package com.example.mybinarapp.data

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mybinarapp.common.Constant


//context digunakan untuk mengakses fitur android

/*

class PH(context: Context) {
    //lazy = teknik inisialisasi di kotlin menunggu dipanggil

    */
/* private val sp : SharedPreferences = app.getSharedPreferences("my_binar_app",Context.MODE_PRIVATE)*//*

    private val sp : SharedPreferences by lazy {
        context.getSharedPreferences("my_binar_app", Context.MODE_PRIVATE)  }
*/

class PH(gg : Context) {
    //lazy = teknik inisialisasi di kotlin menunggu dipanggil

    /* private val sp : SharedPreferences = app.getSharedPreferences("my_binar_app",Context.MODE_PRIVATE)*/
   private val sp : SharedPreferences by lazy {
        gg.getSharedPreferences("my_binar_app", Context.MODE_PRIVATE)  }


    private val spe: SharedPreferences.Editor by lazy {
        sp.edit()
}

    //java style
    fun putString(key:String , value:String){
        spe.putString(key,value).apply()
        //apply = bacnkgourd thread
        //commit = main thread
    }
   /* fun getString(key: String):String?{
        return sp.getString(key,"")
    }*/
    fun getString(key: String):String{
        return sp.getString(key,"")?:""
    }
    //end java style


    var nama : String
    set(aa) {
        spe.putString(Constant.NAMA, aa).apply()
    }
    get() = sp.getString(Constant.NAMA, "")?:""


    var ig : String
    set(value) {
        spe.putString(Constant.IG, value).apply()
    }
    get() = sp.getString(Constant.IG, "")?:""

    var email : String
        set(value) {
            spe.putString(Constant.EMAIL, value).apply()
        }
        get() = sp.getString(Constant.EMAIL, "")?:""

    fun logOut(){
        spe.clear().apply()
    }
}