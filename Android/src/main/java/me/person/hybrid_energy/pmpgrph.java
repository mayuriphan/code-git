package me.person.hybrid_energy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import static java.lang.Float.parseFloat;

public class pmpgrph extends AppCompatActivity {

    LineChart lineChart;

    ArrayList<Float> xAxes = new ArrayList<Float>();


    String var= null;
    ArrayList<Entry> yAxes = new ArrayList<>();
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<String>();
    //LineDataSet set = new LineDataSet(list1, "data series");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmpgrph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lineChart = (LineChart) findViewById(R.id.lineChart);

        Intent j = getIntent(); //This should be getIntent();
        list = j.getStringArrayListExtra("list");
        list1 = j.getStringArrayListExtra("list1");
        //Log.d("Myapp", "msg" + list);

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


        Log.d("Myapp", String.valueOf(xAxes));


        Log.d("Myapp", String.valueOf(yAxes));

        //Log.d("msg", k.toString());
       /* xAxes.add(Float.valueOf("12.22f"));
        xAxes.add(Float.valueOf("12.35f"));
        xAxes.add(Float.valueOf("11.97f"));
        xAxes.add(Float.valueOf("12.26f"));
        xAxes.add(Float.valueOf("12.3f"));
        xAxes.add(Float.valueOf("11.92f"));
        xAxes.add(Float.valueOf("0.34f"));
        xAxes.add(Float.valueOf("0.34f"));
        xAxes.add(Float.valueOf("12.25f"));
        xAxes.add(Float.valueOf("12.25f"));
        xAxes.add(Float.valueOf("1f"));
        xAxes.add(Float.valueOf("1f"));
        xAxes.add(Float.valueOf("1f"));
        xAxes.add(Float.valueOf("0.32f"));
        xAxes.add(Float.valueOf("12.06f"));
        xAxes.add(Float.valueOf("11.99f"));
        xAxes.add(Float.valueOf("12.08f"));
        xAxes.add(Float.valueOf("0.34f"));
        xAxes.add(Float.valueOf("0.2f"));
        xAxes.add(Float.valueOf("12.2f"));
        xAxes.add(Float.valueOf("12.8f"));
        xAxes.add(Float.valueOf("12.6f"));
        xAxes.add(Float.valueOf("12.3f"));
        xAxes.add(Float.valueOf("12.5f"));
        xAxes.add(Float.valueOf("12.1f"));
        xAxes.add(Float.valueOf("12.9f"));
        xAxes.add(Float.valueOf("12.5f"));
        xAxes.add(Float.valueOf("12.3f"));
        xAxes.add(Float.valueOf("12.4f"));
        xAxes.add(Float.valueOf("12.7f"));
        xAxes.add(Float.valueOf("12.1f"));
        xAxes.add(Float.valueOf("12.3f"));
        xAxes.add(Float.valueOf("12.2f"));
*/

        /*yAxes.add(new Entry(	8.8f, 0));
        yAxes.add(new Entry(	8.7f, 1));
        yAxes.add(new Entry(8.4f, 2));
        yAxes.add(new Entry(	8.4f, 3));
        yAxes.add(new Entry(9f, 4));
        yAxes.add(new Entry(	8.4f, 5));
        yAxes.add(new Entry(0.2f, 6));
        yAxes.add(new Entry(0.2f, 7));
        yAxes.add(new Entry(0.2f, 8));
        yAxes.add(new Entry(	8.5f, 9));
        yAxes.add(new Entry(	8.5f, 10));
        yAxes.add(new Entry(1f, 11));
        yAxes.add(new Entry(1f, 12));
        yAxes.add(new Entry(1f, 13));
        yAxes.add(new Entry(1f, 14));
        yAxes.add(new Entry(0.1f, 15));
        yAxes.add(new Entry(0.3f, 16));
        yAxes.add(new Entry(8.2f, 17));
        yAxes.add(new Entry(8.5f, 18));
        yAxes.add(new Entry(	0f, 19));
        yAxes.add(new Entry(	0f, 20));
        yAxes.add(new Entry(0f, 21));
        yAxes.add(new Entry(	0f, 22));
        yAxes.add(new Entry(0f, 23));
        yAxes.add(new Entry(	0f, 24));
        yAxes.add(new Entry(0f, 25));
        yAxes.add(new Entry(0f, 26));
        yAxes.add(new Entry(0f, 27));
        yAxes.add(new Entry(	0f, 28));
        yAxes.add(new Entry(		7.2f, 29));
        yAxes.add(new Entry(	6.9f, 30));
        yAxes.add(new Entry(7.9f, 31));
        yAxes.add(new Entry(7.1f, 32));
        /*yAxes.add(new Entry(7.2f, 33));
        yAxes.add(new Entry(7.7f, 34));
        yAxes.add(new Entry(7.6f, 35));
        yAxes.add(new Entry(7.4f, 36));
        yAxes.add(new Entry(0.2f, 37));*/


        String[] xaxes = new String[xAxes.size()];

        for (int i = 0; i < xAxes.size(); i++) {
            xaxes[i] = xAxes.get(i).toString();
        }

        LineDataSet lineDataSet = new LineDataSet(yAxes, "values");
        lineDataSet.setDrawCircles(true);
        lineDataSet.setColor(Color.BLUE);

        lineDataSets.add(lineDataSet);

        lineChart.setData(new LineData(xaxes, lineDataSets));

        lineChart.setVisibleXRangeMaximum(100f);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);

    }
}