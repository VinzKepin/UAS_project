package com.example.uas_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_project.databinding.ActivityMainBinding
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBanner()
        setupProduk()
        setupKategori()
        setupBottomNav()

    }

    private fun setupBanner() {
        val bannerImages = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner4
        )

        val bannerAdapter = BannerAdapter(bannerImages)
        binding.bannerViewPager.adapter = bannerAdapter
    }

    private fun setupProduk() {
        val produkList = listOf(
            Produk("Minyak Ikan", R.drawable.fish_oil, "Membantu menjaga kesehatan jantung", 30000),
            Produk("Gaviscon", R.drawable.gaviscon, "Obat untuk mengatasi sakit maag", 25000),
            Produk("Vicks Vaporub", R.drawable.vicks, "Meredakan gejala flu dan pilek", 15000)
        )

        val produkAdapter = ProdukAdapter(produkList)
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
                R.id.nav_home -> {
                    true // sudah di halaman ini
                }
                R.id.nav_history -> {
                    startActivity(Intent(this, HistoryActivity::class.java))
                    true
                }
                R.id.nav_scan -> {
                    startActivity(Intent(this, ScanActivity::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

}