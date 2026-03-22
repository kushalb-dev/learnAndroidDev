package com.headfirstandroiddev.app1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.title = "Find Drinks!"
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.button1_mainActivity)
        val spinner1 = findViewById<Spinner>(R.id.spinner1_mainActivity)
        button1.setOnClickListener { _ ->
            val selectedItemString= spinner1.selectedItem.toString()
            val textView1 = findViewById<TextView>(R.id.textView1_mainActivity)
            textView1.text = getDrinks(selectedItemString)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun getDrinks(item: String): String {
        return when (item) {
            ("Beer") -> "Guinness\nHeineken\nBudweiser"
            ("Wine") -> "Chardonnay\nSauvignon Blanc\nPinot Noir"
            ("Vodka") -> "Absolut\nChivas Regal\nSmirnoff"
            else -> "No drink selected!"
        }
    }
}