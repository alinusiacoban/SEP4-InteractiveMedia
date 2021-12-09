package com.aliniacoban.fishingindenmark.terraiot.ui.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliniacoban.fishingindenmark.R;

import java.util.List;

import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;

public class ViewTerrariumAdapter extends RecyclerView.Adapter<ViewTerrariumAdapter.ViewHolder> {

    List<Terrarium> myTerrariumList;

    public ViewTerrariumAdapter(List<Terrarium> myTerrariumList) {
        this.myTerrariumList = myTerrariumList;
    }

    @NonNull
    @Override
    public ViewTerrariumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.terrarium_list
                ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTerrariumAdapter.ViewHolder holder, int position) {
        holder.terra_name.setText(myTerrariumList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return myTerrariumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView terra_name;
            public TextView getTerra_name() {
                return terra_name ;
            }


        public ViewHolder(@NonNull View view) {
                super(view);
                terra_name = view.findViewById(R.id.title);

        }
    }
}
