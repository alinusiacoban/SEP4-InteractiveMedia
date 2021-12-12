package com.aliniacoban.fishingindenmark.terraiot.ui.createterrarium;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.repository.TerrariumRepository;

import java.util.concurrent.ExecutionException;

public class CreateTerrariumViewModel extends AndroidViewModel {
   private final TerrariumRepository terrariumRepository;
   public CreateTerrariumViewModel(Application application){
       super(application);
       terrariumRepository = TerrariumRepository.getInstance(application);
   }
   public void insertTerrarium(Terrarium terrarium) throws ExecutionException, InterruptedException{
       terrariumRepository.insert(terrarium);
   }
}