package com.aliniacoban.fishingindenmark.terraiot.ui.createterrarium;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.adapter.SpinnerWithHintAdapter;

import java.util.concurrent.ExecutionException;

public class CreateTerrarium extends Fragment implements AdapterView.OnItemSelectedListener {

    private CreateTerrariumViewModel createTerrariumViewModel;
    private SpinnerWithHintAdapter spinnerWithHintAdapter;
    private Button createTerrarium;
    private EditText terrariumName;
    private EditText reptileType;
    private Button goBack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createTerrariumViewModel = new ViewModelProvider(this).get(CreateTerrariumViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.create_terrarium_fragment,
                container, false);
        Button createTerrarium = view.findViewById(R.id.createNewTerrarium);
        EditText terrariumName = view.findViewById(R.id.terrariumNameCreateTerrarium);
        Spinner reptileType = view.findViewById(R.id.terrariumReptileCreateTerrarium);
        spinnerWithHintAdapter = new SpinnerWithHintAdapter(getContext(), R.layout.spinner_item);
        spinnerWithHintAdapter.add("Reptile");
        spinnerWithHintAdapter.add("Crocodile");
        spinnerWithHintAdapter.add("Lizard");
        spinnerWithHintAdapter.add("Snake");
        spinnerWithHintAdapter.add("Turtle");
        spinnerWithHintAdapter.setDropDownViewResource(R.layout.spinner_item);
        reptileType.setAdapter(spinnerWithHintAdapter);
        reptileType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position == 0)
                    return;
                Toast.makeText(getContext(), "Your selected reptile is "
                        + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        createTerrarium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String terrarium_name = " ";
                String reptile_type = " ";

                terrarium_name = terrariumName.getText().toString();
                reptile_type = reptileType.getSelectedItem().toString();

                try{
                    createTerrariumViewModel.insertTerrarium(new Terrarium(
                            terrarium_name,
                            reptile_type
                    ));
                    Toast.makeText(getContext(), "Terrarium created", Toast.LENGTH_SHORT).show();
                    terrariumName.setText("");
                    reptileType.setSelection(0);

                }catch(ExecutionException | InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        goBack = view.findViewById(R.id.goBackFromCreateTerr);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.navigation_menu);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String text = parent.getItemAtPosition(position).toString();
            if(position>0)
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
