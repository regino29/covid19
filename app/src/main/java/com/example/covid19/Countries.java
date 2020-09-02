package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.covid19.service.Api;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Countries extends AppCompatActivity implements CountryAdapter.OnNoteListener {

    EditText search;
    RecyclerView recyclerView;


    public static List<CountryModel> countryModelsList = new ArrayList<>();
    CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_countries );

        search = findViewById( R.id.activity_countries_search );
        recyclerView = findViewById( R.id.activity_countries_recyclerView );

        fetchData();


        search.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mAdapter.getFilter().filter( charSequence );
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

    }

    private void fetchData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( getString( R.string.BASE_URL ) ).addConverterFactory( GsonConverterFactory.create() )
                .build();

        Api api = retrofit.create( Api.class );


        Call<List<CountryModel>> call = api.getCountryStats();

        call.enqueue( new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {

                countryModelsList = response.body();

                mAdapter = new CountryAdapter( countryModelsList, Countries.this, Countries.this );
                recyclerView.setLayoutManager( new LinearLayoutManager( Countries.this ) );
                recyclerView.setAdapter( mAdapter );

            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG ).show();
            }
        } );

    }

    @Override
    public void onNoteClick(int position) {

        startActivity( new Intent( getApplicationContext(), DetailsActivity.class ).putExtra( "position", position ) );


    }
}