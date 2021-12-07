package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

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

import com.aliniacoban.fishingindenmark.databinding.MenuFragmentBinding;

public class MenuFragment extends Fragment {

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
            return root;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
    }