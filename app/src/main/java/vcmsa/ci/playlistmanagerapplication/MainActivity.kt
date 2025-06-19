package vcmsa.ci.playlistmanagerapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //------------------------------------------------------------------------------------------
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {    //Navigates to the second screen + Asked to enter details
            val message = "Enter playlist details"
            val intent = Intent (this,DetailedInput::class.java)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()    /*Android Developers
            (2024)*/
            startActivity(intent)
        }
        //Close application
        val btnExit = findViewById<Button>(R.id.btnExit01)
        btnExit.setOnClickListener {
            finishAffinity()
        }
        //------------------------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}