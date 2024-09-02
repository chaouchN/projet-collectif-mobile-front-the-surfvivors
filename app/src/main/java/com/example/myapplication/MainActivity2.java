package com.example.myapplication;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private final String[] spots = new String[]{
            "Hawai",
            "Australia",
            "South Africa",
            "Peru",
            "Canary Islands",
            "Usa, Oregon",
            "Maldives",
            "New Zealand",
            "Usa, North Carolina",
            "Namibia"
    };
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Correct the initialization of listView
        listView = findViewById(R.id.list_view_id);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spots);
        listView.setAdapter(arrayAdapter);
    }
}

