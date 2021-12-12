package com.aliniacoban.fishingindenmark.terraiot.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TerrariumAdapter extends RecyclerView.Adapter<TerrariumAdapter.ViewHolder> {

    private List<Terrarium> terrariums;
    private TerrariumAdapter.OnItemClickListener listener;

    @NonNull
    @Override
    public TerrariumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycleview_view_terrariums, parent, false);
        return new TerrariumAdapter.ViewHolder(view, listener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (terrariums != null && position <= terrariums.size()) {
            holder.terrariumName.setText(terrariums.get(position).getTerrariumName() + " ");
            holder.reptileType.setText(terrariums.get(position).getReptileLivingInTerrarium() + " ");
            switch (terrariums.get(position).getReptileLivingInTerrarium()) {
                case "Crocodile":
                    holder.imageReptile.setBackgroundResource(R.drawable.crocodile);
                    break;
                case "Lizard":
                    holder.imageReptile.setBackgroundResource(R.drawable.lizard);
                    break;
                case "Snake":
                    holder.imageReptile.setBackgroundResource(R.drawable.snake);
                    break;
                case "Turtle":
                    holder.imageReptile.setBackgroundResource(R.drawable.turtle);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (terrariums == null) {
            terrariums = new ArrayList<>();
            return 0;
        }
        return terrariums.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView terrariumName;
        private final TextView reptileType;
        private final ImageView imageReptile;

        ViewHolder(@NonNull View itemView, TerrariumAdapter.OnItemClickListener listener) {
            super(itemView);
            terrariumName = itemView.findViewById(R.id.terrariumNameForTerrariumList);
            reptileType = itemView.findViewById(R.id.reptileTypeForTerrariumList);
            imageReptile = itemView.findViewById(R.id.imageForTerrariumList);
        }

    }

    public interface OnItemClickListener {
        void onRemoveClickListener(int position) throws ExecutionException, InterruptedException;
    }

    public void setOnClickListener(TerrariumAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public TerrariumAdapter(List<Terrarium> terrariums) {
        this.terrariums = new ArrayList<>();
        this.terrariums = terrariums;
    }
}

