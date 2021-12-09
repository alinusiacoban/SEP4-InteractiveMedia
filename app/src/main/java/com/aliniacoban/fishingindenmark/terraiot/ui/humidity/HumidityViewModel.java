package com.aliniacoban.fishingindenmark.terraiot.ui.humidity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.charts.LineChart;

public class HumidityViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private LineChart humidityChart;

    public HumidityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is humidity fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}