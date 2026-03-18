package com.hfad.learnfragments;

import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SlidingPaneLayout slidingPane = findViewById(R.id.sliding_pane_layout);
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {
                slidingPane.closePane();
            }
        };

        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);

        slidingPane.addPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {

            @Override
            public void onPanelSlide(@NonNull View panel, float slideOffset) {
                // don't do anything
            }

            @Override
            public void onPanelOpened(@NonNull View panel) {
                onBackPressedCallback.setEnabled(true);
            }

            @Override
            public void onPanelClosed(@NonNull View panel) {
                onBackPressedCallback.setEnabled(false);
            }
        });
    }

    @Override
    public void itemClicked(long id) {
        WorkoutDetailFragment details = WorkoutDetailFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_pane, details)
                .addToBackStack(null)
                .commit();

        SlidingPaneLayout slidingPane = findViewById(R.id.sliding_pane_layout);
        slidingPane.openPane();
    }
}