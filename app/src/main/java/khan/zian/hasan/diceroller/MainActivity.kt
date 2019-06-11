package khan.zian.hasan.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btn_roll)

        rollButton.text = getString(R.string.lets_roll)

        rollButton.setOnClickListener {
             diceRoll()
        }
    }

    private fun diceRoll() {
        mediaPlayer = MediaPlayer.create(this, R.raw.dice_roll_sound)


        val randomInt = Random().nextInt(6) + 1
        val result: ImageView = findViewById(R.id.img_roll_dice_number)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        mediaPlayer?.start()
        result.setImageResource(drawableResource)

    }
}
