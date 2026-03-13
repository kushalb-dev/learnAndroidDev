package com.example.listviewsandadapters;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_NUMBER = "drinkNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drink);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int drinkNumber = getIntent().getIntExtra(EXTRA_DRINK_NUMBER, -1);
        Drink drink = Drink.drinks[drinkNumber];

        ImageView drinkImage = findViewById(R.id.drink_photo);
        TextView drinkName = findViewById(R.id.drink_name);
        TextView drinkDescription = findViewById(R.id.drink_description);

        drinkImage.setImageResource(drink.getImageResourceId());
        drinkImage.setContentDescription(drink.getName());
        drinkName.setText(drink.getName());
        drinkDescription.setText(drink.getDescription());
    }
}