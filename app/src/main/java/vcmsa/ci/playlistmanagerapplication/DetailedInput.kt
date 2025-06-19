package vcmsa.ci.playlistmanagerapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_input)
        //------------------------------------------------------------------------------------------
        val edtArtist = findViewById<EditText>(R.id.edtArtist)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtTitle = findViewById<EditText>(R.id.edtTitle)
        val edtComments = findViewById<EditText>(R.id.edtComments)

        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        btnDisplay.setOnClickListener {     //User entered song details
            val artist = edtArtist.text.toString()
            val rating = edtRating.text.toString().toInt()
            val title = edtTitle.text.toString()
            val comment = edtComments.text.toString()
            //Users information gets sent to the third screen
            val intent = Intent (this, DetailedOutput::class.java)
            intent.putExtra("artist_name", artist)
            intent.putExtra("num_rating", rating)
            intent.putExtra("song_title", title)
            intent.putExtra("comment_info", comment)
            startActivity(intent)
        }
        //Close application
        val btnExit = findViewById<Button>(R.id.btnExit02)
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