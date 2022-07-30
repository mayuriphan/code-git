package me.person.hybrid_energy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import static java.lang.Float.parseFloat;

public class Solr extends AppCompatActivity {

    LineChart lineChart;

    ArrayList<Float> xAxes = new ArrayList<Float>();
    ArrayList<Entry> yAxes = new ArrayList<>();
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<String>();
    String var= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lineChart = (LineChart)findViewById(R.id.lineChart);

        Intent j = getIntent(); //This should be getIntent();
        list = j.getStringArrayListExtra("list");
        list1 = j.getStringArrayListExtra("list1");


        String temp = null;
        for (String var : list) {
            temp = var.toString();
            xAxes.add(Float.valueOf(temp));

        }

        int k = 0;
        for (String var : list1) {
            Float temp1 = parseFloat(var);

            yAxes.add(new Entry(temp1, k));
            k++;

        }

        /*xAxes.add(Float.valueOf("43.2f"));
        xAxes.add(Float.valueOf("42.3f"));
        xAxes.add(Float.valueOf("42.9f"));
        xAxes.add(Float.valueOf("42.4f"));
        xAxes.add(Float.valueOf("42f"));
        xAxes.add(Float.valueOf("42.3f"));
        xAxes.add(Float.valueOf("47f"));
        xAxes.add(Float.valueOf("47f"));
        xAxes.add(Float.valueOf("43.8f"));
        xAxes.add(Float.valueOf("43.8f"));
        xAxes.add(Float.valueOf("103f"));
        xAxes.add(Float.valueOf("101f"));
        xAxes.add(Float.valueOf("101f"));
        xAxes.add(Float.valueOf("45.8f"));
        xAxes.add(Float.valueOf("43.7f"));
        xAxes.add(Float.valueOf("43.3f"));
        xAxes.add(Float.valueOf("42.9f"));
        xAxes.add(Float.valueOf("47f"));
        xAxes.add(Float.valueOf("46.9"));
        xAxes.add(Float.valueOf("46.1f"));
        xAxes.add(Float.valueOf("46.2f"));
        xAxes.add(Float.valueOf("46.3f"));
        xAxes.add(Float.valueOf("46.2f"));
        xAxes.add(Float.valueOf("46.4f"));
        xAxes.add(Float.valueOf("42.1f"));
        xAxes.add(Float.valueOf("41.9f"));
        xAxes.add(Float.valueOf("41.6f"));
        xAxes.add(Float.valueOf("41.1f"));
        xAxes.add(Float.valueOf("41.7f"));
        xAxes.add(Float.valueOf("41.4f"));
        xAxes.add(Float.valueOf("41.3f"));
        xAxes.add(Float.valueOf("41.2f"));
        xAxes.add(Float.valueOf("46.4f"));


        yAxes.add(new Entry(	2.9f, 0));
        yAxes.add(new Entry(	2.1f, 1));
        yAxes.add(new Entry(2.8f, 2));
        yAxes.add(new Entry(	2f, 3));
        yAxes.add(new Entry(	2.9f, 4));
        yAxes.add(new Entry(	3.1f, 5));
        yAxes.add(new Entry(0.3f, 6));
        yAxes.add(new Entry(0.3f, 7));
        yAxes.add(new Entry(0.3f, 8));
        yAxes.add(new Entry(	2.7f, 9));
        yAxes.add(new Entry(	2.7f, 10));
        yAxes.add(new Entry(1f, 11));
        yAxes.add(new Entry(1f, 12));
        yAxes.add(new Entry(1f, 13));
        yAxes.add(new Entry(0.3f, 14));
        yAxes.add(new Entry(0.5f, 15));
        yAxes.add(new Entry(1.9f, 16));
        yAxes.add(new Entry(2.6f, 17));
        yAxes.add(new Entry(0.3f, 18));
        yAxes.add(new Entry(	0.3f, 19));
        yAxes.add(new Entry(	0f, 20));
        yAxes.add(new Entry(0f, 21));
        yAxes.add(new Entry(	0f, 22));
        yAxes.add(new Entry(0f, 23));
        yAxes.add(new Entry(		6f, 24));
        yAxes.add(new Entry(5.9f, 25));
        yAxes.add(new Entry(	5.6f, 26));
        yAxes.add(new Entry(5.8f, 27));
        yAxes.add(new Entry(	6.3f, 28));
        yAxes.add(new Entry(		6.1f, 29));
        yAxes.add(new Entry(		5.9f, 30));
        yAxes.add(new Entry(6.2f, 31));
        yAxes.add(new Entry(0.5f, 32));*/

        String[] xaxes = new String[xAxes.size()];

        for(int i=0;i<xAxes.size();i++)
        {
            xaxes[i] = xAxes.get(i).toString();
        }

        LineDataSet lineDataSet = new LineDataSet(yAxes,"values");
        lineDataSet.setDrawCircles(true);
        lineDataSet.setColor(Color.BLUE);

        lineDataSets.add(lineDataSet);

        lineChart.setData(new LineData(xaxes,lineDataSets));

        lineChart.setVisibleXRangeMaximum(100f);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);

    }
}