package com.android.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intel on 4/13/2016.
 */
public class ImageAdapter extends BaseAdapter {

    Context context;
    List<Integer> mList = new ArrayList<>();

    public ImageAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.mList = imageList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_row, parent, false);
        } else {
            view = convertView;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(mList.get(position));
        return view;


    }
}
