package com.example.dietlens;

import android.content.res.Resources;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeFetcher {
    public static RequestQueue queue;
    public static String apiUrl = "https://api.spoonacular.com/recipes/";
    public RecipeFetcher(){
        queue = Volley.newRequestQueue(MainActivity.context);
    }
    public void fetchRandom(final VolleyCallback callback) {
        String newUrl = apiUrl + "random?number=10&apiKey=" + Resources.getSystem().getString(R.string.spoonacular_APIKey);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, newUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccessResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(MainActivity.context, error.getMessage(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    public void fetchByNutrients(int minCalories, int maxCalories, int minCarbs, int maxCarbs, int minFat, int maxFat, int minProtein, int maxProtein, final VolleyCallback callback){
        String newUrl = apiUrl + "findByNutrients?";
        newUrl = newUrl + "minCalories=" + minCalories + "&";
        newUrl = newUrl + "maxCalories=" + maxCalories + "&";
        newUrl = newUrl + "minCarbs=" + minCarbs + "&";
        newUrl = newUrl + "minCarbs=" + maxCarbs + "&";
        newUrl = newUrl + "minFat=" + minFat + "&";
        newUrl = newUrl + "maxFat=" + maxFat + "&";
        newUrl = newUrl + "minProtein=" + minProtein + "&";
        newUrl = newUrl + "maxProtein=" + maxProtein + "&";
        newUrl = newUrl + "number=1&";
        newUrl = newUrl + "apiKey=" + Resources.getSystem().getString(R.string.spoonacular_APIKey);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, newUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccessResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(MainActivity.context, error.getMessage(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    public void fetchByIngredients(ArrayList<String> ingredients, final VolleyCallback callback){
        String newUrl = apiUrl + "findByIngredients?ingredients=";
        for(String x : ingredients){
            newUrl = newUrl + x + ",";
        }
        newUrl = newUrl.substring(0, newUrl.length()-1) + "&";
        newUrl = newUrl + "ranking=1&";
        newUrl = newUrl + "number=1&";
        newUrl = newUrl + "ignorePantry=true&";
        newUrl = newUrl + "apiKey=" + Resources.getSystem().getString(R.string.spoonacular_APIKey);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, newUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccessResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(MainActivity.context, error.getMessage(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

        queue.add(jsonObjectRequest);
    }
}
