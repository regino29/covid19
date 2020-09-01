package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19.service.Api;
import com.example.covid19.service.GlobalModel;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView cases,recovered,critical,active,todayCases,deaths,todayDeaths,countries;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        cases=findViewById( R.id.activity_main_cases );
        recovered=findViewById( R.id.activity_main_recovered );
        critical=findViewById( R.id.activity_main_critical );
        active=findViewById( R.id.activity_main_active );
        todayCases=findViewById( R.id.activity_main_new_cases );
        deaths=findViewById( R.id.activity_main_deaths );
        todayDeaths=findViewById( R.id.activity_main_new_deaths );
        countries=findViewById( R.id.activity_main_countries_affected );

        scrollView=findViewById( R.id.activity_main_scrollview );

        
        fetchData();
        
    }

    private void fetchData() {

//        String url="https://corona.lmao.ninja/v2/all";
//
//        StringRequest request = new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//
//                try {
//                    JSONObject jsonObject= new JSONObject( response.toString() );
//
//                    cases.setText( jsonObject.getString( "cases" ) );
//                    recovered.setText( jsonObject.getString( "recovered" ) );
//                    critical.setText( jsonObject.getString( "critical" ) );
//                    active.setText( jsonObject.getString( "active" ) );
//                    todayCases.setText( jsonObject.getString( "todayCases" ) );
//                    deaths.setText( jsonObject.getString( "deaths" ) );
//                    todayDeaths.setText( jsonObject.getString( "todayDeaths" ) );
//                    countries.setText( jsonObject.getString( "affectedCountries" ) );
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText( MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT ).show();
//            }
//        } );
//
//
//        RequestQueue requestQueue= Volley.newRequestQueue( this );
//        requestQueue.add( request );


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://corona.lmao.ninja/v2/" )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        Api api = retrofit.create(Api.class);

        Call<GlobalModel> call = api.getGlobalStats();
        call.enqueue( new Callback<GlobalModel>() {
            @Override
            public void onResponse(Call<GlobalModel> call, Response<GlobalModel> response) {
                GlobalModel stats = response.body();

                cases.setText( String.valueOf( stats.getCases()) );
                recovered.setText( String.valueOf( stats.getRecovered() ) );
                critical.setText( String.valueOf( stats.getCritical()));
                active.setText( String.valueOf( stats.getActive()) );
                todayCases.setText(String.valueOf( stats.getTodayCases()));
                deaths.setText( String.valueOf( stats.getDeaths()) );
                todayDeaths.setText( String.valueOf( stats.getTodayDeaths()) );
                countries.setText( String.valueOf( stats.getAffectedCountries()) );

            }

            @Override
            public void onFailure(Call<GlobalModel> call, Throwable t) {
                Toast.makeText( getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG ).show();
            }
        } );

    }


    public void trackCountries(View view) {

        startActivity( new Intent( getApplicationContext(),Countries.class ) );

    }
}