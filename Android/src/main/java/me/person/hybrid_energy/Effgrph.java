package me.person.hybrid_energy;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

import static java.lang.Float.parseFloat;

public class Effgrph extends AppCompatActivity {

    TextView Ef;
    private ImageView Solr;
    private ImageView Eff;
    private ImageView Pup;
    String Json_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effgrph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Eff= (ImageView) findViewById(R.id.iv1);
        Pup = (ImageView) findViewById(R.id.iv2);
        Solr= (ImageView) findViewById(R.id.iv3);


        Eff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent efIntent = new Intent(Effgrph.this, solturb.class);
                //Effgrph.this.startActivity(efIntent);

                new Effgrph.network3().execute();
            }
        });

        Pup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent pIntent = new Intent(Effgrph.this, pmpgrph.class);
                //Effgrph.this.startActivity(pIntent);
                new Effgrph.network1().execute();
            }
        });

        Solr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent sIntent = new Intent(Effgrph.this, Solr.class);
                //Effgrph.this.startActivity(sIntent);

                new Effgrph.network2().execute();
            }
        });


    }

    class network1 extends AsyncTask<String, Void, String> {

        //JSONParser jsonParser;
        String url;

        @Override
        protected void onPreExecute() {
            //url = "http://cleantechsjsu.com/godad.php";
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
            String pmpflo = null;
            String turbinpt = null;
            String frmflo = null;
            String upr = null;
            String lwr = null;


            //List<String> list = null;
            ArrayList<String> list = null;
            ArrayList<String> list1 = null;
            try {
                JSONArray json = new JSONArray(data);
                list = new ArrayList<String>();
                list1 = new ArrayList<String>();

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);

                    pmpflo = jobj.getString("V_Pump");
                    list.add(pmpflo);

                    turbinpt = jobj.getString("I_Pump");
                    list1.add(turbinpt);
                    //frmflo = jobj.getString("I_Water_Farm");


                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            Intent pIntent = new Intent(Effgrph.this, pmpgrph.class);
            pIntent.putStringArrayListExtra("list", list);
            pIntent.putStringArrayListExtra("list1", list1);
            //pIntent.putParcelableArrayListExtra("list", list);
            Effgrph.this.startActivity(pIntent);


            //PmpPwr.setText(str);


        }

    }

    class network2 extends AsyncTask<String, Void, String> {

        //JSONParser jsonParser;
        String url;

        @Override
        protected void onPreExecute() {
            //url = "http://cleantechsjsu.com/godad.php";
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
            String pmpflo = null;
            String turbinpt = null;
            String frmflo = null;
            String upr = null;
            String lwr = null;


            //List<String> list = null;
            ArrayList<String> list = null;
            ArrayList<String> list1 = null;
            try {
                JSONArray json = new JSONArray(data);
                list = new ArrayList<String>();
                list1 = new ArrayList<String>();

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);

                    pmpflo = jobj.getString("V_Solar");
                    list.add(pmpflo);

                    turbinpt = jobj.getString("I_Solar");
                    list1.add(turbinpt);
                    //frmflo = jobj.getString("I_Water_Farm");


                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            Intent pIntent = new Intent(Effgrph.this, Solr.class);
            pIntent.putStringArrayListExtra("list", list);
            pIntent.putStringArrayListExtra("list1", list1);
            //pIntent.putParcelableArrayListExtra("list", list);
            Effgrph.this.startActivity(pIntent);


            //PmpPwr.setText(str);


        }

    }
    class network3 extends AsyncTask<String, Void, String> {

        //JSONParser jsonParser;
        String url;

        @Override
        protected void onPreExecute() {
            url="http://cleantechsjsu.com/godad.php";
            //url = "http://10.0.2.2:8082/tophp.php";
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

            String pumppwr ;
            String turbnpwr ;
            String solrpwr ;
            String effy = null;
            String frmwatr = null;
            JSONArray sys;

            //List<Float> list = new ArrayList<Float>();
            ArrayList<String> list = null;
            ArrayList<String> list1 = null;

            try {
                JSONArray json = new JSONArray(data);
                list = new ArrayList<String>();
                list1 = new ArrayList<String>();

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);

                    //pwr1= jobj.getJSONArray("power");
                    vltg2 = jobj.getString("V_Turbine");
                    turbflo = jobj.getString("I_Upper_Turbine");
                    float v2 = parseFloat(vltg2);
                    float c2 = parseFloat(turbflo);
                    trbnpwr = c2 * 9.81f * 0.75f * .1f;
                    turbnpwr = Float.toString(trbnpwr);

                    list.add(turbnpwr);

                    vltg3 = jobj.getString("V_Pump");
                    curr3 = jobj.getString("I_Pump");
                    //pwr = jobj.getString("power"); //changed
                    float v3 = parseFloat(vltg3);
                    float c3 = parseFloat(curr3);
                    slrpwr = v3 * c3;
                    solrpwr = Float.toString(slrpwr);

                    list1.add(solrpwr);



                    }




            } catch (Exception e) {
                e.printStackTrace();
            } //till here
            //Log.d("Myapp","msg="+ pwr);
            //Log.d("Myapp","msg="+ data);
            //System.out.println("data : " + data);


            Intent pIntent = new Intent(Effgrph.this, solturb.class);
            pIntent.putStringArrayListExtra("list", list);
            pIntent.putStringArrayListExtra("list1", list1);
            //pIntent.putParcelableArrayListExtra("list", list);
            Effgrph.this.startActivity(pIntent);


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

            //Effgrph.this.startActivity(HomIntent);
            //LogIN.this.startActivity(FlowIntent);
            //LogIN.this.startActivity(GrphIntent);
            //adapter.notifyDataSetChanged();


            //PmpPwr.setText(str);
        }

    }

}
