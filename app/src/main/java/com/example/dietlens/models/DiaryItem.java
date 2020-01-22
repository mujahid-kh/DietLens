package com.example.dietlens.models;

public class DiaryItem {
    String name;
    String desc;
    String calories;

    public DiaryItem(String name, String desc, String calories) {
        this.name = name;
        this.desc = desc;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
