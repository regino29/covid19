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
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
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
    private CombinedChart chart;
    private LineChart lineChart;

    Button btn;

    List<HistoryModel> historyModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chart );

        chart=findViewById( R.id.activity_chart_combined );

        mTextView = (TextView) findViewById( R.id.activity_chart_text );
        barChart=findViewById( R.id.activity_chart_graph );
        lineChart=findViewById( R.id.activity_chart_linechart );
        btn=findViewById( R.id.activity_chart_button );


        barChart.setVisibility( View.GONE );
        lineChart.setVisibility( View.GONE );

        mTextView.setText( DetailsActivity.country.toUpperCase() );

        historyModels=DetailsActivity.historyModels;

        lineChart.setVisibility( View.GONE );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chart.getVisibility()== View.VISIBLE){
                    chart.setVisibility( View.GONE );
                    barChart.setVisibility( View.VISIBLE );
                }else if(barChart.getVisibility()==View.VISIBLE){
                    barChart.setVisibility( View.GONE );
                    lineChart.setVisibility( View.VISIBLE );
                }
                else {
                    lineChart.setVisibility( View.GONE );
                    chart.setVisibility( View.VISIBLE );
                }
            }
        } );

        createBarChart();
        createLineChart();

        createCombinedChart();

    }


    public void createCombinedChart(){

        chart.getDescription().setEnabled(false);
        chart.setBackgroundColor(Color.WHITE);
        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);
        chart.setHighlightFullBarEnabled(false);

        chart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });
        

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(30f); // this replaces setStartAtZero(true)

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(6000f); // this replaces setStartAtZero(true)

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition( XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);

        CombinedData data = new CombinedData();

        data.setData( createLineChart() );
        data.setData( createBarChart() );

        chart.setData( data );
        chart.invalidate();

    }


    public LineData createLineChart(){


        ArrayList<Entry> lineEntryArrayList;
        ArrayList<String> labelNames;

        lineEntryArrayList=new ArrayList<>(  );
        labelNames=new ArrayList<>(  );

        int size=historyModels.size();

        for(int i=1;i<size-1;i++){

            String date = historyModels.get( i ).date;
            date=date.replace( "T00:00:00Z","" );
            int cases = historyModels.get( i ).getCases()-historyModels.get( i-1 ).getCases();

            lineEntryArrayList.add( new Entry(i,historyModels.get( i ).getCases() ) );
            labelNames.add( date );
        }


        LineDataSet lineDataSet = new LineDataSet( lineEntryArrayList,"Date" );
        lineDataSet.setColors( Color.RED );
        lineDataSet.setLineWidth( 5f );
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        Description description = new Description();
        description.setText( "Date" );
        lineChart.setDescription( description );

        LineData lineData = new LineData( lineDataSet );
        lineChart.setData(lineData);



        XAxis xAxis=lineChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter(labelNames) );

        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( false );
        xAxis.setGranularity( 1f );
        xAxis.setLabelCount( labelNames.size() );
        xAxis.setLabelRotationAngle( 270 );
        lineChart.animateY( 2000 );
        lineChart.invalidate();

        return lineData;

    }




    public BarData createBarChart(){

        ArrayList<BarEntry> barEntryArrayList;
        ArrayList<String> labelNames;

        barEntryArrayList=new ArrayList<>(  );
        labelNames=new ArrayList<>(  );

        historyModels=DetailsActivity.historyModels;

        int size=historyModels.size();

        for(int i=1;i<size-1;i++){

            String date = historyModels.get( i ).date;
            date=date.replace( "T00:00:00Z","" );

            int cases = historyModels.get( i ).getCases()-historyModels.get( i-1 ).getCases();

            barEntryArrayList.add( new BarEntry(i,cases ) );
            labelNames.add( date );
        }


        BarDataSet barDataSet = new BarDataSet( barEntryArrayList,"Date" );
        barDataSet.setColors( ColorTemplate.COLORFUL_COLORS );
        barDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        Description description = new Description();
        description.setText( "Date" );
        barChart.setDescription( description );

        BarData barData = new BarData( barDataSet );
        barChart.setData(barData);


        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter(labelNames) );

        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setDrawGridLines( false );
        xAxis.setDrawAxisLine( false );
        xAxis.setGranularity( 1f );
        xAxis.setLabelCount( labelNames.size() );
        xAxis.setLabelRotationAngle( 270 );
        barChart.animateY( 2000 );
        barChart.invalidate();

        return barData;

    }

}