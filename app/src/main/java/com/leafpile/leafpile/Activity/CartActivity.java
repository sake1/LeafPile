package com.leafpile.leafpile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.ArrayAdapter.CartArrayAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity {

    private static final String TAG = "Keranjang Belanja";

    @BindView(R.id.ac_list_po) ListView transactionList;
    @BindView(R.id.ac_loading) ProgressBar loading;
    @BindView(R.id.ac_static_error_message) TextView message;

    private ArrayList<Product> poList;

    public CartActivity() {
        poList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        displayListViewContent();
    }

    private void getPickupRequestData() {
        poList.add(new Product(1, "Kangkung Hijau", "Toko Ibu Susi", 2000));
        poList.add(new Product(1, "Wortel", "Toko Ibu Susi", 10000));
        poList.add(new Product(1, "Beras Setra Ramos", "Toko Ibu Susi", 60000));
        poList.add(new Product(1, "Telur Ayam", "Toko Ibu Nina", 14000));
        poList.add(new Product(1, "Pisang Raja", "Toko Ibu Nina", 10000));
        poList.add(new Product(1, "Tomat", "Toko Ibu Nina", 6000));
    }

    private void displayListViewContent() {
        poList.clear();
        getPickupRequestData();
        loading.setVisibility(View.GONE);
        if(poList.size() == 0) {
            message.setVisibility(View.VISIBLE);
            return;
        }

        ArrayAdapter adapter = new CartArrayAdapter(this, poList);
        transactionList.setVisibility(View.VISIBLE);
        transactionList.setAdapter(adapter);
        transactionList.setFooterDividersEnabled(true);
        transactionList.setDividerHeight(1);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
