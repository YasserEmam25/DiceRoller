package com.yemam.dicerolleer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow the user to roll a dice and display the result in a textView
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rolledButton: Button = findViewById(R.id.btn_dice)

        rolledButton.setOnClickListener { rollDices() }
    }

    private fun rollDices() {
        // get a reference to the button in the xml
        val tvRoll1 = findViewById<TextView>(R.id.tv_dice1)
        val tvRoll2 = findViewById<TextView>(R.id.tv_dice2)

        // initialize a dice object
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // change the text of the textViews
        tvRoll1.text = dice1.roll().toString()
        tvRoll2.text = dice2.roll().toString()

        // display a message to the user
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG).show()
    }
}

/**
 * this class is blueprint to the dice
 */

class Dice(private val sides: Int) {
    /**
     * this rolls the dice and returns a random number
     */
    fun roll(): Int {
        return (1..sides).random()
    }
}