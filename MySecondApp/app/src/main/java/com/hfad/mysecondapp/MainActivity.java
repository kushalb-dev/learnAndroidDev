package com.hfad.mysecondapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final BeerExpert beerExpert = new BeerExpert();

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
    }

    public void onClickFindBeer(View view) {
        Spinner beer_type_spinner = findViewById(R.id.beer_spinner);
        String beer_type_str = String.valueOf(beer_type_spinner.getSelectedItem());
        TextView beers = findViewById(R.id.beers);
        List<String> corresponding_beers = beerExpert.getBeers(beer_type_str);
        StringBuilder beers_str = new StringBuilder();
        for (String beer : corresponding_beers) {
            beers_str.append(beer).append('\n');
        }
        beers.setText(beers_str);
    }
}