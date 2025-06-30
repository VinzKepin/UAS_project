package com.example.uas_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter(private val context: Context, private val kategoriList: List<Kategori>) :
    RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

    class KategoriViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambar: ImageView = view.findViewById(R.id.ivGambarKategori)
        val nama: TextView = view.findViewById(R.id.tvNamaKategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_kategori, parent, false)
        return KategoriViewHolder(view)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val kategori = kategoriList[position]
        holder.gambar.setImageResource(kategori.gambarResId)
        holder.nama.text = kategori.nama
    }

    override fun getItemCount(): Int = kategoriList.size
}
