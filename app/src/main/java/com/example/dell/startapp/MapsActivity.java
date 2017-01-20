package com.example.dell.startapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        getloc();
        getdata();
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    double lati = 0, longi = 0;
    Location l = null;

    private void getloc() {

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);

        for (int i = providers.size() - 1; i >= 0; i--) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            l = lm.getLastKnownLocation(providers.get(i));
            if(l!=null)
                break;
        }
        if(l!=null)
        {
            lati=l.getLatitude();
            longi=l.getLongitude();
        }

    }
    void getdata()
    {

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(MapsActivity.this,"https://maps.googleapis.com/maps/api/place/search/json?location=23.0395677,72.5660044&radius=5000000&name=business incubator&key=AIzaSyDWpgQxAFzsD1DnDGEGd_vFZDFmK5HucIw",new JsonHttpResponseHandler(){

            ProgressDialog mProgressDialog;
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                ArrayList<String> na;
                double[] lat;
                double[] lon;

                na=new ArrayList<String>();
                double x=0,y=0;
                try {
                    JSONArray mJsonArray=response.getJSONArray("results");
                    lat=new double[mJsonArray.length()];
                    lon=new double[mJsonArray.length()];
                    JSONObject mJsonObject;
                    for(int i=0;i<mJsonArray.length();i++)
                    {
                        mJsonObject=mJsonArray.getJSONObject(i);

                        JSONObject m1=mJsonObject.getJSONObject("geometry");
                        JSONObject m2=m1.getJSONObject("location");
                        lat[i]= m2.getDouble("lat");
                        lon[i]=m2.getDouble("lng");
                        na.add(mJsonObject.getString("name"));

                    }
                    for(int i=0;i<na.size();i++) {
                        mMap.addMarker(new MarkerOptions().position(new LatLng(lat[i],lon[i])).title(na.get(i).toString()));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgressDialog= ProgressDialog.show(MapsActivity.this, "Loding ", "Please Wait");
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgressDialog.isShowing())
                {
                    mProgressDialog.dismiss();
                }
            }
        });
    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(lati, longi)).title("Marker"));
        CameraPosition camPos = new CameraPosition.Builder()
                .target(new LatLng(lati, longi))
                .zoom(18)
                .bearing(l.getBearing())
                .tilt(90)
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mMap.animateCamera(camUpd3);
    }
}
