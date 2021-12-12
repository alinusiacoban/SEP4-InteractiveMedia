package com.aliniacoban.fishingindenmark.terraiot.ui.temperature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.charts.LineChart;

public class TemperatureViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private LineChart co2Chart;

    public TemperatureViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Temperature fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}