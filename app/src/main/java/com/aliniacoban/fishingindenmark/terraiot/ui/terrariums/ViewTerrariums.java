package com.aliniacoban.fishingindenmark.terraiot.ui.terrariums;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.terraiot.adapter.TerrariumAdapter;

import java.util.concurrent.ExecutionException;

public class ViewTerrariums extends Fragment {

    private ViewTerrariumsViewModel viewTerrariumsViewModel;

    private RecyclerView recyclerView;
    private TerrariumAdapter terrariumAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       viewTerrariumsViewModel = new ViewModelProvider(this).get(ViewTerrariumsViewModel.class);
        try {
            viewTerrariumsViewModel.getTerrariums().observe(this, terrariums -> {

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                terrariumAdapter = new TerrariumAdapter(terrariums);
                recyclerView.setAdapter(terrariumAdapter);

                terrariumAdapter.setOnClickListener(position ->
                {
                    viewTerrariumsViewModel.removeTerrarium(position);
                    Toast.makeText(getContext(), "Terrarium removed", Toast.LENGTH_SHORT).show();
                    terrariumAdapter.notifyDataSetChanged();
                });

            });
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_terrariums_fragment, container, false);

        recyclerView = view.findViewById(R.id.rvTerrarium);

        return view;
    }

}