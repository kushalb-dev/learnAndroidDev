package com.hfad.learnfragmentstablet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "workout_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            int workoutId =  getIntent().getIntExtra(EXTRA_WORKOUT_ID, 0);
            WorkoutDetailFragment fragWorkoutDetail = WorkoutDetailFragment.newInstance(workoutId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_workout_detail, fragWorkoutDetail)
                    .commit();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_workout_detail), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}