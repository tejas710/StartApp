package com.example.dell.startapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class eventDetail extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customcolor)));

        t1 = (TextView)findViewById(R.id.eventtitleDetail_textView5);
        t2 = (TextView)findViewById(R.id.eventstarttime_textView6);
        t3 = (TextView)findViewById(R.id.eventEndtimeDdatail_textView7);
        t4 = (TextView)findViewById(R.id.eventDatedetail_textView8);
        t5 = (TextView)findViewById(R.id.eventDescdetail_textView9);
        t6 = (TextView)findViewById(R.id.eventEndDateDdatail_textView10);
        t7 = (TextView)findViewById(R.id.eventvenuedetail_textView11);
        t8 = (TextView)findViewById(R.id.eventisvideosessiondetail_textView9);
        Intent it = getIntent();
        String eventname = it.getStringExtra("eventName");
        String eventdate = it.getStringExtra("eventStartDate");
        String eventstartime = it.getStringExtra("eventStartTime");
        String eventendtime = it.getStringExtra("eventEndTime");
        String eventdesc = it.getStringExtra("eventDescription");
        String eventEndDate = it.getStringExtra("eventEndDate");
        String eventVenue = it.getStringExtra("eventVenue");
        String IsvideoSession = it.getStringExtra("IsVideoSession");

        getSupportActionBar().setTitle(eventname);
        t1.setText(eventname+"");
        t2.setText(eventstartime+"");
        t3.setText(eventendtime+"");
        t4.setText(eventdate+"");
        t5.setText(eventdesc+"");
        t6.setText(eventEndDate+"");
        t7.setText(eventVenue+"");
        t8.setText(IsvideoSession+"");





        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
