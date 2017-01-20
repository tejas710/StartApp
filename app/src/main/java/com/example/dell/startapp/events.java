package com.example.dell.startapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class events extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<eventclass> mArrayList;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customcolor)));

        mArrayList = new ArrayList<eventclass>();
        mListView = (ListView) findViewById(R.id.activity_getallevent_listView);
        AsyncHttpClient mClient = new AsyncHttpClient();
        mClient.addHeader("Accept", "application/json");
        mClient.addHeader("Content-Type", "application/json");
        mClient.get(this, "http://dcei.esy.es/events.php", new JsonHttpResponseHandler() {
                    ProgressDialog mProgressDialog;

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.i("tejas","12222");
                        try {
                            JSONArray mJsonArray = response.getJSONArray("server_response");
                            JSONObject mJsonObject;

                            for (int i = 0; i < mJsonArray.length(); i++) {
                                mJsonObject = mJsonArray.getJSONObject(i);

                                mArrayList.add(new eventclass(mJsonObject.getString("eventName"), mJsonObject.getString("startTime"), mJsonObject.getString("endTime"), mJsonObject.getString("startDate"), mJsonObject.getString("eventDescription"),mJsonObject.getString("endDate"),mJsonObject.getString("isVideoSession"),mJsonObject.getString("venue")));
                                Log.i("tejas",mJsonObject.getString("startDate"));

                            }
                            mListView.setAdapter(new event_custom_adpter(events.this, mArrayList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("tejas","1234");
                        }
                        Log.i("tejas","1333");

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(events.this, "No Data Connection!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog = ProgressDialog.show(events.this, "Loading", "Please Wait", true, false);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }
                    }
                }

        );
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                eventclass e=(eventclass) parent.getItemAtPosition(position);
                Intent it=new Intent(events.this,eventDetail.class);
                it.putExtra("eventName",e.getEventName()+"");
                it.putExtra("eventStartDate",e.getStartDate()+"");
                it.putExtra("eventStartTime",e.getStartTime()+"");
                it.putExtra("eventEndTime",e.getEndTime()+"");
                it.putExtra("eventDescription",e.getEventDescription()+"");
                it.putExtra("eventEndDate",e.getEndDate()+"");
                it.putExtra("IsVideoSession",e.getIsVideoSession()+"");
                it.putExtra("eventVenue",e.getVenue()+"");
                startActivity(it);

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
