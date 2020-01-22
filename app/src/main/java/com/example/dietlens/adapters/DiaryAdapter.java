package com.example.dietlens.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietlens.R;
import com.example.dietlens.models.DiaryItem;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {
    Context context;
    List<DiaryItem> diaryItemList;

    public DiaryAdapter(Context context, List<DiaryItem> diaryItemList) {
        this.context = context;
        this.diaryItemList = diaryItemList;
    }

    @NonNull
    @Override
    public DiaryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diary_food_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.MyViewHolder holder, int position) {
        DiaryItem diaryItem = diaryItemList.get(position);
        holder.foodName.setText(diaryItem.getName());
        holder.foodDesc.setText(diaryItem.getDesc());
        holder.calorieAmount.setText(diaryItem.getCalories());
    }

    @Override
    public int getItemCount() {
        return diaryItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, foodDesc,calorieAmount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName=itemView.findViewById(R.id.food_name);
            foodDesc=itemView.findViewById(R.id.food_desc);
            calorieAmount=itemView.findViewById(R.id.calorie_amount);
        }
    }
}
