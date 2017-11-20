package com.leafpile.leafpile.ArrayAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leafpile.leafpile.Activity.ProductDetailActivity;
import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.Model.Transaction;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.Utils.StringFormat;

import java.util.ArrayList;

    /**
     * Created by sake on 19/11/17.
     */

public class TransactionHistoryArrayAdapter extends ArrayAdapter<Transaction> {

    private ArrayList<Transaction> data;
    private int lastPosition = -1;
    private class ViewHolder {
        TextView name;
        TextView seller;
        TextView qty;
        TextView price;
        TextView total;
        TextView date;
        ImageView image;
    }

    public TransactionHistoryArrayAdapter(Context context, ArrayList<Transaction> data) {
        super(context, R.layout.listview_transaction_history, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Transaction data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final View result;
        ViewHolder viewHolder = new ViewHolder();
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.listview_transaction_history, parent, false);
        viewHolder.name = (TextView) convertView.findViewById(R.id.lth_output_product_name);
        viewHolder.seller = (TextView) convertView.findViewById(R.id.lth_output_product_seller);
        viewHolder.qty = (TextView) convertView.findViewById(R.id.lth_output_product_qty);
        viewHolder.price = (TextView) convertView.findViewById(R.id.lth_output_product_price);
        viewHolder.total = (TextView) convertView.findViewById(R.id.lth_output_product_price_total);
        viewHolder.date = (TextView) convertView.findViewById(R.id.lth_output_purchase_date);
        viewHolder.image = (ImageView) convertView.findViewById(R.id.lth_output_image);

        result = convertView;
        convertView.setTag(viewHolder);

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.fadein : R.anim.fadeout);
        result.startAnimation(animation);
        lastPosition = position;

        assert data != null;
        viewHolder.name.setText(data.getProductName());
        viewHolder.seller.setText(data.getSellerName());
        viewHolder.qty.setText(StringFormat.qty(data.getQty()));
        viewHolder.price.setText(StringFormat.price((int) data.getPrice()));
        viewHolder.total.setText(StringFormat.price((int) data.getTotalPrice()));
        viewHolder.date.setText(StringFormat.transactionDate(data.getTransactionDate()));

//        convertView.findViewById(R.id.lp_root).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("data", data);
//                Intent intent = new Intent(getContext(), ProductDetailActivity.class);
//                intent.putExtras(bundle);
//                getContext().startActivity(intent);
//            }
//        });
        // Return the completed view to render on screen
        return convertView;
    }
}
