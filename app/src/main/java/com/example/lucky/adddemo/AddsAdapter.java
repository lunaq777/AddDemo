package com.example.lucky.adddemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lucky on 3/25/2017.
 */

public class AddsAdapter extends ArrayAdapter<String> {
    private final Activity mContext;
    private final String[] mTitle;
    private final String[] mPrice;
    private final String[] mLocation;
    private final String[] mDescription;
    private final Bitmap[] mImgId;
    private final Integer[] mPriceId;
    private final Integer[] mLocId;
    private final Integer[] mDescriptionId;


    public AddsAdapter(Activity context, String[] title, String[] price, String[] location, String[] description,
                       Bitmap[] imgId, Integer[] priceId, Integer[] locId, Integer[] decripId) {
        super(context, R.layout.list_item, title);
        this.mContext = context;
        this.mTitle = title;
        this.mPrice = price;
        this.mLocation = location;
        this.mDescription = description;
        this.mImgId = imgId;
        this.mPriceId = priceId;
        this.mLocId = locId;
        this.mDescriptionId = decripId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        ImageView imgId = (ImageView) rowView.findViewById(R.id.icon_main);
        ImageView imgPriceId = (ImageView) rowView.findViewById(R.id.icon_price);
        ImageView imgLocId = (ImageView) rowView.findViewById(R.id.icon_loc);
        ImageView imgDesId = (ImageView) rowView.findViewById(R.id.icon_description);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView price = (TextView) rowView.findViewById(R.id.price);
        TextView loc = (TextView) rowView.findViewById(R.id.loc);
        TextView descr = (TextView) rowView.findViewById(R.id.description);

        imgId.setImageBitmap(mImgId[position]);
        imgPriceId.setImageResource(mPriceId[position]);
        imgLocId.setImageResource(mLocId[position]);
        imgDesId.setImageResource(mDescriptionId[position]);
        title.setText(mTitle[position]);
        price.setText(mPrice[position]);
        loc.setText(mLocation[position]);
        descr.setText(mDescription[position]);
        return rowView;
    }
}
