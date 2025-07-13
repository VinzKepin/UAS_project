package com.example.uas_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_project.databinding.ActivityDetailProdukBinding
import android.widget.Toast


class DetailProdukActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("nama_produk")
        val gambar = intent.getIntExtra("gambar_produk", 0)
        val deskripsi = intent.getStringExtra("deskripsi_produk")
        val harga = intent.getIntExtra("harga_produk", 0)

        binding.tvNamaProduk.text = nama
        binding.ivGambarProduk.setImageResource(gambar)
        binding.tvDeskripsiProduk.text = deskripsi
        binding.tvHargaProduk.text = "Rp $harga"
        binding.btnTambahKeranjang.setOnClickListener {
            Toast.makeText(this, "$nama ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
        }
    }
}
