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
import com.example.secondversion5pr.data.model.Lake;

import java.util.ArrayList;
import java.util.List;

public class LakeAdapter extends RecyclerView.Adapter<LakeAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<Lake> lakes;
    private LakeAdapter.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(Lake lake, int position, View view);
    }
    public LakeAdapter(Context context, LakeAdapter.OnItemClickListener listener) {

        this.lakes = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_items, parent, false);
        return new LakeAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LakeAdapter.ViewHolder holder, int position) {

        Lake lake = lakes.get(position);
        holder.imageView.setImageResource(lake.getImage());
        holder.nameView.setText(lake.getNameItem());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onItemClick(lake, holder.getAdapterPosition(), view);
            }
        });
    }
    @Override
    public int getItemCount() {
        return lakes.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateLakes(List<Lake> lakes) {
        this.lakes.clear();
        this.lakes = lakes;
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