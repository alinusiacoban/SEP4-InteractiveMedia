package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.databinding.MenuFragmentBinding;
import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.firebaseAuth.LoginActivity;
import com.aliniacoban.fishingindenmark.terraiot.ui.createterrarium.CreateTerrariumViewModel;
import com.aliniacoban.fishingindenmark.terraiot.ui.profile.UserInformation;
import com.aliniacoban.fishingindenmark.terraiot.ui.terrariums.ViewTerrariums;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class MenuFragment extends Fragment {
        private CreateTerrariumViewModel createTerrariumViewModel;
        private MenuViewModel menuViewModel;
        private @NonNull
        MenuFragmentBinding binding;
        CardView profileInformation;
        CardView logOutUser;
        CardView resetPassword;
        CardView addTerrarium;
        CardView terrariumList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);
        createTerrariumViewModel = new ViewModelProvider(this).get(CreateTerrariumViewModel.class);
        binding = MenuFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMenu;

        menuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        profileInformation = root.findViewById(R.id.displayUserInfo);
        logOutUser = root.findViewById(R.id.signOutUser);
        resetPassword = root.findViewById(R.id.resetPasswordProfile);
        addTerrarium = root.findViewById(R.id.addTerrariumToList);

        addTerrarium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_terrarium, null);
                Button createTerrarium = view.findViewById(R.id.createNewTerrarium);
                EditText terrariumName = view.findViewById(R.id.terrariumNameCreateTerrarium);
                EditText reptileType = view.findViewById(R.id.terrariumReptileCreateTerrarium);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();

                createTerrarium.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String terrarium_name = " ";
                        String reptile_type = " ";

                        terrarium_name = terrariumName.getText().toString();
                        reptile_type = reptileType.getText().toString();

                        try{
                            createTerrariumViewModel.insertTerrarium(new Terrarium(
                                    terrarium_name,
                                    reptile_type
                            ));Toast.makeText(getContext(), "Terrarium created", Toast.LENGTH_SHORT).show();
                        }catch(ExecutionException | InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

        profileInformation.setOnClickListener(new View.OnClickListener(){
                        @Override
                public void onClick(View v){
                            Intent intent = new Intent(getActivity(), UserInformation.class);
                            startActivity(intent);
        }
                }
        );


        logOutUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }


        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_update_password, null);
                EditText currentPassword = view.findViewById(R.id.currentPassword);
                EditText confirmNewPassword = view.findViewById(R.id.newPassword);
                Button updatePasswordButton = view.findViewById(R.id.confrimNewPassword);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(view);

                AlertDialog dialog = builder.create();
                dialog.show();

                updatePasswordButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String oldPassword = currentPassword.getText().toString().trim();
                        String newPassword = confirmNewPassword.getText().toString().trim();

                        if(TextUtils.isEmpty(oldPassword)){
                            Toast.makeText(getActivity(), "Enter your current password...", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(newPassword.length()<6){
                            Toast.makeText(getActivity(), "Password length must be at least 6 characters", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        updatePassword(oldPassword, newPassword);
                    }
                });
            }
            private void updatePassword(String oldPassword, String newPassword)
            {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldPassword);
                user.reauthenticate(authCredential).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {Toast.makeText(getActivity(), "Password updated", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Failed to update password", Toast.LENGTH_SHORT).show();
                        }
                    });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Failed to update password", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        terrariumList = root.findViewById(R.id.terrariumsList);
        terrariumList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewTerrariums fragment = new ViewTerrariums();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}