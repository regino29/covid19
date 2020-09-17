package com.example.covid19.service;

import com.example.covid19.CountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("all")
    Call<GlobalModel> getGlobalStats();

    @GET("countries")
    Call<List<CountryModel>> getCountryStats();

    @GET("country/{country_name}/status/confirmed")
    Call<List<HistoryModel>> getHistoricalData(
            @Path( "country_name" ) String name,
            @Query("from") String from,
            @Query( "to" ) String to
    );

}
