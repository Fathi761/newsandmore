package com.programmer.newsandmore;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.preference.PreferenceManager;

import com.google.android.material.navigation.NavigationView;
import com.programmer.newsandmore.Fragment.AboutUsFragment;
import com.programmer.newsandmore.Fragment.EmailFragment;
import com.programmer.newsandmore.Fragment.RatingFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.Egypt.EgyptFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.SaudiArabia.SaudiArabiaFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UAE.UaeFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.USA.UsaFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.UnitedKingdom.UnitedKingdomFragment;
import com.programmer.newsandmore.Fragment.WorldFragment.WorldFragment;
import com.programmer.newsandmore.Settings.Settings;




public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private LinearLayout linearLayout;
    private FrameLayout frameLayout;
    private long backPressedTime;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);
        linearLayout = findViewById(R.id.linear_layout);
        frameLayout = findViewById(R.id.fragment_container);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //When the app it start this will be display on the home activity.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WorldFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_usa);

            Load_setting();
        }
    }

    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean chk_night = sp.getBoolean("NIGHT", false);
        if (chk_night) {
            drawer.setBackgroundColor(Color.parseColor("#333333"));
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            drawer.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.setBackgroundColor(Color.parseColor("#333333"));
        }

        String orien = sp.getString("ORIENTATION", "false");
        if ("1".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        }
        else if ("2".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        else if ("3".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_usa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsaFragment()).commit();
                break;
            case R.id.nav_uae:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UaeFragment()).commit();
                break;
            case R.id.nav_saudiarabia:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SaudiArabiaFragment()).commit();
                break;
            case R.id.nav_egypt:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EgyptFragment()).commit();
                break;
            case R.id.nav_unitedKingdom:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UnitedKingdomFragment()).commit();
                break;
            case R.id.nav_aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUsFragment()).commit();
                break;
            case R.id.nav_email:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EmailFragment()).commit();
                break;
//            case R.id.nav_rating:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new RatingFragment()).commit();


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onResume() {
        Load_setting();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//
//            androidx.appcompat.widget.SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//            searchView.setIconifiedByDefault(false);
//        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                Toast.makeText(this, "You are logged out.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                startActivity(new Intent(HomeActivity.this, Settings.class));
                Toast.makeText(this, "You are in the setting page.", Toast.LENGTH_SHORT).show();
//            case R.id.search:
//                onSearchRequested();
//                return true;
//            default:
//                return false;


        }
        return true;
    }




}
