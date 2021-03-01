package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun resetGame(view: View){
        findViewById<Button>(R.id.tile00).isEnabled = true
        findViewById<Button>(R.id.tile01).isEnabled = true
        findViewById<Button>(R.id.tile02).isEnabled = true
        findViewById<Button>(R.id.tile10).isEnabled = true
        findViewById<Button>(R.id.tile11).isEnabled = true
        findViewById<Button>(R.id.tile12).isEnabled = true
        findViewById<Button>(R.id.tile20).isEnabled = true
        findViewById<Button>(R.id.tile21).isEnabled = true
        findViewById<Button>(R.id.tile22).isEnabled = true

        findViewById<Button>(R.id.tile00).text = ""
        findViewById<Button>(R.id.tile01).text = ""
        findViewById<Button>(R.id.tile02).text = ""
        findViewById<Button>(R.id.tile10).text = ""
        findViewById<Button>(R.id.tile11).text = ""
        findViewById<Button>(R.id.tile12).text = ""
        findViewById<Button>(R.id.tile20).text = ""
        findViewById<Button>(R.id.tile21).text = ""
        findViewById<Button>(R.id.tile22).text = ""

        findViewById<TextView>(R.id.turn_view).text = "X"
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID: String = ""
        when (buSelected.id) {
            R.id.tile00 -> cellID = "00"
            R.id.tile01 -> cellID = "01"
            R.id.tile02 -> cellID = "02"
            R.id.tile10 -> cellID = "10"
            R.id.tile11 -> cellID = "11"
            R.id.tile12 -> cellID = "12"
            R.id.tile20 -> cellID = "20"
            R.id.tile21 -> cellID = "21"
            R.id.tile22 -> cellID = "22"
        }
    }
    var player1 = ArrayList<String>()
    var player2 = ArrayList<String>()

    var activePlayer = 1
    private fun playGame(cellID: String, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X"
            player1.add(cellID)
            activePlayer = 2
        } else {
            buSelected.text = "O"
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner(buSelected)
    }

    private fun checkWinner(view: View) {
        var winner = -1

        // row1 check
        if (player1.contains("00") && player1.contains("01") && player1.contains("02")) {
            winner = 1
        }
        if (player2.contains("00") && player2.contains("01") && player2.contains("02")) {
            winner = 2
        }

        // row2 check
        if (player1.contains("10") && player1.contains("11") && player1.contains("12")) {
            winner = 1
        }
        if (player2.contains("10") && player2.contains("11") && player2.contains("12")) {
            winner = 2
        }

        // row3 check
        if (player1.contains("20") && player1.contains("21") && player1.contains("22")) {
            winner = 1
        }
        if (player2.contains("20") && player2.contains("21") && player2.contains("22")) {
            winner = 2
        }

        // col1 check
        if (player1.contains("00") && player1.contains("10") && player1.contains("20")) {
            winner = 1
        }
        if (player2.contains("00") && player2.contains("10") && player2.contains("20")) {
            winner = 2
        }

        //col2 check
        if (player1.contains("01") && player1.contains("11") && player1.contains("21")) {
            winner = 1
        }
        if (player2.contains("01") && player2.contains("11") && player2.contains("21")) {
            winner = 2
        }

        // col3 check
        if (player1.contains("02") && player1.contains("12") && player1.contains("22")) {
            winner = 1
        }
        if (player2.contains("02") && player2.contains("12") && player2.contains("22")) {
            winner = 2
        }

        // diag1 check
        if (player1.contains("00") && player1.contains("11") && player1.contains("22")) {
            winner = 1
        }
        if (player2.contains("00") && player2.contains("11") && player2.contains("22")) {
            winner = 2
        }

        // diag2 check
        if (player1.contains("02") && player1.contains("11") && player1.contains("20")) {
            winner = 1
        }
        if (player2.contains("02") && player2.contains("11") && player2.contains("20")) {
            winner = 2
        }




        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, "Player1 is winner", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player2 is winner", Toast.LENGTH_LONG).show()
            }

            findViewById<Button>(R.id.tile00).isEnabled = false
            findViewById<Button>(R.id.tile01).isEnabled = false
            findViewById<Button>(R.id.tile02).isEnabled = false
            findViewById<Button>(R.id.tile10).isEnabled = false
            findViewById<Button>(R.id.tile11).isEnabled = false
            findViewById<Button>(R.id.tile12).isEnabled = false
            findViewById<Button>(R.id.tile20).isEnabled = false
            findViewById<Button>(R.id.tile21).isEnabled = false
            findViewById<Button>(R.id.tile22).isEnabled = false

        }
    }

}