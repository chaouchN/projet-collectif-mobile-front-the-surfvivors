package com.example.myapplication;

import org.json.JSONObject;
import org.json.JSONException;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.Toast;
import android.util.Log;
import android.os.AsyncTask;



public class MainActivity2 extends AppCompatActivity {

    private String TAG = MainActivity2.class.getSimpleName();
    private ListView listView;

    ArrayList<HashMap<String, String>> addressList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addressList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_view_id);
        new GetAddress().execute();
    }

    private class GetAddress extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity2.this, "Json Spot is downloading", Toast.LENGTH_LONG).show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            String jsonStr = null;
            try {
                // Lire le fichier JSON depuis les assets
                InputStream is = getAssets().open("spot.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                jsonStr = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                Log.e(TAG, "Error reading JSON file", ex);
                return null;
            }
                //try {
                // get JSONObject from JSON file
                //JSONObject obj = new JSONObject("{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}");
                // fetch JSONObject named Records
                // JSONObject records = obj.getJSONObject("surf break");

                //surf_break = records.getString("surf break");

                // set employee name and salary in TextView's
                //records.setText("Surf break: "+ surf_break);

                //System.out.println(obj);

                // } catch (JSONException e) {
                //  e.printStackTrace();
            }
        }
