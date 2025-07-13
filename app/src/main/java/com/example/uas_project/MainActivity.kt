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
            Produk("Minyak Ikan", R.drawable.fish_oil, "Suplemen alami yang mengandung asam lemak omega-3 (EPA & DHA) yang bermanfaat untuk menjaga kesehatan jantung, menurunkan kadar trigliserida, serta mendukung fungsi otak dan sendi. Cocok untuk dikonsumsi rutin guna mendukung gaya hidup sehat.", 30000),
            Produk("Gaviscon", R.drawable.gaviscon, "Obat yang bekerja cepat meredakan gejala sakit maag, nyeri ulu hati, dan asam lambung naik. Gaviscon membentuk lapisan pelindung di atas isi lambung untuk mencegah iritasi pada kerongkongan, memberikan rasa lega dalam hitungan menit. Cocok untuk digunakan setelah makan atau saat gejala muncul.", 25000),
            Produk("Vicks Vaporub", R.drawable.vicks, "Balsam oles yang efektif meredakan gejala flu seperti hidung tersumbat, batuk, dan pegal-pegal. Mengandung menthol, camphor, dan eucalyptus oil yang memberikan sensasi hangat dan melegakan saluran pernapasan. Cocok digunakan sebelum tidur untuk tidur lebih nyenyak saat flu.", 15000)
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