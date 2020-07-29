package com.programmer.newsandmore.Fragment.WorldFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Business.BusinessFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Entertainment.EntertainmentFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Health.HealthFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Sport.SportFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.BottomNavigation.Technology.TechnologyFragment;

import com.programmer.newsandmore.Fragment.WorldFragment.USA.UsaFragment;
import com.programmer.newsandmore.R;

public class WorldFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_world, container, false);


        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new UsaFragment()).commit();

        return v;
    }
}
