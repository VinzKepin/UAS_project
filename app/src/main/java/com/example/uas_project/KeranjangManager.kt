// file: KeranjangManager.kt
package com.example.uas_project

object KeranjangManager {
    private val keranjangList = mutableListOf<KeranjangItem>()

    fun tambahItem(item: KeranjangItem) {
        keranjangList.add(item)
    }

    fun ambilSemuaItem(): List<KeranjangItem> = keranjangList

    fun hapusSemuaItem() {
        keranjangList.clear()
    }
}
