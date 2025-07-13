package com.example.uas_project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProdukAdapter(private val list: List<Produk>) :
    RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.tv_nama_produk)
        val gambar = view.findViewById<ImageView>(R.id.iv_gambar_produk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = list[position]
        holder.nama.text = produk.nama
        holder.gambar.setImageResource(produk.gambarResId)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailProdukActivity::class.java).apply {
                putExtra("nama_produk", produk.nama)
                putExtra("gambar_produk", produk.gambarResId)
                putExtra("deskripsi_produk", produk.deskripsi)
                putExtra("harga_produk", produk.harga)
            }
        }
    }
}
