package com.aliniacoban.fishingindenmark.terraiot.ui.co2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CO2ViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CO2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is CO2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}