package com.example.uas_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_project.databinding.ActivityDetailProdukBinding

class DetailProdukActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val nama = intent.getStringExtra("nama_produk")
        val gambar = intent.getIntExtra("gambar_produk", 0)
        val deskripsi = intent.getStringExtra("deskripsi_produk")
        val harga = intent.getIntExtra("harga_produk", 0)

        // Tampilkan data di UI
        binding.tvNamaProduk.text = nama
        binding.ivGambarProduk.setImageResource(gambar)
        binding.tvDeskripsiProduk.text = deskripsi
        binding.tvHargaProduk.text = "Rp $harga"

        // Ketika tombol diklik
        binding.btnTambahKeranjang.setOnClickListener {
            // Buat intent ke halaman keranjang
            val item = KeranjangItem(
                nama = nama ?: "",
                gambarResId = gambar,
                harga = harga,
                jumlah = 1
            )
            binding.btnTambahKeranjang.setOnClickListener {
                val item = KeranjangItem(
                    nama = nama ?: "",
                    gambarResId = gambar,
                    harga = harga,
                    jumlah = 1
                )

                val currentList = CheckoutPrefs.getCart(this).toMutableList()

                val existing = currentList.find { it.nama == item.nama }
                if (existing != null) {
                    existing.jumlah += 1
                } else {
                    currentList.add(item)
                }

                CheckoutPrefs.saveCart(this, currentList)

                Toast.makeText(this, "$nama berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
