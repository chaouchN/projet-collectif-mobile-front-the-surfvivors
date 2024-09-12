package com.example.myapplication;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(value = "spots/") //chemin du endpoint de l'API surfvivors
    Call<List<spot>> getListSpots();
};
