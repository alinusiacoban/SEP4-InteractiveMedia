package com.aliniacoban.fishingindenmark.terraiot.ui.co2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.databinding.CO2FragmentBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class CO2Fragment extends Fragment  {

    private CO2ViewModel co2ViewModel;
    private CO2FragmentBinding binding;
    private LineChart mChart;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        co2ViewModel =
                new ViewModelProvider(this).get(CO2ViewModel.class);

        binding = CO2FragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCO2;
        co2ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        mChart=root.findViewById(R.id.co2_chart);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        ArrayList<Entry> yValue= new ArrayList<>();

        yValue.add(new Entry(0,60f));
        yValue.add(new Entry(1,50f));
        yValue.add(new Entry(2,70f));
        yValue.add(new Entry(3,30f));
        yValue.add(new Entry(4,50f));
        yValue.add(new Entry(5,60f));
        LineDataSet set1= new LineDataSet(yValue,"Data set 1");
        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets= new ArrayList<>();
        dataSets.add(set1);
        LineData data= new LineData(dataSets);
        mChart.setData(data);

        return root;
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}