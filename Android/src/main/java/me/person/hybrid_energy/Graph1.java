package me.person.hybrid_energy;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Graph1 extends AppCompatActivity {

    LineChart lineChart;

    ArrayList<String> xAxes = new ArrayList<String>();
    ArrayList<Entry> yAxes = new ArrayList<>();
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<String>();
    String var= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_graph1);


        String temp=null;

        lineChart = (LineChart)findViewById(R.id.lineChart);
        Intent j = getIntent(); //This should be getIntent();
        list = j.getStringArrayListExtra("list");
        //list1 = j.getStringArrayListExtra("list1");

        /*xAxes.add("810");
        xAxes.add("900");
        xAxes.add("990");
        xAxes.add("1080");
        xAxes.add("1170");
        xAxes.add("1260");
        xAxes.add("1350");
        xAxes.add("1440");



/*

        int k = 0;
        for (String var : list) {
            Float temp1 = parseFloat(var);

            yAxes.add(new Entry(temp1, k));
            k++;

        }
        /*Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        List<Float> list=(List<Float>)bundle.getSerializable("list");

        //Bundle bndl = getIntent().getExtras();
        //String dat = bndl.getString("list");
        /*for(int i= 0;i<20;i++){

            int j=90;
        xAxes.add("j");
            j=j*2;
        }*/
        xAxes.add("90");
        xAxes.add("180");
        xAxes.add("270");
        xAxes.add("360");
        xAxes.add("450");
        xAxes.add("540");
        xAxes.add("630");
        xAxes.add("720");
       xAxes.add("810");
        xAxes.add("900");
        xAxes.add("990");
        xAxes.add("1080");
        xAxes.add("1170");
        xAxes.add("1260");
        xAxes.add("1350");
        xAxes.add("1440");
        xAxes.add("1530");
        xAxes.add("1620");
        xAxes.add("1710");
 // vpump list
//        for(float var : vpump){
//            String temp = temp.toString();
//            xAxes.add(temp);
//        }
            /*xAxes.add("90");
            xAxes.add("180");
            xAxes.add("270");
            xAxes.add("360");
            xAxes.add("450");
            xAxes.add("540");
            xAxes.add("630");
            xAxes.add("720");
            xAxes.add("810");
            xAxes.add("900");
            xAxes.add("990");
            xAxes.add("1080");
            xAxes.add("1170");
            xAxes.add("1260");
            xAxes.add("1350");
            xAxes.add("1440");
            xAxes.add("1530");
            xAxes.add("1620");
            xAxes.add("1710");






//solar pwr
        for(float var : list){
            temp = temp.toString();
            xAxes.add(temp);*/





           yAxes.add(new Entry(103.068f, 0));
            yAxes.add(new Entry(105.23f, 1));
            yAxes.add(new Entry(104.72f, 2));
            yAxes.add(new Entry(100.61f, 3));
            yAxes.add(new Entry(102.7f, 4));
            yAxes.add(new Entry(6.1f, 5));
            yAxes.add(new Entry(108.76f, 6));
            yAxes.add(new Entry(110.7f, 7));
            yAxes.add(new Entry(100.128f, 8));
            yAxes.add(new Entry(0.068f, 9));
            yAxes.add(new Entry(101.75f, 10));
            yAxes.add(new Entry(100.8f, 11));
            yAxes.add(new Entry(102.68f, 12));
            yAxes.add(new Entry(0.06f, 13));
            yAxes.add(new Entry(97.6f, 14));
            yAxes.add(new Entry(99.43f, 15));
            yAxes.add(new Entry(3.52f, 16));
            yAxes.add(new Entry(103.15f, 17));
            yAxes.add(new Entry(104.38f, 18));








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






