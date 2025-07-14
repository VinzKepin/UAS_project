package com.example.uas_project

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object CheckoutPrefs {
    private const val PREF_NAME = "checkout_data"
    private const val KEY_CART = "cart_items"

    fun saveCart(context: Context, cartItems: List<KeranjangItem>) {
        val sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        val jsonArray = JSONArray()
        for (item in cartItems) {
            val obj = JSONObject()
            obj.put("nama", item.nama)
            obj.put("gambar", item.gambarResId)
            obj.put("harga", item.harga)
            obj.put("jumlah", item.jumlah)
            jsonArray.put(obj)
        }

        editor.putString(KEY_CART, jsonArray.toString())
        editor.apply()
    }

    fun getCart(context: Context): List<KeranjangItem> {
        val sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val data = sharedPrefs.getString(KEY_CART, null) ?: return emptyList()

        val jsonArray = JSONArray(data)
        val result = mutableListOf<KeranjangItem>()

        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)
            result.add(
                KeranjangItem(
                    obj.getString("nama"),
                    obj.getInt("gambar"),
                    obj.getInt("harga"),
                    obj.getInt("jumlah")
                )
            )
        }

        return result
    }

    fun clearCart(context: Context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit().clear().apply()
    }
}
