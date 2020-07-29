package com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia;

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
import com.programmer.newsandmore.Fragment.WorldFragment.Egypt.EgyptFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Business.BusinessFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Entertainment.EntertainmentFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Health.HealthFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Sport.SportFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.BottomNavigation.Technology.TechnologyFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.UnitedKingdomFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UAE.UaeAdapter;
import com.programmer.newsandmore.Fragment.WorldFragment.UAE.UaeItem;
import com.programmer.newsandmore.Fragment.WorldFragment.UAE.UaeFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.UsaFragment;
import com.programmer.newsandmore.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SaudiArabiaFragment extends Fragment {
    private RecyclerView recyclerView;
    private SaudiArabiaAdapter saudiAdapter;
    private ArrayList<SaudiItem> saudiList;
    private RequestQueue requestQueue;


    BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_saudiarabia,container,false);

        recyclerView = v.findViewById(R.id.recycler_view_saudi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(saudiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        saudiList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BusinessFragment()).commit();

        Load_setting();

        return v;
    }

    private void parseJSON(){
        String url = "http://newsapi.org/v2/top-headlines?country=sa&apiKey=25f1410d0d3248449e60770decf5ee9f";

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

                                saudiList.add(new SaudiItem(imageUrl, title, desc, url, published));
                            }

                            saudiAdapter = new SaudiArabiaAdapter(getActivity(), saudiList);
                            saudiAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(saudiAdapter);
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

    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

        boolean chk_night = sp.getBoolean("NIGHT", false);
        if (chk_night) {
            recyclerView.setBackgroundColor(Color.parseColor("#222222"));
        } else {
            recyclerView.setBackgroundColor(Color.parseColor("#ffffff"));

        }
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
