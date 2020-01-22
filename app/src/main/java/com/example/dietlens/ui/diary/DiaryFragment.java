package com.example.dietlens.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietlens.R;
import com.example.dietlens.adapters.DiaryAdapter;
import com.example.dietlens.models.DiaryItem;

import java.util.ArrayList;
import java.util.List;

public class DiaryFragment extends Fragment {

    ImageButton addBreakfastBtn,addLunchBtn,addDinnerBtn;
    RecyclerView recyclerViewBreakfast,recyclerViewLunch,recyclerViewDinner;
    DiaryAdapter breakfastAdapter,lunchAdapter,dinnerAdapter;
    List<DiaryItem> lunchList = new ArrayList<>();
    List<DiaryItem> dinnerList = new ArrayList<>();
    List<DiaryItem> breakfastList = new ArrayList<>();
    private DiaryViewModel diaryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        diaryViewModel =
                ViewModelProviders.of(this).get(DiaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diary, container, false);
        diaryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        
        DiaryItem diaryItem = new DiaryItem("Nutella","Ferrero, 1 serving (0.5 o.z.)","82");
        //Hardcoding this item and adding it to the list for visualization testing only...
        breakfastList.add(diaryItem);
        lunchList.add(diaryItem);
        dinnerList.add(diaryItem);
        //RecyclerViews for different meal type
        recyclerViewBreakfast = root.findViewById(R.id.recycler_view_breakfast);
        recyclerViewLunch=root.findViewById(R.id.recycler_view_lunch);
        recyclerViewDinner=root.findViewById(R.id.recycler_view_dinner);
        //Adapters for every meal type
        breakfastAdapter = new DiaryAdapter(getContext(),breakfastList);
        lunchAdapter=new DiaryAdapter(getContext(),lunchList);
        dinnerAdapter= new DiaryAdapter(getContext(),dinnerList);

        //RecyclerViews for different meal types
        recyclerViewBreakfast.setAdapter(breakfastAdapter);
        recyclerViewLunch.setAdapter(lunchAdapter);
        recyclerViewDinner.setAdapter(dinnerAdapter);
        // initalization of add buttons
        addBreakfastBtn = root.findViewById(R.id.add_breakfast_btn);
        addLunchBtn=root.findViewById(R.id.add_lunch_btn);
        addDinnerBtn=root.findViewById(R.id.add_dinner_btn);

        // Click listeners for add button for different meal types.
        addBreakfastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaryItem diaryItem = new DiaryItem("Nutella","Ferrero, 1 serving (0.5 o.z.)","82");
                breakfastList.add(diaryItem);
                breakfastAdapter.notifyDataSetChanged();
            }
        });

        addLunchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaryItem lunchItem = new DiaryItem("Nutella","Ferrero, 1 serving (0.5 o.z.)","82");
                lunchList.add(lunchItem);
                lunchAdapter.notifyDataSetChanged();
            }
        });

        addDinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaryItem dinnerItem = new DiaryItem("Nutella","Ferrero, 1 serving (0.5 o.z.)","82");
                dinnerList.add(dinnerItem);
                dinnerAdapter.notifyDataSetChanged();
            }
        });
        return root;
    }
}