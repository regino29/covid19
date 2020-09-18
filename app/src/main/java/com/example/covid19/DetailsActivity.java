package com.example.covid19;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.covid19.service.Api;
import com.example.covid19.service.HistoryModel;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {

    private int position;
    public static List<HistoryModel> historyModels;
    private String start,end;
    public static String country;


    TextView cases, recovered, critical, active, todayCases, deaths, todayDeaths, tiltle;
    CircleImageView flag;
    Button btn;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );


        btn=findViewById( R.id.details_activity_button );
        flag = findViewById( R.id.activity_details_flag );
        cases = findViewById( R.id.activity_details_cases );
        recovered = findViewById( R.id.activity_details_recovered );
        critical = findViewById( R.id.activity_details_critical );
        active = findViewById( R.id.activity_details_active );
        todayCases = findViewById( R.id.activity_details_new_cases );
        deaths = findViewById( R.id.activity_details_deaths );
        todayDeaths = findViewById( R.id.activity_details_new_deaths );
        tiltle = findViewById( R.id.activity_details_countryStats );
        pieChart = findViewById( R.id.details_activity_piechart );


        Intent intent = getIntent();

        position = intent.getIntExtra( "position", 0 );

        Glide.with( DetailsActivity.this ).load( Countries.countryModelsList.get( position ).countryInfo.getFlag() ).into( flag );

        cases.setText( String.valueOf( Countries.countryModelsList.get( position ).getCases() ) );
        recovered.setText( String.valueOf( Countries.countryModelsList.get( position ).getRecovered() ) );
        critical.setText( String.valueOf( Countries.countryModelsList.get( position ).getCritical() ) );
        active.setText( String.valueOf( Countries.countryModelsList.get( position ).getActive() ) );
        todayCases.setText( String.valueOf( Countries.countryModelsList.get( position ).getTodayCases() ) );
        deaths.setText( String.valueOf( Countries.countryModelsList.get( position ).getDeaths() ) );
        todayDeaths.setText( String.valueOf( Countries.countryModelsList.get( position ).getTodayDeaths() ) );
        tiltle.setText( String.valueOf( Countries.countryModelsList.get( position ).getCountry() ) );


        pieChart.addPieSlice( new PieModel( "Cases",Integer.parseInt( cases.getText().toString() ), Color.parseColor( "#FFA726" ) ) );
        pieChart.addPieSlice( new PieModel( "Recovered",Integer.parseInt( recovered.getText().toString() ), Color.parseColor( "#66BB6A" ) ) );
        pieChart.addPieSlice( new PieModel( "Deaths",Integer.parseInt( deaths.getText().toString() ), Color.parseColor( "#EF5350" ) ) );
        pieChart.addPieSlice( new PieModel( "Active",Integer.parseInt( active.getText().toString() ), Color.parseColor( "#29B6F6" ) ) );
        pieChart.startAnimation(  );


        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),Chart.class ) );
            }
        } );

        findParams();
        fetchData();

    }


    

    private void fetchData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://api.covid19api.com/" ).addConverterFactory( GsonConverterFactory.create() )
                .build();

        Api api = retrofit.create( Api.class );


        Call<List<HistoryModel>> call = api.getHistoricalData( country,start,end );
        call.enqueue( new Callback<List<HistoryModel>>() {
            @Override
            public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                historyModels=response.body();

                Toast.makeText( getApplicationContext(), String.valueOf( historyModels.size() ), Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onFailure(Call<List<HistoryModel>> call, Throwable t) {
                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG ).show();
            }
        } );
    }

    public void findParams(){
        country=tiltle.getText().toString();
        country=country.toLowerCase();
        country=country.replace( " ","-" );

        end = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        String[] array=end.split( "-" );

        int i=Integer.parseInt( array[1] );

        if (i>10)
            start=array[0]+"-"+String.valueOf( i-1 ) +"-"+ array[2];
        else if(i==1)
            start=String.valueOf( Integer.parseInt( array[0] )-1 )+"-"+"12"+"-"+array[2];
        else
            start=array[0]+"-0"+String.valueOf( i-1 ) +"-"+ array[2];

        end=end+"T00:00:00Z";
        start=start+"T00:00:00Z";


    }
}