package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity implements CountryAdapter.OnNoteListener {

    EditText search;
    RecyclerView recyclerView;


    public static List<CountryModel> countryModelsList=new ArrayList<>(  );
    CountryModel countryModel;
    CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_countries );

        search=findViewById( R.id.activity_countries_search );
        recyclerView=findViewById( R.id.activity_countries_recyclerView );

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

        String url="https://corona.lmao.ninja/v2/countries";

        StringRequest request = new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray jsonArray = new JSONArray( response );

                    for(int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject =jsonArray.getJSONObject( i );
                        String countryName = jsonObject.getString( "country" );
                        String cases = jsonObject.getString( "cases" );
                        String todayCases = jsonObject.getString( "todayCases" );
                        String deaths = jsonObject.getString( "deaths" );
                        String todayDeaths = jsonObject.getString( "todayDeaths" );
                        String recovered = jsonObject.getString( "recovered" );
                        String active = jsonObject.getString( "active" );
                        String critical = jsonObject.getString( "critical" );

                        JSONObject object = jsonObject.getJSONObject( "countryInfo" );
                        String flag = object.getString( "flag" );

                        countryModel = new CountryModel( flag,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical );
                        countryModelsList.add( countryModel );



                    }


                    mAdapter=new CountryAdapter( countryModelsList,Countries.this ,Countries.this);

                    recyclerView.setLayoutManager( new LinearLayoutManager( Countries.this ) );
                    recyclerView.setAdapter( mAdapter );



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( Countries.this, error.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );


        RequestQueue requestQueue= Volley.newRequestQueue( this );
        requestQueue.add( request );

    }

    @Override
    public void onNoteClick(int position) {

        startActivity( new Intent( getApplicationContext(),DetailsActivity.class ).putExtra( "position",position) );



    }
}