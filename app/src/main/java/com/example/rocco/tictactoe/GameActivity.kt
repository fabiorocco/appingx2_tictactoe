package com.example.rocco.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {
    var playerName = ""
    var nbTurn = 0
    var xPlaying = true

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
        }

        top_center.setOnClickListener {
            if (top_center.text == "") {
                top_center.text = getPlayerId()
                togglePlayer()
            }
        }

        top_right.setOnClickListener {
            if (top_right.text == "") {
                top_right.text = getPlayerId()
                togglePlayer()
            }
        }

        center_left.setOnClickListener {
            if (center_left.text == "") {
                center_left.text = getPlayerId()
                togglePlayer()
            }
        }

        center_center.setOnClickListener {
            if (center_center.text == "") {
                center_center.text = getPlayerId()
                togglePlayer()
            }
        }

        center_right.setOnClickListener {
            if (center_right.text == "") {
                center_right.text = getPlayerId()
                togglePlayer()
            }
        }

        bottom_left.setOnClickListener {
            if (bottom_left.text == "") {
                bottom_left.text = getPlayerId()
                togglePlayer()
            }
        }

        bottom_center.setOnClickListener {
            if (bottom_center.text == "") {
                bottom_center.text = getPlayerId()
                togglePlayer()
            }
        }

        bottom_right.setOnClickListener {
            if (bottom_right.text == "") {
                bottom_right.text = getPlayerId()
                togglePlayer()
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
}