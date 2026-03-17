package com.hfad.dynamicfragments;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class MainActivity extends AppCompatActivity implements FragmentWorkoutList.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SlidingPaneLayout slidingPaneLayout = findViewById(R.id.sliding_pane_main_page);
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {
                slidingPaneLayout.closePane();
            }
        };

        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
        slidingPaneLayout.addPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(@NonNull View panel, float slideOffset) { }

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
    public void onClicked(long id) {
        FragmentWorkoutDetail fragment = FragmentWorkoutDetail.newInstance(id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_pane, fragment)
                .addToBackStack(null)
                .commit();

        SlidingPaneLayout slidingPaneLayout = findViewById(R.id.sliding_pane_main_page);
        slidingPaneLayout.openPane();
    }
}