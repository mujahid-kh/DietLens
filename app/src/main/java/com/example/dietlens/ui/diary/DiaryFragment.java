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

    ImageButton addBreakfastBtn;
    RecyclerView recyclerViewBreakfast;
    DiaryAdapter breakfastAdapter;
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
        breakfastList.add(diaryItem);
        recyclerViewBreakfast = root.findViewById(R.id.recycler_view_breakfast);
        breakfastAdapter = new DiaryAdapter(getContext(),breakfastList);
        recyclerViewBreakfast.setAdapter(breakfastAdapter);

        addBreakfastBtn = root.findViewById(R.id.add_breakfast_btn);

        addBreakfastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaryItem diaryItem = new DiaryItem("Nutella","Ferrero, 1 serving (0.5 o.z.)","82");
                breakfastList.add(diaryItem);
                breakfastAdapter.notifyDataSetChanged();
            }
        });
        return root;
    }
}