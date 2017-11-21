package com.leafpile.leafpile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leafpile.leafpile.R;

import butterknife.ButterKnife;

public class BecomeSellerActivity extends AppCompatActivity {

    private static final String TAG = "Jadi Pedagang Leaf Pile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_seller);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
