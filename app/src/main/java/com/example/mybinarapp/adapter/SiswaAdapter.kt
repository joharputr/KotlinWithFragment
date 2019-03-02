package com.example.mybinarapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybinarapp.R
import com.example.mybinarapp.model.Siswa
import kotlinx.android.synthetic.main.item_siswa.view.*

//generic class
//higher order function
//
class SiswaAdapter(private val siswaList: List<Siswa>,
                   private val onClick:(siswa:Siswa)-> Unit,
                   private val onLongClick:(siswa:Siswa)-> Unit
): RecyclerView.Adapter<SiswaAdapter.Holder>() {
    override fun onCreateViewHolder(group: ViewGroup, type: Int): Holder {
        val layoutInflater = LayoutInflater.from(group.context)
        val view: View = layoutInflater.inflate(R.layout.item_siswa,group,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = siswaList.size /*{
       return siswaList.size
    }*/

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //position = index
        val siswa = siswaList[position]
       holder.bind(siswa)
        holder.itemView.setOnClickListener {
            onClick(siswa)
        }
        holder.itemView.setOnLongClickListener {
            onLongClick(siswa)
            return@setOnLongClickListener true
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(siswa: Siswa) = itemView.run {
            tvStudentName.text = siswa.nama
            tvStudentEmail.text = siswa.email
        }
    }
}