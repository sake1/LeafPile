package com.leafpile.leafpile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leafpile.leafpile.R;

import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "Profil Saya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
