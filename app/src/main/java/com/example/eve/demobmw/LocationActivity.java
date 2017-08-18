package com.example.eve.demobmw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    public String s;
    public ArrayList<LocationInfo> locationInfos;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        s = "http://localsearch.azurewebsites.net/api/Locations";
        locationInfos = Presenter.getInstance().getArray();

        getLocations();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        LocationAdapter adapter = new LocationAdapter(this, locationInfos);
 //       recyclerView.setAdapter(adapter);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(LocationActivity.this, "Showing Map",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.item2) {
            Toast.makeText(LocationActivity.this, "Show List",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LocationActivity.this, MapActivity.class);
            startActivity(intent);

        }

        return true;
    }


    public void getLocations() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, s, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    if (!response.contains("No HTTP resource was found")) {

                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject infoObj = jsonArray.getJSONObject(i);

                            LocationInfo info = new LocationInfo(infoObj.getString("ID"), infoObj.getString("Name"),
                                    infoObj.getString("Latitude"),infoObj.getString("Longitude"),
                                    infoObj.getString("Address"),infoObj.getString("ArrivalTime"));

                            locationInfos.add(info);

                        }
                        LocationAdapter adapter = new LocationAdapter(getBaseContext(), locationInfos);
                        recyclerView.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = "";
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }





}
