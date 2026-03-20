package com.hfad.firstkotlinapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.firstkotlinapp.R
import com.hfad.firstkotlinapp.adapters.AchievementsAdapter
import com.hfad.firstkotlinapp.dataClasses.Achievement

class AchievementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_achievements)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.achievements_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_achievementsActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val data = Achievement.sampleListAchievements
        val adapter = AchievementsAdapter(data)
        recyclerView.adapter = adapter
    }
}