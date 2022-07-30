package me.person.hybrid_energy;

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

public class solturb extends AppCompatActivity {
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
        setContentView(R.layout.activity_solturb);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        lineChart = (LineChart)findViewById(R.id.lineChart);
        /*Intent j = getIntent(); //This should be getIntent();
        list = j.getStringArrayListExtra("list");
        list1 = j.getStringArrayListExtra("list1");

        Log.d("me", String.valueOf(list));
        try {


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
        }catch(NullPointerException e)
        {
            System.out.print("NullPointerException Caught");
        }

        Log.d("msg", String.valueOf(yAxes));*/

        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0"));
        xAxes.add(Float.valueOf("0.75"));
        /*xAxes.add("810");
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
*/

        yAxes.add(new Entry(0f, 0));
        yAxes.add(new Entry(0f, 1));
        yAxes.add(new Entry(0, 2));
        yAxes.add(new Entry(0f, 3));
        yAxes.add(new Entry(0f, 4));
        yAxes.add(new Entry(0f, 5));
        yAxes.add(new Entry(0f, 6));
        yAxes.add(new Entry(45.9f, 7));
       /* yAxes.add(new Entry(89.01f, 8));
        yAxes.add(new Entry(87.12f, 9));
        yAxes.add(new Entry(0, 10));
        yAxes.add(new Entry(0, 11));
        yAxes.add(new Entry(0, 12));
        yAxes.add(new Entry(0, 13));
        yAxes.add(new Entry(0, 14));
        yAxes.add(new Entry(0, 15));
        yAxes.add(new Entry(0, 16));
        yAxes.add(new Entry(0, 17));
        yAxes.add(new Entry(0, 18));*/

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




