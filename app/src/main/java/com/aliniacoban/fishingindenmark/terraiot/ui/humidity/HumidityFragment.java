package com.aliniacoban.fishingindenmark.terraiot.ui.humidity;

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
import com.aliniacoban.fishingindenmark.databinding.FragmentHumidityBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class HumidityFragment extends Fragment {

    private HumidityViewModel humidityViewModel;
    private FragmentHumidityBinding binding;
    private LineChart mChart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        humidityViewModel =
                new ViewModelProvider(this).get(HumidityViewModel.class);

        binding = FragmentHumidityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHumidity;
        humidityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        mChart=root.findViewById(R.id.humidity_chart);

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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}