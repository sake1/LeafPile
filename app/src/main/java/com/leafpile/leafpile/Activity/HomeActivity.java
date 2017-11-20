package com.leafpile.leafpile.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorTreeAdapter;

import com.leafpile.leafpile.Fragment.MainMenuFragment;
import com.leafpile.leafpile.Fragment.QueriedSearchFragment;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.Utils.HardcodedVariable;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changeHomeActivityDisplayedFragment(new MainMenuFragment(), false);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main_menu) {
            changeHomeActivityDisplayedFragment(new MainMenuFragment(), true);
        } else if (id == R.id.nav_fruit) {
            Bundle bundle = new Bundle();
            bundle.putString("title", HardcodedVariable.FRUIT_TITLE);
            QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
            queriedSearchFragment.setArguments(bundle);
            changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
        } else if (id == R.id.nav_vegetable) {
            Bundle bundle = new Bundle();
            bundle.putString("title", HardcodedVariable.VEGETABLE_TITLE);
            QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
            queriedSearchFragment.setArguments(bundle);
            changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
        } else if (id == R.id.nav_rice) {
            Bundle bundle = new Bundle();
            bundle.putString("title", HardcodedVariable.RICE_TITLE);
            QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
            queriedSearchFragment.setArguments(bundle);
            changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
        } else if (id == R.id.nav_seasoning) {
            Bundle bundle = new Bundle();
            bundle.putString("title", HardcodedVariable.SEASONING_TITLE);
            QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
            queriedSearchFragment.setArguments(bundle);
            changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
        } else if (id == R.id.nav_meat) {
            Bundle bundle = new Bundle();
            bundle.putString("title", HardcodedVariable.MEAT_TITLE);
            QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
            queriedSearchFragment.setArguments(bundle);
            changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
        } else if (id == R.id.nav_manual) {
        } else if (id == R.id.nav_my_product) {
        } else if (id == R.id.nav_po) {
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_cart) {
            startActivity(new Intent(HomeActivity.this, CartActivity.class));
        } else if (id == R.id.nav_history) {
            startActivity(new Intent(HomeActivity.this, TransactionHistoryActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeHomeActivityDisplayedFragment(Fragment intendedFragment, boolean isAddedToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
        fragmentTransaction.replace(R.id.h_fragment_frame, intendedFragment);
        if(isAddedToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public HomeActivity popBackStack() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStackImmediate();

        return this;
    }
}
