package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.Toast;
import android.util.Log;
import android.os.AsyncTask;



public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Créez une instance de votre service API
        ApiService apiService = RetrofitClient.getClient("http://localhost:8080/api/v1/spots/").create(ApiService.class);

        // Appelez une méthode de l'API
        Call<spot> call = apiService.getListSpots("valeur");


        call.enqueue(new Callback<spot>() {
            @Override
            public void onResponse(Call<spot> call, Response<spot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Traitez la réponse
                    spot spotData = response.body();
                    Log.d("API_RESPONSE", spotData.toString()); // Utiliser le log pour le débogage Android
                    System.out.println(spotData); // Utiliser System.out.println pour une vérification rapide
                } else {
                    Log.e("API_ERROR", "Erreur : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<spot> call, Throwable t) {
                Log.e("API_FAILURE", "Erreur : " + t.getMessage());
            }
        });
    }

}




