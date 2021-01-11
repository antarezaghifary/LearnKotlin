package com.project.belajarkotlin02

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.belajarkotlin02.adapter.AdapterRecyclerView
import com.project.belajarkotlin02.model.Anggota
import org.w3c.dom.Text

class ActivityImplementRecyclerView : AppCompatActivity() {

    private lateinit var list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implement_recycler_view)

        list = findViewById<RecyclerView>(R.id.list)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Enter",865787898, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Enter",865787898, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Enter",865787898, R.drawable.mg,"Malang"))
        listAnggota.add(Anggota("Enter",865787898, R.drawable.mg,"Malang"))

        list.adapter = AdapterRecyclerView(this, listAnggota, object : AdapterRecyclerView.OnClickListener{
            override fun detailData(item: Anggota?) {
                Dialog(this@ActivityImplementRecyclerView).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_list_item)

                    val image = this.findViewById<ImageView>(R.id.image)
                    val nama = this.findViewById<TextView>(R.id.textNama)
                    val nohp = this.findViewById<TextView>(R.id.textNohp)
                    val alamat = this.findViewById<TextView>(R.id.textAlamat)
                    val close = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto?:0)
                    nama.text = "Nama : ${item?.nama}"
                    nohp.text = "No Hp : ${item?.nohp}"
                    alamat.text = "Alamat : ${item?.alamat}"

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })
    }
}