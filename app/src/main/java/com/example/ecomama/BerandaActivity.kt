package com.example.ecomama

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BerandaActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_beranda)

                // Inisialisasi komponen
                val searchView = findViewById<SearchView>(R.id.searchView)
                val btnPendaur = findViewById<ImageButton>(R.id.btnPendaur)
                val btnTips = findViewById<ImageButton>(R.id.btnTips)
                val btnInfo = findViewById<ImageButton>(R.id.btnInfo)



                // Pengaturan SearchView
                setupSearchView(searchView)

                // Pengaturan click listener untuk tombol
                setupButtonListeners(btnPendaur, btnTips, btnInfo)
            }

            private fun setupSearchView(searchView: SearchView) {
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        // Lakukan pencarian ketika tombol submit ditekan
                        query?.let { performSearch(it) }
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        // Lakukan pencarian real-time saat teks berubah (opsional)
                        newText?.let { performLiveSearch(it) }
                        return true
                    }
                })
            }

            private fun performSearch(query: String) {
                // Implementasi logika pencarian
                Toast.makeText(this, "Mencari: $query", Toast.LENGTH_SHORT).show()
                // Contoh: Bisa diteruskan ke ViewModel atau Repository untuk pencarian lebih lanjut
            }

            private fun performLiveSearch(query: String) {
                // Implementasi pencarian real-time (opsional)
                // Misalnya filter hasil atau suggestion
            }

            private fun setupButtonListeners(
                btnPendaur: ImageButton,
                btnTips: ImageButton,
                btnInfo: ImageButton
            ) {
                btnPendaur.setOnClickListener {
                    // Navigasi ke halaman Daur Ulang
                    navigateToDaurUlang()
                }

                btnTips.setOnClickListener {
                    // Navigasi ke halaman Tips Hemat Energi
                    navigateToHematEnergi()
                }

                btnInfo.setOnClickListener {
                    // Navigasi ke halaman Edu Eco
                    navigateToEduEco()
                }
            }

            private fun navigateToDaurUlang() {
                val intent = Intent(this, DaurUlangActivity::class.java)
                startActivity(intent)
            }

            private fun navigateToHematEnergi() {
                val intent = Intent(this, HematEnergiActivity::class.java)
                startActivity(intent)
            }

            private fun navigateToEduEco() {
                val intent = Intent(this, EduEcoActivity::class.java)
                startActivity(intent)
            }

            // Fungsi tambahan untuk berbagai fitur
            private fun shareEcoTips() {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "Tips Ramah Lingkungan")
                    putExtra(Intent.EXTRA_TEXT, "Mari lestarikan bumi kita! #EcoMama")
                }
                startActivity(Intent.createChooser(shareIntent, "Bagikan Tips Eco"))
            }

            // Contoh fungsi untuk menyimpan preferensi pengguna
            private fun saveUserPreferences(key: String, value: String) {
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString(key, value)
                    apply()
                }
            }

            // Contoh fungsi untuk membaca preferensi pengguna
            private fun getUserPreferences(key: String, defaultValue: String = ""): String {
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                return sharedPref.getString(key, defaultValue) ?: defaultValue
            }


        }

