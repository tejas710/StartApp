package com.example.dell.startapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Blogdetail extends AppCompatActivity {
    TextView t1,t2,t3;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogdetail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customcolor)));

        t1 = (TextView)findViewById(R.id.bolgdetail_textView5);
        t2 = (TextView)findViewById(R.id.bolgdetail_textView6);
        t3 = (TextView)findViewById(R.id.bolgdetail_textView7);
        i1 = (ImageView)findViewById(R.id.bolgdetail_imageView2);
        Intent it = getIntent();
        String blogTitle = it.getStringExtra("blogTitle");
        String blogdesc = it.getStringExtra("blogDescription");
        String blogImagepath = it.getStringExtra("blogImagePath");
        String postedUser = it.getStringExtra("postedUser");

        getSupportActionBar().setTitle(blogTitle);
        t1.setText(blogTitle+"");
        t2.setText(blogdesc+"");
        t3.setText(postedUser+"");
        Picasso.with(this).load(blogImagepath).into(i1);


    }

}
