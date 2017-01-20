package com.example.dell.startapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 29-10-2016.
 */

public class event_custom_adpter extends BaseAdapter {
    Context mContext;
    ArrayList<eventclass> mArrayList;
    LayoutInflater mLayoutInflater;

    public event_custom_adpter(Context mContext, ArrayList<eventclass> mArrayList) {
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
        event_view_holder mitem;
        if(convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.grid_custom_event,null);
            mitem=new event_view_holder((TextView)convertView.findViewById(R.id.eventname_textView),(TextView)convertView.findViewById(R.id.eventstarttime_textView),(TextView)convertView.findViewById(R.id.eventendtime_textView),(TextView)convertView.findViewById(R.id.eventdate_textView),(TextView)convertView.findViewById(R.id.eventEnddate_textView));
            convertView.setTag(mitem);

        }
        else
        {
            mitem= (event_view_holder) convertView.getTag();
        }
        mitem.t1.setText(mArrayList.get(position).getEventName());
        mitem.t2.setText(mArrayList.get(position).getStartTime());
        mitem.t3.setText(mArrayList.get(position).getEndTime());
        mitem.t4.setText(mArrayList.get(position).getStartDate());
        mitem.t5.setText(mArrayList.get(position).getEndDate());

        return convertView;
    }
}
