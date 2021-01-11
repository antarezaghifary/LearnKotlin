package com.project.belajarkotlin02.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.belajarkotlin02.R
import com.project.belajarkotlin02.model.Anggota

class AdapterRecyclerView (
    private var context: Context,
    private var data: ArrayList<Anggota>?,
    private var itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

        return view
    }

    override fun getItemCount(): Int = data?.size?:0

    override fun onBindViewHolder(holder: AdapterRecyclerView.ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.nama.text = item?.nama
        holder.foto.setImageResource(item?.foto?:0)

        holder.view.setOnClickListener{
            itemClick.detailData(item)
        }

    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var foto = view.findViewById<ImageView>(R.id.image)
        var nama = view.findViewById<TextView>(R.id.nama)

    }
interface OnClickListener{
    fun detailData(item: Anggota?)
}
}