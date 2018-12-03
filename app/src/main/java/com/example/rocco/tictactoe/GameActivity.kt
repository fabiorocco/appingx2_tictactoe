package com.example.rocco.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {
    var nbTurn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        desc_guest.text = "O (" + intent.getStringExtra("name") + ")"



    }

    fun playingturn () {

    }
}