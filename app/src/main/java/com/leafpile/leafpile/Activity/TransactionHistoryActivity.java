package com.leafpile.leafpile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leafpile.leafpile.Model.Transaction;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.ArrayAdapter.TransactionHistoryArrayAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionHistoryActivity extends AppCompatActivity {

    private static final String TAG = "Riwayat Trnasaksi";

    @BindView(R.id.ath_list_transaction) ListView transactionList;
    @BindView(R.id.ath_loading) ProgressBar loading;
    @BindView(R.id.ath_static_error_message) TextView message;

    private ArrayList<Transaction> transactionData;

    public TransactionHistoryActivity() {
        transactionData = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        displayListViewContent();
    }

    private void displayListViewContent() {
        transactionData.clear();
        loading.setVisibility(View.GONE);
        if(transactionData.size() == 0) {
            message.setVisibility(View.VISIBLE);
            return;
        }

        ArrayAdapter adapter = new TransactionHistoryArrayAdapter(this, transactionData);
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
