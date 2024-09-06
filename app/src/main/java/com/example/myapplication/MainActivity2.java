package com.example.myapplication;

import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.Toast;
import android.util.Log;
import android.os.AsyncTask;



public class MainActivity2 extends AppCompatActivity {

    /*private String TAG = MainActivity2.class.getSimpleName();
    private ListView listView;

    ArrayList<HashMap<String, String>> addressList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addressList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_view_id);
        //new GetAddress().execute();
    }*/


    public String GetAssetSpotJson(Context context, String spot ) {
        String json = null;
        try {
                InputStream inputStream = context.getAssets().open("spot.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.e("spot.json", json);
        return json;
    }


    //à modifier
    Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try {

            ListView listView = (ListView) findViewById(R.id.list_view_id);

            List<String> items = new ArrayList<>();
            JSONObject root = new JSONObject(json_string);

            JSON = root.getJSONArray("array");

            this.setTitle(root.getString("title"));

            for(int i=0;i<array.length();i++)
            {
                JSONObject object= array.getJSONObject(i);
                items.add(object.getString("company"));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }

            JSONObject nested= root.getJSONObject("nested");
            Log.d("TAG","flag value "+nested.getBoolean("flag"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}




