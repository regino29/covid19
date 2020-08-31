package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private int position;

    TextView cases,recovered,critical,active,todayCases,deaths,todayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

        cases=findViewById( R.id.activity_details_cases );
        recovered=findViewById( R.id.activity_details_recovered );
        critical=findViewById( R.id.activity_details_critical );
        active=findViewById( R.id.activity_details_active );
        todayCases=findViewById( R.id.activity_details_new_cases );
        deaths=findViewById( R.id.activity_details_deaths );
        todayDeaths=findViewById( R.id.activity_details_new_deaths );


        Intent intent = getIntent();

        position=intent.getIntExtra( "position",0 );


        cases.setText(Countries.countryModelsList.get( position ).getCases());
        recovered.setText(Countries.countryModelsList.get( position ).getRecovered());
        critical.setText(Countries.countryModelsList.get( position ).getCritical());
        active.setText(Countries.countryModelsList.get( position ).getActive());
        todayCases.setText(Countries.countryModelsList.get( position ).getNewCases());
        deaths.setText(Countries.countryModelsList.get( position ).getDeaths());
        todayDeaths.setText(Countries.countryModelsList.get( position ).getNewDeaths());



    }
}