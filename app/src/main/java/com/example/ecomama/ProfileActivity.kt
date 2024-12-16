import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ecomama.HLBerandaActivity
import com.example.ecomama.R


class ProfileActivity : AppCompatActivity() {
    private var userName: String = ""
    private var totalPoints: Int = 0
    private var challenges: Int = 0
    private var badges: Int = 0
    private var level: Int = 0 // Tambahan variabel level
    private var remainingXP: Int = 0 // Tambahan variabel sisa XP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            // Buka halaman Beranda
            val intent = Intent(this, HLBerandaActivity::class.java)
            startActivity(intent)
        }


    }
}