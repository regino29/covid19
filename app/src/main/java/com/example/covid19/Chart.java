package com.example.covid19;

import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.service.HistoryModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Chart extends AppCompatActivity {

    private TextView mTextView;
    private BarChart barChart;

    private LineChart lineChart;

    Button btn;

    List<HistoryModel> historyModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chart );

        mTextView = (TextView) findViewById( R.id.activity_chart_text );
        barChart=findViewById( R.id.activity_chart_graph );
        lineChart=findViewById( R.id.activity_chart_linechart );
        btn=findViewById( R.id.activity_chart_button );

        mTextView.setText( DetailsActivity.country.toUpperCase() );

        historyModels=DetailsActivity.historyModels;

        lineChart.setVisibility( View.GONE );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(barChart.getVisibility()== View.VISIBLE){
                    barChart.setVisibility( View.GONE );
                    lineChart.setVisibility( View.VISIBLE );
                }else{
                    barChart.setVisibility( View.VISIBLE );
                    lineChart.setVisibility( View.GONE );
                }
            }
        } );

        createBarChart();
        createLineChart();

    }


    public void createLineChart(){

        ArrayList<Entry> lineEntryArrayList;
        ArrayList<String> labelNames;

        lineEntryArrayList=new ArrayList<>(  );
        labelNames=new ArrayList<>(  );


        for(int i=0;i<10;i++){

            String date = historyModels.get( i*3 ).date;
            date=date.replace( "T00:00:00Z","" );

            lineEntryArrayList.add( new Entry(i,historyModels.get( i*3 ).getCases() ) );
            labelNames.add( date );
        }


        LineDataSet lineDataSet = new LineDataSet( lineEntryArrayList,"Monthly sales" );
        lineDataSet.setColors( ColorTemplate.COLORFUL_COLORS );
        Description description = new Description();
        description.setText( "Months" );
        lineChart.setDescription( description );

        LineData lineData = new LineData( lineDataSet );
        lineChart.setData(lineData);



        XAxis xAxis=lineChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter(labelNames) );

        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setTextSize( 20 );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( false );
        xAxis.setGranularity( 1f );
        xAxis.setLabelCount( labelNames.size() );
        xAxis.setLabelRotationAngle( 270 );
        lineChart.animateY( 2000 );
        lineChart.invalidate();

    }




    public void createBarChart(){

        ArrayList<BarEntry> barEntryArrayList;
        ArrayList<String> labelNames;

        barEntryArrayList=new ArrayList<>(  );
        labelNames=new ArrayList<>(  );

        historyModels=DetailsActivity.historyModels;

        for(int i=0;i<10;i++){

            String date = historyModels.get( i*3 ).date;
            date=date.replace( "T00:00:00Z","" );

            barEntryArrayList.add( new BarEntry(i,historyModels.get( i*3 ).getCases() ) );
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