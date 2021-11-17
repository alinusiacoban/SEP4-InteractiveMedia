package com.aliniacoban.fishingindenmark.terraiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.terraiot.ui.co2.CO2Fragment;
import com.aliniacoban.fishingindenmark.terraiot.ui.home.HomeFragment;
import com.aliniacoban.fishingindenmark.terraiot.ui.humidity.HumidityFragment;
import com.aliniacoban.fishingindenmark.terraiot.ui.options.OptionsFragment;
import com.aliniacoban.fishingindenmark.terraiot.ui.temperature.TemperatureFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavView);
        btnNav.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();

    }


    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch(item.getItemId()){
                case R.id.item1:
                    selectedFragment=new HomeFragment();
                    break;

                case R.id.item2:
                    selectedFragment = new TemperatureFragment();
                    break;

                case R.id.item3:
                    selectedFragment = new HumidityFragment();
                    break;

                case R.id.item4:
                    selectedFragment = new CO2Fragment();
                    break;

                case R.id.item5:
                    selectedFragment = new OptionsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();

            return true;

        }

    };
}