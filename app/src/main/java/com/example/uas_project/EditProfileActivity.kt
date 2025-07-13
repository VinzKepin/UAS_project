package com.example.uas_project

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE)

        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Ambil data lama
        val oldUsername = sharedPreferences.getString("username", "")
        val oldPassword = sharedPreferences.getString("password", "")
        editUsername.setText(oldUsername)
        editPassword.setText(oldPassword)

        btnSave.setOnClickListener {
            val newUsername = editUsername.text.toString()
            val newPassword = editPassword.text.toString()

            if (newUsername.isNotEmpty() && newPassword.isNotEmpty()) {
                sharedPreferences.edit().apply {
                    putString("username", newUsername)
                    putString("password", newPassword)
                    apply()
                }
                Toast.makeText(this, "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
