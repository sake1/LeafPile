package com.leafpile.leafpile.ArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.leafpile.leafpile.Model.Product;
import com.leafpile.leafpile.R;
import com.leafpile.leafpile.Utils.StringFormat;

import java.util.ArrayList;

/**
 * Created by USER on 21/11/2017.
 */

public class CartArrayAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> data;
    private int lastPosition = -1;
    private class ViewHolder {
        TextView name;
        TextView seller;
        TextView price;
        TextView qty;
        Button minus;
        ImageView image;
    }

    public CartArrayAdapter(Context context, ArrayList<Product> data) {
        super(context, R.layout.listview_cart, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Product data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final View result;
        ViewHolder viewHolder = new ViewHolder();
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.listview_cart, parent, false);
        viewHolder.name = (TextView) convertView.findViewById(R.id.lc_output_product_name);
        viewHolder.seller = (TextView) convertView.findViewById(R.id.lc_output_product_seller);
        viewHolder.price = (TextView) convertView.findViewById(R.id.lc_output_product_price);
        viewHolder.qty = (TextView) convertView.findViewById(R.id.lc_output_product_qty);
        viewHolder.minus = (Button) convertView.findViewById(R.id.lc_input_remove);
        viewHolder.image = (ImageView) convertView.findViewById(R.id.lc_output_image);

        result = convertView;
        convertView.setTag(viewHolder);

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.fadein : R.anim.fadeout);
        result.startAnimation(animation);
        lastPosition = position;

        assert data != null;
        viewHolder.name.setText(data.getProductName());
        viewHolder.seller.setText(data.getSellerName());
        viewHolder.price.setText(StringFormat.price(data.getProductPrice()));
        viewHolder.qty.setText(StringFormat.qty(data.getQty()));
        viewHolder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartArrayAdapter.this.data.remove(position);
                notifyDataSetChanged();
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
