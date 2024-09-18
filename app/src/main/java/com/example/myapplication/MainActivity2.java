package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    private ListView listview;
    private ArrayAdapter<String> arrayAdapter;
    private List<SpotData.Record> spotList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listview = findViewById(R.id.list_view_id);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listview.setAdapter(arrayAdapter);

        RetrofitClient();

        listview.setOnItemClickListener((parent, view, position, id) -> {
            SpotData.Record selectedRecord = spotList.get(position);

            Intent intent = new Intent(MainActivity2.this, SpotData.class);
            intent.putExtra("country", selectedRecord.country);
            intent.putExtra("beach", selectedRecord.beach);
            intent.putExtra("difficulty level", selectedRecord.difficulty_level);
            intent.putExtra("photos", selectedRecord.photos);

            startActivity(intent);  // Démarrer l'activité Spot
        });
    }

    private void RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<SpotData.Record>> call = apiService.getListSpots();

        call.enqueue(new Callback<List<SpotData.Record>>() {
            @Override
            public void onResponse(Call<List<SpotData.Record>> call, Response<List<SpotData.Record>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    spotList = response.body();  // Stocker les données récupérées dans spotList
                    List<String> spotNames = new ArrayList<>();
                    // Ajouter chaque nom de spot dans la liste
                    for (SpotData.Record record : spotList) {
                        spotNames.add(record.beach);  // Afficher le nom du surf break dans la liste
                    }
                    // Mettre à jour la ListView avec les noms des spots
                    arrayAdapter.clear();
                    arrayAdapter.addAll(spotNames);
                } else {
                    Toast.makeText(MainActivity2.this, "Erreur lors de la réponse de l'API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SpotData.Record>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Échec de la connexion à l'API", Toast.LENGTH_SHORT).show();
                Log.e("SpotList", "Échec de la connexion à l'API", t);
            }
        });
    }
}
