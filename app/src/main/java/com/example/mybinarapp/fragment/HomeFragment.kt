package com.example.mybinarapp.fragment
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mybinarapp.BuildConfig
import com.example.mybinarapp.R
import com.example.mybinarapp.adapter.SiswaAdapter
import com.example.mybinarapp.common.toast
import com.example.mybinarapp.model.Siswa
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    companion object {
        //mebuat objek dari kelas homefragment
        fun newInstance() = HomeFragment()
    }

    private val siswaList = mutableListOf<Siswa>()
  /*  private val siswaAdapter = SiswaAdapter(siswaList, this::onItemCLick, this::onLongClick)
*/
    private val siswaAdapter = SiswaAdapter(siswaList,{
      onItemCLick(it)
  },{
      onLongClick(it)
  })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //isi dari view
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //cuma di fragment doang
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        //getsiswa = manggil data
        getSiswa()
        val url = if (BuildConfig.DEBUG)
            "Mode Debug : ${BuildConfig.BASE_URL}"
        else
            "Mode Release: ${BuildConfig.BASE_URL}"
        toast(url)
    }

    private fun setupView() = view?.run{
        //layout manager = mengatur layout recycler view
        //horizontal = setup atributSet
        rvSiswa.run {
            // layout baris kebawah
            layoutManager = LinearLayoutManager(context)
            adapter = siswaAdapter
        }
    }
    //load data
   private  fun getSiswa(){
       (0..15).forEach{
           val siswa  = Siswa("Student $it", "Student$it@gmail.com")
           siswaList.add(siswa)
       }
       //sinkron data di adapter setiap ada perubahan
       siswaAdapter.notifyDataSetChanged()
   }

    private fun onLongClick(it: Siswa) {
        toast("Longclick : ${it.nama}")
    }

    private fun onItemCLick(it: Siswa) {
        toast("Click : ${it.email}")
    }

}
