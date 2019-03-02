package com.example.mybinarapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DialogTitle
import com.example.mybinarapp.BinarApp
import com.example.mybinarapp.R
import com.example.mybinarapp.fragment.HomeFragment
import com.example.mybinarapp.fragment.MateriFragment
import com.example.mybinarapp.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//fragment di atas activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    /*tv_nama.text = "${BinarApp.sp.nama}"
    button.setOnClickListener {
        BinarApp.sp.logOut()
      //  finish()
      startActivity(Intent(this,Login::class.java))
        }*/

        setupView()
    }

    //membuat tampilan tiap fragment
    private fun setupView() {
        //menjalankan di awal
        setFragment(HomeFragment.newInstance(), getString(R.string.home))

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome-> setFragment(HomeFragment.newInstance(), getString(R.string.home))/*{
                    title = getString(R.string.home)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,HomeFragment.newInstance())
                        .commit()
                }*/
                R.id.navMateri-> setFragment(MateriFragment.newInstance(), getString(R.string.materi))/*{
                    title = getString(R.string.materi)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container,MateriFragment.newInstance())
                            .commit()
                }*/
                R.id.navProfile->/*{
                    title = getString(R.string.profile)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container,profileFragment.newInstance())
                        .commit()
                }*/
                setFragment(ProfileFragment.newInstance(), getString(R.string.profile))
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setFragment(fragment : Fragment, title: String ) {
        this.title = title
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }
}
