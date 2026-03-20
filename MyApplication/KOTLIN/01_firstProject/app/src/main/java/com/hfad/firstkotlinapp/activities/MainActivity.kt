package com.hfad.firstkotlinapp.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hfad.firstkotlinapp.R
import com.hfad.firstkotlinapp.activities.SkillsActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1: Button? = findViewById(R.id.button1_linearLayout__)
        val button2: Button? = findViewById(R.id.button2_linearLayout__)
        val button3: Button? = findViewById(R.id.button3_linearLayout__)
        val button4: Button? = findViewById(R.id.button4_linearLayout__)
        val switch1: SwitchCompat? = findViewById(R.id.switch1_mainPage)
        switch1?.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
        }

        button1?.setOnClickListener {
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        button2?.setOnClickListener {
            val intent = Intent(this, ExperienceActivity::class.java)
            startActivity(intent)
        }

        button3?.setOnClickListener {
            val intent = Intent(this, EducationActivity::class.java)
            startActivity(intent)
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }

        button4?.setOnClickListener {
            val intent = Intent(this, AchievementsActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}