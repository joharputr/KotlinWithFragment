package com.example.mybinarapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mybinarapp.BinarApp
import com.example.mybinarapp.R
import com.example.mybinarapp.common.Constant
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupView()
        testPreference()
        cekUser()

    }

    private fun cekUser() {
        val name = BinarApp.sp.nama
        if (name.isNotBlank()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun testPreference() {
        //java Style
        /*val sp = BinarApp().sp*/  //untuk buat objek
      /*  val sp = BinarApp.sp //menggunakan static agar tidak usah bikin objek lagi

           //java style
        sp.putString(Constant.NAMA, "ilham") //key harus beda
        sp.putString(Constant.IG, "ilham")
        sp.putString(Constant.EMAIL ,"ilham@gmail.com")

        val nama = sp.getString(key = Constant.NAMA)
        val ig = sp.getString(key = Constant.IG)
        val email = sp.getString(key = Constant.EMAIL)

        println("nama: {$nama}")
        println("ig: $ig")
        println("email :$email" )
        //end java style


        //kotlin stylr
        sp.nama = "ilham"
        sp.ig = "ilham"
        sp.email = "ilham"

        println("nama: ${sp.nama}")
        println("ig: ${sp.ig}")
        println("email :${sp.email}" )
        //end kotlin style*/
    }

    private fun setupView() {
     login.setOnClickListener {
         loginn()
     }
    }
    private fun loginn() {
      //  val wp = BinarApp.sp
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        if (username == "ilham" && password =="1"){
           showMessage("Login sukses")
           BinarApp.sp.nama = username //mengisi value berdasarkaan inputan
          //  wp.nama = username
            startActivity(Intent(this, MainActivity::class.java))
            finish() //agar tidak balik ke login lg
           /* val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)*/
        }else{
           showMessage("password salah")
        }
    }
    private fun showMessage(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
