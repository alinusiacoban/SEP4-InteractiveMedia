package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.aliniacoban.fishingindenmark.R;

public class CreateTerrarium extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_createnewterrarium);

    }

}
