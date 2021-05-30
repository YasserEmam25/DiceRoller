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

        rolledButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // get a reference to the button in the xml
        val tvRoll = findViewById<TextView>(R.id.tv_dice)
        // initialize a dice object
        val dice = Dice(6)
        // change the text of the textView
        tvRoll.text = dice.roll().toString()

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