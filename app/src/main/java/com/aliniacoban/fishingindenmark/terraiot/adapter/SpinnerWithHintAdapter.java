package com.aliniacoban.fishingindenmark.terraiot.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.aliniacoban.fishingindenmark.R;

public class SpinnerWithHintAdapter extends ArrayAdapter<String> {

    Context context;
    public SpinnerWithHintAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView tvSpinner = (TextView) view;
        if(position == 0){
            // setting the hint text color primary color
            if(Build.VERSION.SDK_INT < 23){
                tvSpinner.setTextColor(Color.WHITE);
            }else {
                tvSpinner.setTextColor(Color.WHITE);
            }
        }else {
            tvSpinner.setTextColor(Color.WHITE);
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tvSpinner = (TextView) view;
        view.setBackgroundColor(Color.BLUE);
        if(position == 0){
            // setting the hint text color primary color
            if(Build.VERSION.SDK_INT < 23){
                tvSpinner.setTextColor(Color.WHITE);
            }else {
                tvSpinner.setTextColor(Color.WHITE);
            }
        }else {
            tvSpinner.setTextColor(Color.WHITE);
        }
        return view;
    }

    // optional
    @Override
    public boolean isEnabled(int position){
        // not going to enable the first item of the spinner as it is hint
        if(position == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public int getCount() {
        // exclude first element as it is the hint text
        return super.getCount()==0?0:super.getCount()-1;
    }
}