package me.person.hybrid_energy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class TankRead extends AppCompatActivity {

    TextView Uprflo,Lwrflo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Uprflo = (TextView) findViewById(R.id.tv3);
        Lwrflo= (TextView) findViewById(R.id.tv4);

        Bundle bndl = getIntent().getExtras();
        String data_1 = bndl.getString("Uprflo");
        Uprflo.setText(data_1);
        String data_2 = bndl.getString("Lwrflo");
        Lwrflo.setText(data_2);


    }

}
