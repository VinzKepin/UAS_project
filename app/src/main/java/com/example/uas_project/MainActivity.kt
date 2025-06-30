package com.example.uas_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupProduk()
        setupKategori()
        setupBottomNav()
    }

    private fun setupProduk() {
        val produkList = listOf(
            Produk("Minyak Ikan", R.drawable.fish_oil),
            Produk("Gaviscon", R.drawable.gaviscon),
            Produk("Vicks Vaporub", R.drawable.vicks)
        )

        val produkAdapter = ProdukAdapter(this, produkList)
        binding.recyclerProduk.layoutManager = LinearLayoutManager(this)
        binding.recyclerProduk.adapter = produkAdapter
    }

    private fun setupKategori() {
        val kategoriList = listOf(
            Kategori("Serum", R.drawable.serum),
            Kategori("Sirup Anak", R.drawable.sirup),
            Kategori("Salep", R.drawable.salep)
        )

        val kategoriAdapter = KategoriAdapter(this, kategoriList)
        binding.recyclerKategori.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerKategori.adapter = kategoriAdapter
    }

    private fun setupBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_history -> true
                R.id.nav_scan -> true
                R.id.nav_settings -> true
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}