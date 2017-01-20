package com.example.dell.startapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 04-11-2016.
 */

public class blog_custom_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<blogclass> mArrayList;
    LayoutInflater mLayoutInflater;

    public blog_custom_adpter(Context mContext, ArrayList<blogclass> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        blog_view_holder mitem;
        if(convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.grid_custom_blog,null);
            mitem=new blog_view_holder((TextView)convertView.findViewById(R.id.blogtitle_textView));
            convertView.setTag(mitem);

        }
        else
        {
            mitem= (blog_view_holder) convertView.getTag();
        }
        mitem.t1.setText(mArrayList.get(position).getBlogTitle());


        return convertView;
    }
}