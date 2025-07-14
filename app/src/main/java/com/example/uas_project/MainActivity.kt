package com.example.uas_project

import android.content.Intent
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

        setupBanner()
        setupProduk()
        setupKategori()
        setupBottomNav()

        binding.btnKeranjang.setOnClickListener {
            startActivity(Intent(this, KeranjangActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        updateKeranjangBadge()
    }

    private fun updateKeranjangBadge() {
        val cartItems = CheckoutPrefs.getCart(this)
        val jumlahItem = cartItems.sumOf { it.jumlah }

        if (jumlahItem > 0) {
            binding.badgeKeranjang.text = jumlahItem.toString()
            binding.badgeKeranjang.visibility = android.view.View.VISIBLE
        } else {
            binding.badgeKeranjang.visibility = android.view.View.GONE
        }
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
            Produk(
                "Minyak Ikan",
                R.drawable.fish_oil,
                "Suplemen alami yang mengandung asam lemak omega-3 (EPA & DHA) untuk menjaga kesehatan jantung dan otak.",
                30000
            ),
            Produk(
                "Gaviscon",
                R.drawable.gaviscon,
                "Meredakan gejala sakit maag dan refluks asam lambung dengan cepat.",
                25000
            ),
            Produk(
                "Vicks Vaporub",
                R.drawable.vicks,
                "Balsam oles yang melegakan pernapasan saat flu dan batuk.",
                15000
            )
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
        binding.recyclerKategori.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerKategori.adapter = kategoriAdapter
    }

    private fun setupBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
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
