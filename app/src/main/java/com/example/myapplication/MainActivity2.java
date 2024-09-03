package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;



    //private final String[] spots = new String[]{
            //"Hawai",
            //"Australia",
            //"South Africa",
            //"Peru",
            //"Canary Islands",
            //"Usa, Oregon",
            //"Maldives",
            //"New Zealand",
            //"Usa, North Carolina",
            //"Namibia"
    //};


public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Spot> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialiser la ListView
        listView = findViewById(R.id.list_view_id);

        // Créer une liste de spots
        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot("skeleton_bay", "Namibia", 5));
        spots.add(new Spot("J-Bay", "South Africa", 4));
        spots.add(new Spot("Pipeline", "Hawaii", 5));
        // Ajouter d'autres objets Spot si nécessaire

        // Créer un ArrayAdapter pour la classe Spot
        arrayAdapter = new ArrayAdapter<Spot>(this, android.R.layout.simple_list_item_1, spots) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Utiliser la vue recyclée si elle est disponible
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                // Récupérer l'objet Spot à la position actuelle
                Spot currentSpot = getItem(position);

                // Récupérer le TextView du layout
                TextView textView = (TextView) convertView.findViewById(android.R.id.text1);

                // Mettre à jour le TextView avec le champ que vous voulez afficher, par exemple le pays
                textView.setText(currentSpot.country); // Affiche le pays

                return convertView;
            }

        };

        // Associer l'adaptateur à la ListView
        listView.setAdapter(arrayAdapter);

    }

    class Spot {
        String beach;
        String country;
        int difficulty_level;

        public Spot(String beach, String country, int difficulty_level) {
            this.beach = beach;
            this.country = country;
            this.difficulty_level = difficulty_level;
        }

    }
}
