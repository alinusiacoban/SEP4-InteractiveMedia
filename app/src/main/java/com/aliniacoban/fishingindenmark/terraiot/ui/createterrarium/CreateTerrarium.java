package com.aliniacoban.fishingindenmark.terraiot.ui.createterrarium;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliniacoban.fishingindenmark.R;

public class CreateTerrarium extends Fragment {

    private CreateTerrariumViewModel mViewModel;

    public static CreateTerrarium newInstance() {
        return new CreateTerrarium();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_terrarium_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateTerrariumViewModel.class);
        // TODO: Use the ViewModel
    }

}