package com.example.dell.startapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class register extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText txtemail,txtuname,txtpass,txtage,txtgender,txtbgroup,txtnum,txtaddress,txtcity,txtstate,txtdonate_date;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtemail=(EditText)findViewById(R.id.edittext_email);
        txtpass=(EditText)findViewById(R.id.edittext_pass);
        txtnum=(EditText)findViewById(R.id.edittext_contactno);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client=new AsyncHttpClient();
                client.addHeader("Accept","application/json");
                client.addHeader("Content-Type","application/json");
                JSONObject object=new JSONObject();
                StringEntity mStringEntity=null;
                try {
                    object.put("email",txtemail.getText()+"");
                    object.put("pass",txtpass.getText()+"");
                    object.put("num",Long.parseLong(txtnum.getText()+""));
                    object.put("uname","tej");
                    object.put("gender","male");
                    object.put("age","22");
                    object.put("bgroup","A+");

                    object.put("address","Vijayanagr");
                    object.put("city","abad");
                    object.put("state","Gujarat");
                    object.put("donate_date","8 dec");
                    mStringEntity=new StringEntity(object.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                client.post(register.this,"http://www.jinalshah.brainoorja.com/WebService_jsb11.asmx/user_registration",mStringEntity,"application/json",new JsonHttpResponseHandler(){

                    ProgressDialog mProgressDialog;
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);

                        try {
                            int ans=response.getInt("d");
                            if(ans==1)
                            {
                                Constant.val=txtemail.getText()+"";
                                Toast.makeText(register.this,"Register Succesfully",Toast.LENGTH_LONG).show();
                                Intent it=new Intent(register.this,login.class);
                                startActivity(it);
                            }
                            else
                            {
                                Toast.makeText(register.this,"Register Failed",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(register.this, "No Data Connection", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog= ProgressDialog.show(register.this,"Loading","Please Wait");

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
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        getMenuInflater().inflate(R.menu.register, menu);
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

        if (id == R.id.nav_login) {
            Intent i = new Intent(register.this, login.class);
            startActivity(i);
        } else if (id == R.id.nav_infodcei) {
            Intent i = new Intent(register.this, infoDcei.class);
            startActivity(i);
        } else if (id == R.id.nav_event) {

        } else if (id == R.id.nav_quaryforum) {

        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "ceid.daiict.ac.in");
            startActivity(Intent.createChooser(intent, "Share with"));

        } else if (id == R.id.nav_blog) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
