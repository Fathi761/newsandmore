package com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Health;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Business.BusinessFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Entertainment.EntertainmentFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Sport.SportFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Technology.TechnologyFragment;
import com.programmer.newsandmore.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HealthFragment extends Fragment {

    private RecyclerView recyclerView;
    private HealthAdapter healthAdapter;
    private ArrayList<HealthItem> healthList;
    private RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_health,container,false);


        recyclerView = v.findViewById(R.id.recycler_view_health);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(healthAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        healthList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(getActivity());


        parseJSON();

        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottom_navigation_health);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        return v;
    }
    private void parseJSON(){
        String url = "http://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=9a42cbcc9019420db86abdf70fc5454f";

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

                                healthList.add(new HealthItem(imageUrl, title, desc, url, published));
                            }

                            healthAdapter = new HealthAdapter(getActivity(), healthList);
                            healthAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(healthAdapter);
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
}