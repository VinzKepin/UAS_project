    package com.example.uas_project

    import android.os.Bundle
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.example.uas_project.databinding.ActivityProfileBinding
    import android.content.Intent

    class ProfileActivity : AppCompatActivity() {

        private lateinit var binding: ActivityProfileBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityProfileBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val menuItems = listOf(
                ProfileMenuItem(android.R.drawable.ic_menu_myplaces, "Profile"),
                ProfileMenuItem(android.R.drawable.btn_star, "Favorite"),
                ProfileMenuItem(android.R.drawable.ic_menu_send, "Payment Method"),
                ProfileMenuItem(android.R.drawable.ic_menu_info_details, "Privacy Policy"),
                ProfileMenuItem(android.R.drawable.ic_menu_manage, "Settings"),
                ProfileMenuItem(android.R.drawable.ic_menu_help, "Help"),
                ProfileMenuItem(android.R.drawable.ic_lock_power_off, "Logout", isLogout = true)
            )


            val adapter = ProfileAdapter(menuItems) { item ->
                Toast.makeText(this, "Klik ${item.title}", Toast.LENGTH_SHORT).show()
                // Tambahkan navigasi sesuai item.title jika perlu
            }

            binding.profileMenuList

            binding.menuProfile.setOnClickListener {
                startActivity(Intent(this, EditProfileActivity::class.java))
            }



        }
    }
