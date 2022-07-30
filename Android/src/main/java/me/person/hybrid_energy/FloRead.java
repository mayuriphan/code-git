package me.person.hybrid_energy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class FloRead extends AppCompatActivity {
    TextView PumpFlow,TurbnInput,FarmFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flo_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       PumpFlow = (TextView) findViewById(R.id.tv4);
       TurbnInput = (TextView) findViewById(R.id.tv5);
       FarmFlow = (TextView) findViewById(R.id.tv6);

        Bundle bndl = getIntent().getExtras();
        String data_1 = bndl.getString("PumpFlow");
        PumpFlow.setText(data_1);
        String data_2 = bndl.getString("TurbnInput");
        TurbnInput.setText(data_2);
        String data_3 = bndl.getString("FarmFlow");
        FarmFlow.setText(data_3);


    }

}
