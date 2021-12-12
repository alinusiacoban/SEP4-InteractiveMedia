package com.aliniacoban.fishingindenmark.terraiot.ui.terrariums;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.repository.TerrariumRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewTerrariumsViewModel extends AndroidViewModel {
    private final TerrariumRepository terrariumRepository;

    public ViewTerrariumsViewModel(Application application) {
        super(application);
        terrariumRepository = TerrariumRepository.getInstance(application);
    }

    public LiveData<List<Terrarium>> getTerrariums() throws ExecutionException, InterruptedException {
        return terrariumRepository.getTerrariums();
    }

    public void removeTerrarium(int pos) throws ExecutionException, InterruptedException {
        terrariumRepository.removeTerrarium(pos);
    }
}