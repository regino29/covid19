package com.example.covid19;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {

    private int position;

    TextView cases, recovered, critical, active, todayCases, deaths, todayDeaths, tiltle;
    CircleImageView flag;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

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


    }
}