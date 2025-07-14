package com.example.uas_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KeranjangAdapter(private val list: List<KeranjangItem>) :
    RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.tv_nama_keranjang)
        val gambar = view.findViewById<ImageView>(R.id.iv_gambar_keranjang)
        val harga = view.findViewById<TextView>(R.id.tv_harga_keranjang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_keranjang, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.nama.text = item.nama
        holder.gambar.setImageResource(item.gambarResId)
        holder.harga.text = "Rp ${String.format("%,d", item.harga)}"
    }
}
