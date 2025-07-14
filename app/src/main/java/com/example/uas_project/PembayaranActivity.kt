package com.example.uas_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_project.databinding.ActivityPembayaranBinding

class PembayaranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPembayaranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data cart dari SharedPreferences
        val cartItems = CheckoutPrefs.getCart(this)

        // Set adapter ke RecyclerView
        binding.recyclerPembayaran.layoutManager = LinearLayoutManager(this)
        val adapter = KeranjangAdapter(cartItems)
        binding.recyclerPembayaran.adapter = adapter

        // Hitung total dan tampilkan
        val totalHarga = cartItems.sumOf { it.harga * it.jumlah }
        binding.tvTotalBayar.text = "Total Bayar: Rp $totalHarga"
    }
}
