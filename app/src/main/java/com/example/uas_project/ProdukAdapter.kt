package com.example.uas_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProdukAdapter(private val context: Context, private val produkList: List<Produk>) :
    RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {

    class ProdukViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambar: ImageView = view.findViewById(R.id.ivGambarProduk)
        val nama: TextView = view.findViewById(R.id.tvNamaProduk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_produk, parent, false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = produkList[position]
        holder.gambar.setImageResource(produk.gambarResId)
        holder.nama.text = produk.nama
    }

    override fun getItemCount(): Int = produkList.size
}
