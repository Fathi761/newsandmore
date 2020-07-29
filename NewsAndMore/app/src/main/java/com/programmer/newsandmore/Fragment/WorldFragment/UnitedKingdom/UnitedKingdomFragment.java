package com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Business.BusinessFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Entertainment.EntertainmentFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Health.HealthFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Sport.SportFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.BottomNavigation.Technology.TechnologyFragment;
import com.programmer.newsandmore.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UnitedKingdomFragment extends Fragment {



    private RecyclerView recyclerView;
    private UnitedKingdomAdapter unitedKingdomAdapter;
    private ArrayList<UnitedkingdomItem> unitedKingdomList;
    private RequestQueue requestQueue;


    BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_unitedkingdoms,container,false);

        recyclerView = v.findViewById(R.id.recycler_view_unitedkingdoms);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(unitedKingdomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        unitedKingdomList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Load_setting();

        return v;
    }

    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

        boolean chk_night = sp.getBoolean("NIGHT", false);
        if (chk_night) {
            recyclerView.setBackgroundColor(Color.parseColor("#222222"));


        } else {
            recyclerView.setBackgroundColor(Color.parseColor("#ffffff"));

        }
    }

    private void parseJSON(){
        String url = "http://newsapi.org/v2/top-headlines?country=gb&apiKey=25f1410d0d3248449e60770decf5ee9f";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject article = jsonArray.getJSONObject(i);

                                String title = article.getString("title");
                                String imageUrl = article.getString("urlToImage");
                                String desc = article.getString("description");
                                String url = article.getString("url");
                                String published = article.getString("publishedAt");

                                unitedKingdomList.add(new UnitedkingdomItem(imageUrl, title, desc, url, published));
                            }

                            unitedKingdomAdapter = new UnitedKingdomAdapter(getActivity(), unitedKingdomList);
                            unitedKingdomAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(unitedKingdomAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_business:
                            selectedFragment = new BusinessFragment();
                            break;
                        case R.id.nav_entertainment:
                            selectedFragment = new EntertainmentFragment();
                            break;
                        case R.id.nav_sports:
                            selectedFragment = new SportFragment();
                            break;
                        case R.id.nav_technology:
                            selectedFragment = new TechnologyFragment();
                            break;
                        case R.id.nav_health:
                            selectedFragment = new HealthFragment();
                            break;
                    }
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public void onResume() {
        Load_setting();
        super.onResume();
    }


}
