package com.ioad.accountbook.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {

    Context mContext;
    int[] imageData;
    String[] nameData;

    public GridViewAdapter(Context context, int[] data, String[] name) {
        this.mContext = context;
        this.imageData = data;
        this.nameData = name;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        TextView textView = new TextView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(300,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);

        imageView.setImageResource(imageData[position]);
        textView.setText(nameData[position]);


        return null;
    }
}
