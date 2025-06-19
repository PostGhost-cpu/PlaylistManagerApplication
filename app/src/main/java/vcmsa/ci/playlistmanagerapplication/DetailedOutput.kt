package vcmsa.ci.playlistmanagerapplication

import android.content.Intent
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedOutput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_output)
        //------------------------------------------------------------------------------------------
        //Users inputted song details
        val usersArtist = intent.getStringExtra("artist_name")
        val usersRating = intent.getStringExtra("num_rating")
        val usersTitle = intent.getStringExtra("song_title")
        val usersComments = intent.getStringExtra("comment_info")
        /*User song information is then stored in an array
        IMAD5112_MM four parallel arrays (2025, p17)*/
        val artist = arrayOf("A-Reece","J.Cole","Travis Scott","Quavo","Playboi Carti","$usersArtist")
        val rating = arrayOf(5, 5, 5, 4, 5, "$usersRating")
        val title = arrayOf("MORNING PEACE","FRIENDS","90210","glacier","LIKE WEEZY","$usersTitle")
        val comments = arrayOf("tttm mixtape","KOD","Rodeo","ATLANTA","IAMMUSIC","$usersComments")
        /*for loop together with the in operator
        w3schools (2025)*/
        val numberDisplay = findViewById<TextView>(R.id.numberDisplay)
        var numberSet = " "
        for (q in 1..6) {
            numberSet += "$q\n"
        }
        numberDisplay.text = numberSet
        /*Manually include an array loop
        IMAD5112_MM Arrays (2025, p79)*/
        val titleDisplay = findViewById<TextView>(R.id.titleDisplay)

        var songTitle = " "     //Song title display
        songTitle += "${title[0]}\n"
        songTitle += "${title[1]}\n"
        songTitle += "${title[2]}\n"
        songTitle += "${title[3]}\n"
        songTitle += "${title[4]}\n"
        songTitle += "${title[5]}\n"
        titleDisplay.text = songTitle

        val artistDisplay = findViewById<TextView>(R.id.artistDisplay)

        var songArtist = " "     //Artist name display
        songArtist += "${artist[0]}\n"
        songArtist += "${artist[1]}\n"
        songArtist += "${artist[2]}\n"
        songArtist += "${artist[3]}\n"
        songArtist += "${artist[4]}\n"
        songArtist += "${artist[5]}\n"
        artistDisplay.text = songArtist

        val ratingDisplay = findViewById<TextView>(R.id.ratingDisplay)

        var songRating = " "     //Number rating display
        songRating += "${rating[0]}\n"
        songRating += "${rating[1]}\n"
        songRating += "${rating[2]}\n"
        songRating += "${rating[3]}\n"
        songRating += "${rating[4]}\n"
        songRating += "${rating[5]}\n"
        ratingDisplay.text = songRating

        val commentsDisplay = findViewById<TextView>(R.id.commentsDisplay)

        var response = " "     //User comment display
        response += "${comments[0]}\n"
        response += "${comments[1]}\n"
        response += "${comments[2]}\n"
        response += "${comments[3]}\n"
        response += "${comments[4]}\n"
        response += "${comments[5]}\n"
        commentsDisplay.text = response
        //Calculates + Displays the average rating
        val averageDisplay = findViewById<TextView>(R.id.averageDisplay)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        btnAverage.setOnClickListener {
            val message = "Average rating"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            val total = rating[0] + rating[1] + rating[2] + rating[3] + rating[4] + rating[5]
            val average = total.toDouble() / 6
            averageDisplay.text = "Average rating given: %.2f".format(average)
        }
        //Return to main screen
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }
        //------------------------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}