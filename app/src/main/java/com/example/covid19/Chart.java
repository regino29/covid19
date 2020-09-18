package com.example.covid19;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.service.HistoryModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Chart extends AppCompatActivity {

    private TextView mTextView;
    private BarChart barChart;

    List<HistoryModel> historyModels;

    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chart );

        mTextView = (TextView) findViewById( R.id.activity_chart_text );
        barChart=findViewById( R.id.activity_chart_graph );

        mTextView.setText( DetailsActivity.country.toUpperCase() );

        barEntryArrayList=new ArrayList<>(  );
        labelNames=new ArrayList<>(  );

        historyModels=DetailsActivity.historyModels;

        for(int i=0;i<10;i++){

            String date = historyModels.get( i*3 ).date;
            date=date.replace( "T00:00:00Z","" );

            barEntryArrayList.add( new BarEntry( i,historyModels.get( i*3 ).getCases() ) );
            labelNames.add( date );
        }


        BarDataSet barDataSet = new BarDataSet( barEntryArrayList,"Monthly sales" );
        barDataSet.setColors( ColorTemplate.COLORFUL_COLORS );
        Description description = new Description();
        description.setText( "Months" );
        barChart.setDescription( description );

        BarData barData = new BarData( barDataSet );
        barChart.setData(barData);



        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter(labelNames) );

        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setTextSize( 20 );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( false );
        xAxis.setGranularity( 1f );
        xAxis.setLabelCount( labelNames.size() );
        xAxis.setLabelRotationAngle( 270 );
        barChart.animateY( 2000 );
        barChart.invalidate();


    }


}