package com.example.dell.startapp;

import android.widget.TextView;

/**
 * Created by DELL on 29-10-2016.
 */

public class event_view_holder {
    TextView t1,t2,t3,t4,t5;
    public event_view_holder(TextView t1, TextView t2, TextView t3, TextView t4, TextView t5) {

        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
    }
    public TextView getT1() {
        return t1;
    }

    public void setT1(TextView t1) {
        this.t1 = t1;
    }

    public TextView getT2() {
        return t2;
    }

    public void setT2(TextView t2) {
        this.t2 = t2;
    }

    public TextView getT3() {
        return t3;
    }

    public void setT3(TextView t3) {
        this.t3 = t3;
    }

    public TextView getT4() {
        return t4;
    }

    public void setT4(TextView t4) {
        this.t4 = t4;
    }

    public TextView getT5() {
        return t5;
    }

    public void setT5(TextView t5) {
        this.t5 = t5;
    }


}
