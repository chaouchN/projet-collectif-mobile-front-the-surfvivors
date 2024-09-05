package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.io.Serializable;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private TextView beachTextView;
    private TextView countryTextView;
    private TextView difficulty_levelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        beachTextView = findViewById(R.id.beachTextView);
        countryTextView = findViewById(R.id.countryTextView);
        difficulty_levelTextView = findViewById(R.id.difficulty_levelTextView);

        Intent intent = getIntent();

        String Spot_beach = intent.getStringExtra("beach");
        String Spot_country = intent.getStringExtra("country");
        String Spot_difficulty = intent.getStringExtra("difficulty_level");


        beachTextView.setText(Spot_beach);
        countryTextView.setText(Spot_country);
        difficulty_levelTextView.setText(Spot_difficulty);
        }



        //System.out.println(intent.getStringExtra(Spot));*/
    }


