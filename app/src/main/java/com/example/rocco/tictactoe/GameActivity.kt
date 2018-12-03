package com.example.rocco.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {
    var playerName = ""
    var nbTurn = 0
    var xPlaying = true
    var gameRunning = true
    var score : Score? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        playerName = intent.getStringExtra("name")
        desc_guest.text = "O (" + playerName + ")"

        top_left.setOnClickListener {
            if (top_left.text == "") {
                top_left.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }
        }

        top_center.setOnClickListener {
            if (top_center.text == "") {
                top_center.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }
        }

        top_right.setOnClickListener {
            if (top_right.text == "") {
                top_right.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }
        }

        center_left.setOnClickListener {
            if (center_left.text == "") {
                center_left.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }

        }

        center_center.setOnClickListener {
            if (center_center.text == "") {
                center_center.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }

        }

        center_right.setOnClickListener {
            if (center_right.text == "") {
                center_right.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }
        }

        bottom_left.setOnClickListener {
            if (bottom_left.text == "") {
                bottom_left.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }

        }

        bottom_center.setOnClickListener {
            if (bottom_center.text == "") {
                bottom_center.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }

        }

        bottom_right.setOnClickListener {
            if (bottom_right.text == "") {
                bottom_right.text = getPlayerId()
                togglePlayer()
            }
            val res = checkGameStatus()
            if (res != -1) {
                val statusGame = if (res == 1) "Loose" else "Win"
                Toast.makeText(this@GameActivity, statusGame, Toast.LENGTH_LONG).show()
                goToScore()
            }
        }
    }

    fun getPlayerId () : String {
        return if (xPlaying) "X" else "O"
    }

    fun togglePlayer () {
        xPlaying = !xPlaying
        if (xPlaying) {
            textView_players_turn_guest.visibility = View.VISIBLE
            textView_players_turn_guest2.visibility = View.INVISIBLE
        } else {
            textView_players_turn_guest.visibility = View.INVISIBLE
            textView_players_turn_guest2.visibility = View.VISIBLE
        }
    }

    fun checkGameStatus () : Int {
        // Diag left to right
        if (top_left.text != "" && top_left.text == center_center.text && center_center.text == bottom_right.text) {
            return getWinner(top_left.text)
        }

        // Diag right to left
        if (top_right.text != "" && top_right.text == center_center.text && center_center.text == bottom_left.text) {
            return getWinner(top_right.text)
        }

        // Top row
        if (top_left.text != "" && top_left.text == top_center.text && top_center.text == top_right.text) {
            return getWinner(top_left.text)
        }

        // Center row
        if (center_left.text != "" && center_left.text == center_center.text && center_center.text == center_right.text) {
            return getWinner(center_left.text)
        }

        // Bottom row
        if (bottom_left.text != "" && bottom_left.text == bottom_center.text && bottom_center.text == bottom_right.text) {
            return getWinner(bottom_left.text)
        }

        // Left col
        if (top_left.text != "" && top_left.text == center_left.text && bottom_left.text == top_left.text) {
            return getWinner(top_left.text)
        }

        // Center col
        if (top_center.text != "" && top_center.text == center_center.text && bottom_center.text == top_center.text) {
            return getWinner(top_center.text)
        }

        // right col
        if (top_right.text != "" && top_right.text == center_right.text && bottom_right.text == top_right.text) {
            return getWinner(top_center.text)
        }


        return -1
    }

    fun getWinner (id: CharSequence): Int {
        val gameResult = if (xPlaying) 1 else 3
        score = Score("toto", "today", gameResult)
        gameRunning = false
        return gameResult
    }

    fun goToScore () {
        val explicitIntent = Intent(this@GameActivity, ScoreActivity::class.java)
        startActivity(explicitIntent)
    }
}