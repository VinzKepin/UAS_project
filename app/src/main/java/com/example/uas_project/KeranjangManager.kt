package com.example.uas_project

object KeranjangManager {
    val daftarKeranjang = mutableListOf<KeranjangItem>()

    fun tambahItem(item: KeranjangItem) {
        // Cek apakah produk sudah ada
        val existing = daftarKeranjang.find { it.nama == item.nama }
        if (existing != null) {
            // Kalau ada, tambahkan jumlahnya
            val index = daftarKeranjang.indexOf(existing)
            val updated = existing.copy(jumlah = existing.jumlah + 1)
            daftarKeranjang[index] = updated
        } else {
            daftarKeranjang.add(item)
        }
    }
}
