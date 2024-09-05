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
    private TextView textview;

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        TextView beachTextView = (TextView)findViewById(R.id.beachTextView);
        TextView countryTextView = (TextView)findViewById(R.id.countryTextView);
        TextView difficulty_levelTextView = (TextView)findViewById(R.id.difficulty_levelTextView);

        String Spot_beach = getIntent().getStringExtra("beach");
        String Spot_country = getIntent().getStringExtra("country");
        String Spot_difficulty = getIntent().getStringExtra("difficulty_level");


        //beachTextView = Spot_beach;

        //if(getIntent() != null && getIntent().hasExtra(spot.beach)) {
            /*countryTextView.setText(getIntent().getStringExtra(Intent.spot.country));
        };


        Intent intent = getIntent();
        System.out.println(intent.getStringExtra(Spot));*/
    }

};

