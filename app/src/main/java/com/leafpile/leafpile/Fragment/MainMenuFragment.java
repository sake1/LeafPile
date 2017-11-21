package com.leafpile.leafpile.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.leafpile.leafpile.Activity.HomeActivity;
import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.ArrayAdapter.ProductArrayAdapter;
import com.leafpile.leafpile.Utils.HardcodedVariable;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuFragment extends Fragment {

    public static final String TAG = "Beranda";

    @BindView(R.id.fmm_input_search) EditText searchBox;
    @BindView(R.id.fmm_output_listview) ListView productList;
    @BindView(R.id.fmm_static_error_message) TextView message;

    private ArrayList<Product> productData;

    public MainMenuFragment() {
        // Required empty public constructor
        productData = new ArrayList<>();
    }


    @OnClick(R.id.fmm_trigger_fruit)
    public void fruit() {
        Bundle bundle = new Bundle();
        bundle.putString("title", HardcodedVariable.FRUIT_TITLE);
        QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
        queriedSearchFragment.setArguments(bundle);
        ((HomeActivity) getActivity()).changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
    }

    @OnClick(R.id.fmm_trigger_vegetable)
    public void vegetable() {
        Bundle bundle = new Bundle();
        bundle.putString("title", HardcodedVariable.VEGETABLE_TITLE);
        QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
        queriedSearchFragment.setArguments(bundle);
        ((HomeActivity) getActivity()).changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
    }

    @OnClick(R.id.fmm_trigger_rice)
    public void rice() {
        Bundle bundle = new Bundle();
        bundle.putString("title", HardcodedVariable.RICE_TITLE);
        QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
        queriedSearchFragment.setArguments(bundle);
        ((HomeActivity) getActivity()).changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
    }

    @OnClick(R.id.fmm_trigger_seasoning)
    public void seasoning() {
        Bundle bundle = new Bundle();
        bundle.putString("title", HardcodedVariable.SEASONING_TITLE);
        QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
        queriedSearchFragment.setArguments(bundle);
        ((HomeActivity) getActivity()).changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
    }

    @OnClick(R.id.fmm_trigger_meat)
    public void meat() {
        Bundle bundle = new Bundle();
        bundle.putString("title", HardcodedVariable.MEAT_TITLE);
        QueriedSearchFragment queriedSearchFragment = new QueriedSearchFragment();
        queriedSearchFragment.setArguments(bundle);
        ((HomeActivity) getActivity()).changeHomeActivityDisplayedFragment(queriedSearchFragment, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(TAG);

        displayListViewContent();

        return view;
    }

    private void getPickupRequestData() {
        productData.add(new Product(1, "Kangkung Hijau", "Toko Ibu Susi", 2000));
        productData.add(new Product(1, "Wortel", "Toko Ibu Susi", 10000));
        productData.add(new Product(1, "Beras Setra Ramos", "Toko Ibu Susi", 60000));
        productData.add(new Product(1, "Telur Ayam", "Toko Ibu Nina", 14000));
        productData.add(new Product(1, "Pisang Raja", "Toko Ibu Nina", 10000));
        productData.add(new Product(1, "Tomat", "Toko Ibu Nina", 6000));
    }

    private void displayListViewContent() {
        productData.clear();
        getPickupRequestData();
        if(productData.size() == 0) {
            message.setVisibility(View.VISIBLE);
            return;
        }

        ArrayAdapter adapter = new ProductArrayAdapter(getActivity(), productData);
        productList.setAdapter(adapter);
        productList.setFooterDividersEnabled(true);
        productList.setDividerHeight(1);
    }
}
