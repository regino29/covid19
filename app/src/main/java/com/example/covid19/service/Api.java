package com.example.covid19.service;

import com.example.covid19.CountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("all")
    Call<GlobalModel> getGlobalStats();

    @GET("countries")
    Call<List<CountryModel>> getCountryStats();
}
