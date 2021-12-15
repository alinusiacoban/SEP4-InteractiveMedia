package com.aliniacoban.fishingindenmark.terraiot.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.databinding.FragmentHomeBinding;
import com.aliniacoban.fishingindenmark.terraiot.API.JsonPlaceHolderApi;
import com.aliniacoban.fishingindenmark.terraiot.API.Level;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    TextView co2text, humiditytext,temperaturetext;

        public View onCreateView (@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState){
            homeViewModel =
                    new ViewModelProvider(this).get(HomeViewModel.class);

            binding = FragmentHomeBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            final TextView textView = binding.textHome;
            homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
            co2text =  root.findViewById(R.id.co2Circle);
            humiditytext =  root.findViewById(R.id.humidityCircle);
            temperaturetext =  root.findViewById(R.id.temperatureCircle);
            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/812d24d5-b849-430a-b2da-fc897b1c63fb/%22/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
            Call<List<Level>> call= jsonPlaceHolderApi.getLevel();

            call.enqueue(new Callback<List<Level>>() {
                @Override
                public void onResponse(Call<List<Level>> call, Response<List<Level>> response) {
                    List<Level> levelList= response.body();
                    String co2=levelList.get(0).getCo2();
                    String humidity=levelList.get(0).getHumidity();
                    String temperature=levelList.get(0).getTemperature();

                    co2text.setText(co2);
                    humiditytext.setText(humidity);
                    temperaturetext.setText(temperature);
                    //setting text here
                }

                @Override
                public void onFailure(Call<List<Level>> call, Throwable t) {
                    Toast.makeText(getContext(), "Connection not established", Toast.LENGTH_LONG).show();
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
