package me.person.hybrid_energy;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class LogIN extends AppCompatActivity {

    EditText Username;
    String user, pass;
    EditText Password;
    char iot;
    private Button SignIN;
    private TextView SignUP;
    String Json_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        Username = (EditText) findViewById(R.id.eT1);
        Password = (EditText) findViewById(R.id.eT2);
        SignIN = (Button) findViewById(R.id.b1);
        SignUP = (TextView) findViewById(R.id.tv2);


        //new network().execute();

        /*SignIN.setOnClickListener(new View.OnClickListener() {
            @Override*/


                /*}
                else{
                   System.out.println("Password do not match");
                }
            }

        }); */


        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUPIntent = new Intent(LogIN.this, Registration.class);
                LogIN.this.startActivity(SignUPIntent);

            }
        });
        SignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(),Password.getText().toString());




            }
        });

    }



    /*public void fetchJson(View view) {

        }*/

     class network extends AsyncTask<String, Void, String> {

        //JSONParser jsonParser;
        String url;

        @Override
        protected void onPreExecute() {
            //url="https://107.180.43.192/godad.php";
           //url="http://cleantechsjsu.com/godad.php";
            url = "http://10.0.2.2:8082/tophp.php";
            //.makeText(Home.this,"Connecting to Server...",Toast.LENGTH_LONG).show();
            //jsonParser=new JSONParser();
        }


        @Override
        protected String doInBackground(String... params) {
            try {

                URL url1 = new URL(url);
                HttpURLConnection con = (HttpURLConnection) url1.openConnection();
                InputStream inptstrm = con.getInputStream();
                con.setRequestMethod("GET");
                con.connect();
                BufferedReader bfr = new BufferedReader(new InputStreamReader(inptstrm));
                StringBuilder strngbldr = new StringBuilder();
                while ((Json_input = bfr.readLine()) != null) {
                    strngbldr.append(Json_input + "\n");
                }
                bfr.close();
                inptstrm.close();
                con.disconnect();
                return strngbldr.toString().trim();

                //System.out.println("fetched:" + val);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String str) {
            final String data = str;

            //changd frm here
            //JSONObject pmppwr = new JSONObject();  // create arr for grphs
            String curr3, curr1, curr2, turbflo;
            String vltg3, vltg1, vltg2;
            JSONArray pwr1 = null;

            float pmppwr, trbnpwr, eff, slrpwr, flo, tnk, valv;

            String pumppwr = null;
            String turbnpwr = null;
            String solrpwr = null;
            String effy = null;
            String frmwatr = null;
            JSONArray sys;

            List<Float> list = new ArrayList<Float>();

            try {
                JSONArray json = new JSONArray(data);

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);
                    //JSONArray jobj1= json.getJSONArray(i); //changed
                    //Log.d("Myapp","msg="+ jobj1);


                    //pwr1= jobj.getJSONArray("power");

                    vltg1 = jobj.getString("V_Pump");
                    //sys=jobj.getJSONArray("System_on");
                    curr1 = jobj.getString("I_Pump");
                    float v1 = parseFloat(vltg1);

                    float c1 = parseFloat(curr1);
                    pmppwr = v1 * c1;
                    pumppwr = Float.toString(pmppwr);
                    Log.d("msg",pumppwr);
                    list.add(pmppwr);

                    //pwr1= jobj.getJSONArray("power");
                    vltg2 = jobj.getString("V_Turbine");
                    turbflo = jobj.getString("I_Upper_Turbine");
                    float v2 = parseFloat(vltg2);
                    float c2 = parseFloat(turbflo);
                    trbnpwr = c2 * v2;
                    turbnpwr = Float.toString(trbnpwr);

                    vltg3 = jobj.getString("V_Solar");
                    curr3 = jobj.getString("I_Solar");
                    //pwr = jobj.getString("power"); //changed
                    float v3 = parseFloat(vltg3);
                    float c3 = parseFloat(curr3);
                    slrpwr = v3 * c3;
                    solrpwr = Float.toString(slrpwr);


                    float sp = parseFloat(solrpwr);
                    float tp = parseFloat(turbnpwr);
                    if(tp!=0){
                    eff = (sp) / (tp);}else{
                        eff=0;
                    }

                    float eff1 = eff;
                    effy = Float.toString(eff1);


                    frmwatr = jobj.getString("Water_uppertank_to_lowertank");

                }

            } catch (Exception e) {
                e.printStackTrace();
            } //till here
            //Log.d("Myapp","msg="+ pwr);
            //Log.d("Myapp","msg="+ data);
            //System.out.println("data : " + data);


            Intent HomIntent = new Intent(LogIN.this, Home.class);
            //Intent GrphIntent = new Intent(LogIN.this, Graph.class);
            HomIntent.putExtra("PmpPwr", pumppwr);
            HomIntent.putExtra("TurbnPwr", turbnpwr);
            HomIntent.putExtra("SolrPwr", solrpwr);
            HomIntent.putExtra("Eff", effy);
            HomIntent.putExtra("WaterReading", frmwatr);


            /*Intent FlowIntent = new Intent(LogIN.this, FloRead.class);
            FlowIntent.putExtra("PumpFlow", pmpflo);
            FlowIntent.putExtra("TurbnInput", turbinpt);
            FlowIntent.putExtra("FarmFlow", frmflo);
            */



            //changing


            //GrphIntent.putExtra("jsonArray",pwr1.toString());
            /*HomIntent.putExtra("SolrPwr", );
            HomIntent.putExtra("Eff", );
            HomIntent.putExtra("FlowReading", );
            HomIntent.putExtra("WaterReading", );
            HomIntent.putExtra("TankReading", );
            HomIntent.putExtra("Solenoidvlv", );*/

            LogIN.this.startActivity(HomIntent);
            //LogIN.this.startActivity(FlowIntent);
            //LogIN.this.startActivity(GrphIntent);
            //adapter.notifyDataSetChanged();


            //PmpPwr.setText(str);
        }

    }
    public void validate(String User, String Pass) {
        // final String usr= Username.getText().toString();
        //final String pwd= Password.getText().toString();

        if ((User.equals("user") && Pass.equals("pass"))) {
            Toast.makeText(LogIN.this, "Signing in...", Toast.LENGTH_LONG).show();
            new LogIN.network().execute();

        } else {
            Toast.makeText(LogIN.this, "Wrong credentials", Toast.LENGTH_LONG).show();
        }
    }


}






