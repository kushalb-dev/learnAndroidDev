package com.hfad.dynamicfragments;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temp);
        if (savedInstanceState == null) {
            StopwatchActivityFragment fragment = new StopwatchActivityFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.stopwatch_container, fragment)
                    .addToBackStack(null)
                    .setTransition(TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.stopwatch_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}