package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;

import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    private ListView listview;
    private SpotAdapter spotAdapter; // L'adapter pour la ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listview = findViewById(R.id.list_view_id);

        // Créez une instance de votre service API
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        System.out.println("LOG Api Service:");
        System.out.println(apiService);

        // Faites l'appel au webservice (API)
        Call<List<spot>> call = apiService.getListSpots();

        // Retourne le résultat
        call.enqueue(new Callback<List<spot>>() {
            @Override
            public void onResponse(Call<List<spot>> call, Response<List<spot>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<spot> spots = response.body();


                    // Créez l'adapter et associez-le à la ListView
                    spotAdapter = new SpotAdapter(MainActivity2.this, spots);
                    listview.setAdapter(spotAdapter);
                } else {
                    Log.e("API_ERROR", "Erreur : " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<spot>> call, Throwable t) {
                Log.e("API_FAILURE", "Erreur : " + t.getMessage());
                t.printStackTrace(); // Affiche la trace d'erreur complète pour plus de détails
            }
        });
    }
}






