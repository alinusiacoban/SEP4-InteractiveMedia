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

import com.aliniacoban.fishingindenmark.databinding.CO2FragmentBinding;

public class CO2Fragment extends Fragment {

    private CO2ViewModel co2ViewModel;
    private CO2FragmentBinding binding;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        co2ViewModel =
                new ViewModelProvider(this).get(CO2ViewModel.class);

        binding = CO2FragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCo2;
        co2ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}