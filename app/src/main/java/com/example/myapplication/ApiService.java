package com.example.myapplication;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(value = "api/v1/spots")  //endpoint to reach the rest api
    Call<List<SpotData.Record>> getListSpots();
};
