package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aliniacoban.fishingindenmark.R;

import java.util.ArrayList;
import java.util.List;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;

public class ViewAllTerrarium extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_terrarium);
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        List<Terrarium> terrariumList = new ArrayList<>();
        terrariumList.add(new Terrarium("MyDragon'sHome"));
        terrariumList.add(new Terrarium("Stupid Snake"));
        terrariumList.add(new Terrarium("Flying Lizard"));
        terrariumList.add(new Terrarium("Running turtle"));


        ViewTerrariumAdapter adapter = new ViewTerrariumAdapter(terrariumList);
        recyclerView.setAdapter(adapter);

    }
}