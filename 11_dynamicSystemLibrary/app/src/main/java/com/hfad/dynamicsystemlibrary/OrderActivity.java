package com.hfad.dynamicsystemlibrary;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {


    private String oldOrderName = "";
    private String oldOrderDetails = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.collapsing_toolbar_toolbar_order);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.create_order);
        }
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_button_update_edit);
        EditText editOrderName = findViewById(R.id.edit_order_name);
        EditText editOrderDetails = findViewById(R.id.edit_order_details);
        floatingActionButton.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v, R.string.snackbar_order_updated, Snackbar.LENGTH_LONG);
            final String nameSnapshot = oldOrderName;
            final String detailsSnapshot = oldOrderDetails;
            snackbar.show();
            oldOrderName = editOrderName.getText().toString();
            oldOrderDetails = editOrderDetails.getText().toString();
            snackbar.setAction("Undo", v1 -> {
                editOrderDetails.setText(nameSnapshot);
                editOrderName.setText(detailsSnapshot);
                oldOrderName = nameSnapshot;
                oldOrderDetails = nameSnapshot;
                Toast toast = Toast.makeText(OrderActivity.this, R.string.toast_undone, Toast.LENGTH_SHORT);
                toast.show();
            });
        });
    }
}