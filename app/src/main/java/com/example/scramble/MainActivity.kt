package com.example.scramble

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var input: EditText
    private lateinit var scrambleBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialiseViews()
        addEventHandlers()
    }

    private fun initialiseViews() {
        input = findViewById(R.id.scrambleEditText)
        scrambleBtn = findViewById(R.id.scrambleButton)
    }

    private fun addEventHandlers() {
        scrambleBtn.setOnClickListener {
            val chars = input.text.toString().toCharArray().toMutableList()
            chars.shuffle()
            val newText = chars
                .map { c -> c.toString() }
                .reduce { acc, s -> acc + s }
            input.setText(newText)
        }
    }
}
