package com.leafpile.leafpile.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.ArrayAdapter.ProductArrayAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by USER on 05/11/2017.
 */

public class QueriedSearchFragment extends Fragment {

    @BindView(R.id.fqs_output_title) TextView title;
    @BindView(R.id.fqs_loading) ProgressBar loading;
    @BindView(R.id.fqs_output_listview) ListView listview;
    @BindView(R.id.fqs_static_error_message) TextView message;

    private ArrayList<Product> productData;

    public QueriedSearchFragment() {
        productData = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queried_search, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getArguments().getString("title"));
        title.setText(getArguments().getString("title"));

        displayListViewContent();
        return view;
    }

    private void displayListViewContent() {
        productData.clear();
        loading.setVisibility(View.GONE);
        if(productData.size() == 0) {
            message.setVisibility(View.VISIBLE);
            return;
        }

        ArrayAdapter adapter = new ProductArrayAdapter(getActivity(), productData);
        listview.setVisibility(View.VISIBLE);
        listview.setAdapter(adapter);
        listview.setFooterDividersEnabled(true);
        listview.setDividerHeight(1);
    }
}
