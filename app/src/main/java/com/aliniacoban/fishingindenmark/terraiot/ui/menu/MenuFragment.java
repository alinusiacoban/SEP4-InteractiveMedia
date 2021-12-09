package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

import android.content.Intent;
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

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.databinding.MenuFragmentBinding;

public class MenuFragment extends Fragment {
        private TextView t1,t2;
        private MenuViewModel menuViewModel;
        private @NonNull MenuFragmentBinding binding;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            menuViewModel =
                    new ViewModelProvider(this).get(MenuViewModel.class);

            binding = MenuFragmentBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            final TextView textView = binding.textMenu;
            menuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
            t2=root.findViewById(R.id.viewTerrarium);
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(getActivity(), ViewAllTerrarium.class);
                    startActivity(intent);
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