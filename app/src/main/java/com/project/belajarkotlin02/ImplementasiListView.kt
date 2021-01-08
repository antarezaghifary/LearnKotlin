package com.project.belajarkotlin02

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.project.belajarkotlin02.adapter.ListViewAdapter
import com.project.belajarkotlin02.model.Anggota

class ImplementasiListView : AppCompatActivity() {

    private lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_list_view)

        list = findViewById(R.id.list)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Rafi",876543, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Ulwa",876543, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Pratama",876543, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Mruput",876543, R.drawable.mg,"Malang"))

        val adapter = ListViewAdapter(this, listAnggota)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this,listAnggota.get(position).nama, Toast.LENGTH_LONG).show()

            Dialog(this).apply{
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list_item)

                val image = this.findViewById<ImageView>(R.id.image)
                val nama = this.findViewById<TextView>(R.id.textNama)
                val noHP = this.findViewById<TextView>(R.id.textNohp)
                val alamat = this.findViewById<TextView>(R.id.textAlamat)
                val btnClose = this.findViewById<Button>(R.id.btnClose)

                val item = listAnggota.get(position)

                image.setImageResource(item.foto)
                nama.text = "Nama : ${item.nama}"
                noHP.text = "Nama : ${item.nohp}"
                alamat.text = "Nama : ${item.alamat}"


                btnClose.setOnClickListener {
                    this.dismiss()
                }
            }.show()
        }
    }
}