package com.example.mybinarapp

import android.app.Application
import com.example.mybinarapp.activity.MainActivity
import com.example.mybinarapp.data.PH



//kelas Aplikasi
//anak dari kelas application
//eksekusi ketika aplikasi dibuka
//kelas yang pertama kali dijalankan
class BinarApp : Application() {
    //lateinit teknik untuk deklarasi variabel yang nilai awal belum ada (null)
    //    //sp akan bernilai bila oncreate akan dieksekusi

    //static
    //agar sp bisa digunakan tanpa membuat objek
    companion object {

        //deklarasi
        lateinit var sp:PH

        //membuat database
    }

    override fun onCreate() {
        super.onCreate()
        // ini buat apa?
        sp = PH(this)
    }
}