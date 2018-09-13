package com.navinnayak.android.tourguideapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.navinnayak.android.tourguideapp.common.TGABaseFragment;
import com.navinnayak.android.tourguideapp.fragments.Historical;
import com.navinnayak.android.tourguideapp.fragments.Home;
import com.navinnayak.android.tourguideapp.fragments.Malls;
import com.navinnayak.android.tourguideapp.fragments.Park;
import com.navinnayak.android.tourguideapp.fragments.Restaurant;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Home.OnFragmentInteractionListener,
        Historical.OnFragmentInteractionListener,
        Restaurant.OnFragmentInteractionListener,
        Park.OnFragmentInteractionListener,
        Malls.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Launch the home fragment
        TGABaseFragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = Home.class;
        try {
            fragment = (TGABaseFragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // Find our drawer view
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Instantiate the navigation view
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    // This method handles the behaviour of the back function according to the state of the navigation view
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        TGABaseFragment fragment = null;
        Class fragmentClass = null;
        switch (item.getItemId()) {

            case (R.id.nav_home):
                fragmentClass = Home.class;
                break;
            case (R.id.nav_historical):
                fragmentClass = Historical.class;
                break;
            case (R.id.nav_park):
                fragmentClass = Park.class;
                break;
            case (R.id.nav_malls):
                fragmentClass = Malls.class;
                break;
            case (R.id.nav_restaurants):
                fragmentClass = Restaurant.class;
                break;
        }
        try {
            fragment = (TGABaseFragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Implementation of the onFragmentInteraction methods for each fragment
    @Override
    public void onHomeInteraction(Uri uri) {
    }

    @Override
    public void onRestaurantInteraction(Uri uri) {
    }

    @Override
    public void onHistoricalInteraction(Uri uri) {
    }

    @Override
    public void onParkInteraction(Uri uri) {
    }

    @Override
    public void onMallsInteraction(Uri uri) {
    }
}