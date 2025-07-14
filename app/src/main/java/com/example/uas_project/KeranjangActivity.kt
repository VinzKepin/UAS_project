package com.example.uas_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_project.databinding.ActivityKeranjangBinding
import android.widget.Toast
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager




class KeranjangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeranjangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeranjangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 👉 Jangan tulis override fun di dalam sini lagi!
        val cartItems = CheckoutPrefs.getCart(this)

        val adapter = KeranjangAdapter(cartItems)
        binding.recyclerKeranjang.layoutManager = LinearLayoutManager(this)
        binding.recyclerKeranjang.adapter = adapter

        val total = cartItems.sumOf { it.harga * it.jumlah }
        binding.tvTotalHarga.text = "Total: Rp $total"

        binding.btnCheckout.setOnClickListener {
            Toast.makeText(this, "Checkout tersimpan!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PembayaranActivity::class.java))
        }
    }

    // Jika kamu perlu fungsi tambahan (tanpa override), bisa di luar onCreate
    private fun contohFungsiTambahan() {
        // kode di sini
    }
}

