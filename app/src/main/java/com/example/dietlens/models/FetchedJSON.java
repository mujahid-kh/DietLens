
package com.example.dietlens.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FetchedJSON {

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
