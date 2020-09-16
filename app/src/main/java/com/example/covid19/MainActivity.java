package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid19.service.Api;
import com.example.covid19.service.GlobalModel;


import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView cases, recovered, critical, active, todayCases, deaths, todayDeaths, countries;
    ScrollView scrollView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        cases = findViewById( R.id.activity_main_cases );
        recovered = findViewById( R.id.activity_main_recovered );
        critical = findViewById( R.id.activity_main_critical );
        active = findViewById( R.id.activity_main_active );
        todayCases = findViewById( R.id.activity_main_new_cases );
        deaths = findViewById( R.id.activity_main_deaths );
        todayDeaths = findViewById( R.id.activity_main_new_deaths );
        countries = findViewById( R.id.activity_main_countries_affected );

        scrollView = findViewById( R.id.activity_main_scrollview );

        pieChart=findViewById( R.id.main_activity_piechart );

        fetchData();

    }


    private void fetchData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( getString( R.string.BASE_URL ) )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        Api api = retrofit.create( Api.class );

        Call<GlobalModel> call = api.getGlobalStats();
        call.enqueue( new Callback<GlobalModel>() {
            @Override
            public void onResponse(Call<GlobalModel> call, Response<GlobalModel> response) {
                GlobalModel stats = response.body();

                cases.setText( String.valueOf( stats.getCases() ) );
                recovered.setText( String.valueOf( stats.getRecovered() ) );
                critical.setText( String.valueOf( stats.getCritical() ) );
                active.setText( String.valueOf( stats.getActive() ) );
                todayCases.setText( String.valueOf( stats.getTodayCases() ) );
                deaths.setText( String.valueOf( stats.getDeaths() ) );
                todayDeaths.setText( String.valueOf( stats.getTodayDeaths() ) );
                countries.setText( String.valueOf( stats.getAffectedCountries() ) );

                pieChart.addPieSlice( new PieModel( "Cases",Integer.parseInt( cases.getText().toString() ), Color.parseColor( "#FFA726" ) ) );
                pieChart.addPieSlice( new PieModel( "Recovered",Integer.parseInt( recovered.getText().toString() ), Color.parseColor( "#66BB6A" ) ) );
                pieChart.addPieSlice( new PieModel( "Deaths",Integer.parseInt( deaths.getText().toString() ), Color.parseColor( "#EF5350" ) ) );
                pieChart.addPieSlice( new PieModel( "Active",Integer.parseInt( active.getText().toString() ), Color.parseColor( "#29B6F6" ) ) );
                pieChart.startAnimation(  );

            }

            @Override
            public void onFailure(Call<GlobalModel> call, Throwable t) {
                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG ).show();
            }
        } );

    }


    public void trackCountries(View view) {

        startActivity( new Intent( getApplicationContext(), Countries.class ) );

    }
}