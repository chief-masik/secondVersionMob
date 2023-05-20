package com.example.secondversion5pr.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondversion5pr.R;
import com.example.secondversion5pr.data.model.River;

import java.util.ArrayList;
import java.util.List;

public class RiverAdapter extends RecyclerView.Adapter<RiverAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<River> rivers;
    private RiverAdapter.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(River river, int position, View view);
    }
    public RiverAdapter(Context context, RiverAdapter.OnItemClickListener listener) {

        this.rivers = new ArrayList<>();
        this.listener = listener;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_items, parent, false);
        return new RiverAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RiverAdapter.ViewHolder holder, int position) {

        River river = rivers.get(position);
        holder.imageView.setImageResource(river.getImage());
        holder.nameView.setText(river.getNameItem());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onItemClick(river, holder.getAdapterPosition(), view);
            }
        });
    }
    @Override
    public int getItemCount() {
        return rivers.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateRivers(List<River> rivers) {
        this.rivers.clear();
        this.rivers = rivers;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView;
        public ViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView6);
            nameView = view.findViewById(R.id.textView2);
        }
    }

}

