package com.example.myapplication;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET(value = "http://localhost:8080/api/v1/spots/")

    Call<spot> getListSpots(@Query("country") String valeur);
};
