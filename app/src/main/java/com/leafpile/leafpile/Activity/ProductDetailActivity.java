package com.leafpile.leafpile.Activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.Utils.StringFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends AppCompatActivity {

    private static final String TAG = "Detail Produk";

    @BindView(R.id.pda_output_name) TextView productName;
    @BindView(R.id.pda_output_seller) TextView sellerName;
    @BindView(R.id.pda_output_price) TextView productPrice;

    @OnClick(R.id.pda_order_button)
    public void orderProduct() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_order_qty);
        dialog.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        dialog.findViewById(R.id.oqd_input_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ProductDetailActivity.this.finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dispay((Product) getIntent().getParcelableExtra("data"));
    }

    private void dispay(Product data) {
        productName.setText(data.getProductName());
        sellerName.setText(data.getSellerName());
        productPrice.setText(StringFormat.price(data.getProductPrice()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
