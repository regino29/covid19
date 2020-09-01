package com.example.covid19.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("all")
    Call<GlobalModel> getGlobalStats();
}
