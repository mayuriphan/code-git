package me.person.hybrid_energy;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
import java.util.HashMap;
import java.util.Map;

import static java.lang.Float.parseFloat;

public class Home extends AppCompatActivity {


    //private ImageView System;

    //JSONObject read= new JSONObject(input);
    private TextView PmpPwr;
    private TextView Water;
    private TextView TurbnPwr;
    private TextView SolrPwr;
    private TextView Eff;
    private TextView FlowReading;
    private TextView WaterReading;
    private TextView Solenoidvlv;
    private TextView TankReading;
    private ImageView Sys;
    private ImageView Sens;
    private ImageView Loc;
    //private ImageView Btn;
    private boolean isOn = false;
    private int on;
    private int off;
    private int pass;
    String Json_input;
    String Json_input1;
    Button insert;
    RequestQueue req;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Lnrly=(LinearLayout)findViewById(R.id.ll1);

        //PmpPwr.setMovementMethod(LinkMovementMethod.getInstance());
        TurbnPwr = (TextView) findViewById(R.id.tv2);
        SolrPwr = (TextView) findViewById(R.id.tv4);
        //System= (ImageView) findViewById(R.id.iv1);
        Eff = (TextView) findViewById(R.id.tv6);
        FlowReading = (TextView) findViewById(R.id.tv9);
        Water = (TextView) findViewById(R.id.tv11);
        WaterReading = (TextView) findViewById(R.id.tv12);
        TankReading = (TextView) findViewById(R.id.tv13);
        Solenoidvlv = (TextView) findViewById(R.id.tv15);
        PmpPwr = (TextView) findViewById(R.id.tv);
        Sys = (ImageView) findViewById(R.id.iv1);
        Sens = (ImageView) findViewById(R.id.iv2);
        Loc = (ImageView) findViewById(R.id.iv3);
        //String a="NaN";

        Bundle bndl = getIntent().getExtras();
        String data_1 = bndl.getString("PmpPwr");
        PmpPwr.setText(data_1);
        String data_2 = bndl.getString("TurbnPwr");
        TurbnPwr.setText(data_2);
        String data_3 = bndl.getString("SolrPwr");
        SolrPwr.setText(data_3);
        String data_4 = bndl.getString("Eff");
        Eff.setText(data_4);
        String data_5 = bndl.getString("WaterReading");
        Water.setText(data_5);

        req = Volley.newRequestQueue(getApplicationContext());

        /*String data_3=bndl.getString("SolrPwr");
        PmpPwr.setText(data_3);
        String data_4=bndl.getString("Eff");
        Eff.setText(data_4);
        String data_5=bndl.getString("FlowReading");
        FlowReading.setText(data_5);
        String data_6=bndl.getString("WaterReading");
        WaterReading.setText(data_6);
        String data_7=bndl.getString("TankReading");

        TankReading.setText(data_7);
        String data_8=bndl.getString("Solenoidvlv");
        Solenoidvlv.setText(data_8);*/


        //new ntwrk().execute();
        Water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fIntent = new Intent(Home.this, FlowReading.class);
                Home.this.startActivity(fIntent);
                //new Home.network5().execute();

            }
        });

        PmpPwr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pwrIntent = new Intent(Home.this, Graph1.class);
                Home.this.startActivity(pwrIntent);
               //new Home.network5().execute();

            }
        });/*
        TurbnPwr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trbnpwrIntent = new Intent(Home.this,LogIN.class);
                Home.this.startActivity(trbnpwrIntent);
            }
        });*/
        Loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locIntent = new Intent(Home.this,location.class);
                Home.this.startActivity(locIntent);
            }
        });

        Eff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Home.network2().execute();
            }
        });

        FlowReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Home.network1().execute();

            }
        });
       /* WaterReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wtrIntent = new Intent(Home.this,LogIN.class);
                Home.this.startActivity(wtrIntent);
            }
        });*/
        TankReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Home.network().execute();
            }
        });

        Solenoidvlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vlvIntent = new Intent(Home.this, Valves.class);
                Home.this.startActivity(vlvIntent);

            }
        });


        Sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final JSONObject jobj = new JSONObject();
                //try{
                if (isOn == true) {

                    Sys.setImageResource(R.drawable.pwr);
                    isOn = false;
                    Toast.makeText(Home.this, "System is off", Toast.LENGTH_LONG).show();
                    //jobj.put("ON/OFF",0);
                    //Intent onIntent = new Intent(Home.this, Sys_on.class);
                    //Home.this.startActivity(onIntent);
                    InsertSV();



                } else {
                    Sys.setImageResource(R.drawable.powerr);
                    isOn = true;
                    Toast.makeText(Home.this, "System is on", Toast.LENGTH_LONG).show();
                    //new networks().execute();
                    //jobj.put("ON/OFF", 0);
                    //Log.d("Myapp","msg="+ jobj);
                    InsertSV1();
                }
            }

            // new networks().execute();


            // }
        });

        Sens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SensorIntent = new Intent(Home.this, webView.class);
                Home.this.startActivity(SensorIntent);

            }

            // new networks().execute();

            // }
        });


    }

    public void InsertSV() {
        String inserturl="http://10.0.2.2:8082/system.php";

        StringRequest request = new StringRequest(Request.Method.POST, inserturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("System_on_off", "0");

                return params;
            }
        };
        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(request);
    }


    public void InsertSV1() {
        String inserturl="http://10.0.2.2:8082/system.php";

        StringRequest request = new StringRequest(Request.Method.POST, inserturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("System_on_off", "1");

                return params;
            }
        };
        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(request);
    }





   /* private String json_convrsn() {
        final JSONObject jobj = new JSONObject();
        try {
            if (isOn == true) {

                Sys.setImageResource(R.drawable.pwr);
                isOn = false;
                Toast.makeText(Home.this, "System is off", Toast.LENGTH_LONG).show();
                jobj.put("ON/OFF", 0);
            } else {
                Sys.setImageResource(R.drawable.powerr);
                isOn = true;
                Toast.makeText(Home.this, "System is on", Toast.LENGTH_LONG).show();
                jobj.put("ON/OFF", 1);
            }

            return jobj.toString(1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }



        //final String jsonStrng = json_convrsn();*/
    /*class networks extends AsyncTask<Void, Void, String> {
        String url,usr,pwd;


                //return srvrRepo(jsonStrng);


                    /*try{
                    if (isOn == true)

                        Sys.setImageResource(R.drawable.pwr);
                        isOn = false;
                        Toast.makeText(Home.this, "System is off", Toast.LENGTH_LONG).show();


                        //new network1.execute("http://10.0.2.2:8082/phpmyadmin/tbl_structure.php?db=project_db&table=system, pass.toString());

                        new networks().execute("http://localhost:8082/phpmyadmin/sql.php?server=1&db=project_db&table=system&pos=0",jobj.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                else {
                    Sys.setImageResource(R.drawable.powerr);
                    isOn = true;
                    pass = 1;
                    Toast.makeText(Home.this, "System is on", Toast.LENGTH_LONG).show();
                }

*/


    //JSONParser jsonParser;

        /*@Override
        protected void onPreExecute(){
             url = ("http://10.0.2.2:8082/phpmyadmin/project_db");
             usr="root";
             pwd="";
            //.makeText(Home.this,"Connecting to Server...",Toast.LENGTH_LONG).show();
            //jsonParser=new JSONParser();
        }



                /*try {
                    URL url1 = new URL(url);

                HttpURLConnection con = (HttpURLConnection) new URL(params[0]).openConnection();
                        con.setRequestMethod("POST");
                        con.setDoOutput(true);
                        DataOutputStream outptstrm = new DataOutputStream(con.getOutputStream());
                        outptstrm.writeBytes("PostData=" + params[1]);
                        outptstrm.flush();
                        outptstrm.close();

                        InputStream in = con.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(in);

                        //con.connect();
                        //System.out.println("fetched:" + val);
                        int inputStreamData = inputStreamReader.read();
                        while (inputStreamData != -1) {
                            char currentData = (char) inputStreamData;
                            inputStreamData = inputStreamReader.read();
                            pass += currentData;
                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



        /*@Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }*/
    // @Override
    //protected String doInBackground(Void... params) {

            /*String str = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(url, usr, pwd);
                String qry = "insert into system(ON/OFF)values(jobj)";
                Statement statmnt = connect.createStatement();
                statmnt.executeUpdate(qry);
                connect.close();
                str = "success";
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JSONObject jobj = new JSONObject();
            try{
                if (isOn == true){

                    Sys.setImageResource(R.drawable.pwr);
                    isOn = false;
                    Toast.makeText(Home.this, "System is off", Toast.LENGTH_LONG).show();
                    jobj.put("ON/OFF",0);


                }else {
                    Sys.setImageResource(R.drawable.powerr);
                    isOn = true;
                    Toast.makeText(Home.this, "System is on", Toast.LENGTH_LONG).show();
                    //new networks().execute();
                    jobj.put("ON/OFF", 1);
                    //Log.d("Myapp","msg="+ jobj);
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


            @Override
           public void onPostExecute(String str) {
           super.onPostExecute(str);


            }*/


    //  }


    //}
   /* private String srvrRepo(String jsonStrng) {
        HttpPost htpost= new HttpPost("\"http://localhost:8082/phpmyadmin/sql.php?server=1&db=project_db&table=system");
        try {
            StringEntity ent=new StringEntity(jsonStrng);
            htpost.setEntity(ent);
            htpost.setHeader("Content-type","application/json");
            DefaultHttpClient usr=new DefaultHttpClient();
            BasicResponseHandler hndlr=new BasicResponseHandler();
            String str=usr.execute(htpost,hndlr);
            return str;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    //changed
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


            try {
                JSONArray json = new JSONArray(data);

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);

                    pmpflo = jobj.getString("I_Lower_Pump");
                    turbinpt = jobj.getString("I_Upper_Turbine");
                    frmflo = jobj.getString("I_Water_Farm");


                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            Intent FlowIntent = new Intent(Home.this, FloRead.class);
            FlowIntent.putExtra("PumpFlow", pmpflo);
            FlowIntent.putExtra("TurbnInput", turbinpt);
            FlowIntent.putExtra("FarmFlow", frmflo);

            Home.this.startActivity(FlowIntent);
            //PmpPwr.setText(str);


        }

    }


    class network extends AsyncTask<String, Void, String> {

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

            String upr = null;
            String lwr = null;


            try {
                JSONArray json = new JSONArray(data);

                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);

                    upr = jobj.getString("Upper_reservoir_full");
                    lwr = jobj.getString("Lower_reservoir_full");


                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            //PmpPwr.setText(str);

            Intent FloIntent = new Intent(Home.this, TankRead.class);
            FloIntent.putExtra("Uprflo", upr);
            FloIntent.putExtra("Lwrflo", lwr);

            Home.this.startActivity(FloIntent);
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

            String upr = null;
            String lwr = null;


            //JSONArray json1 = null;
            //JSONArray s = null;
            String s = null;
            String s1 = null;

            HashMap<String, String> contact = null;
            //JSONArray s = null;
            //List<JSONObject> val = new ArrayList<>();

            try {
                JSONArray json = new JSONArray(data);


                //s = new JSONArray();
                JSONObject jobj = new JSONObject(data);

                //json1 = new JSONArray();

                //JSONObject pmppwr = new JSONObject();
                //for (int i = 0; i < json.length(); i++) {


                s = jobj.getString("Lower_reservoir_full");


                //lwr = jobj.getString("Lower_reservoir_full");


                //}


            } catch (Exception e) {
                e.printStackTrace();
            }


            //PmpPwr.setText(str);
            Intent effIntent = new Intent(Home.this, Effgrph.class);
            Bundle b = new Bundle();
            b.putString("Pump", s);
            effIntent.putExtras(b);


            //effIntent.putExtra("Pump", s);


            Home.this.startActivity(effIntent);
        }
    }

    /*class network3 extends AsyncTask<String, Void, String> {

        //JSONParser jsonParser;
        String url;

        @Override
        protected void onPreExecute() {
            url = "http://10.0.2.2:8082/toophp.php";
            //url = "http://10.0.2.2:8082/tophp.php";
            //.makeText(Home.this,"Connecting to Server...",Toast.LENGTH_LONG).show();
            //jsonParser=new JSONParser();
        }


        @Override
        protected String doInBackground(String... params) {

            OutputStream os = null;
            InputStream is = null;
            HttpURLConnection conn = null;
            try {

                URL url1 = new URL(url);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("TimeStampDate", "");
                jsonObject.put("V_Solar", "");
                jsonObject.put("V_Battery", "");
                jsonObject.put("V_Turbine", "");
                jsonObject.put("V_Pump", "");
                jsonObject.put("I_Solar", "");
                jsonObject.put("I_Pump", "");
                jsonObject.put("I_Lower_Pump", "");
                jsonObject.put("I_Upper_Turbine", "");
                jsonObject.put("I_Water_Farm", "");
                jsonObject.put("Water_uppertank_in_Gallon", "");
                jsonObject.put("Water_uppertank_to_lowertank", "");
                jsonObject.put("Upper_reservoir_full", "");
                jsonObject.put("Lower_reservoir_full", "");
                jsonObject.put("Turbine_valve", "");
                jsonObject.put("Upper_reservoir_valve", "");
                jsonObject.put("Water_to_farm_valve", "");
                jsonObject.put("Latitude", "");
                jsonObject.put("Longitude", "");
                jsonObject.put("System_on", "1");
                jsonObject.put("State", "");
                String message = jsonObject.toString();

                conn = (HttpURLConnection) url1.openConnection();
                conn.setReadTimeout(10000 /*milliseconds);
                conn.setConnectTimeout(15000 /* milliseconds );
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(message.getBytes().length);

                //make some HTTP header nicety
                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                //open
                conn.connect();

                //setup send
                os = new BufferedOutputStream(conn.getOutputStream());
                os.write(message.getBytes());
                //clean up
                os.flush();

                //do somehting with response
                is = conn.getInputStream();


                //System.out.println("fetched:" + val);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                //clean up
                try {
                    os.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                conn.disconnect();

                return null;
            }
        }
*/
    class network5 extends AsyncTask<String, Void, String> {

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
            String curr3, curr1, curr2, turbflo;
            String vltg3, vltg1, vltg2;
            JSONArray pwr1 = null;

            float pmppwr, trbnpwr, eff, slrpwr, flo, tnk, valv;

            String pumppwr = null;
            String turbnpwr = null;
            ArrayList<String> list = null;
            try {
                list = new ArrayList<String>();
                //list1 = new ArrayList<String>();
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
            String curr3, curr1, curr2, turbflo;
            String vltg3, vltg1, vltg2;
            JSONArray pwr1 = null;
            String pumppwr = null;

            float pmppwr, trbnpwr, eff, slrpwr, flo, tnk, valv;
            ArrayList<String> list = null;

            try {
                JSONArray json = new JSONArray(data);
                list = new ArrayList<String>();
                //list1 = new ArrayList<String>();
                //JSONObject pmppwr = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jobj = json.getJSONObject(i);
                    vltg1 = jobj.getString("V_Pump");
                    //sys=jobj.getJSONArray("System_on");
                    curr1 = jobj.getString("I_Pump");

                    float v1 = parseFloat(vltg1);

                    float c1 = parseFloat(curr1);
                    pmppwr = v1 * c1;
                    pumppwr = Float.toString(pmppwr);
                    list.add(pumppwr);


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent pIntent = new Intent(Home.this, Graph1.class);
            pIntent.putStringArrayListExtra("list", list);
            //pIntent.putStringArrayListExtra("list1", list1);
            //pIntent.putParcelableArrayListExtra("list", list);
            Home.this.startActivity(pIntent);





        }

    }




}







