package com.android.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by intel on 4/13/2016.
 */
public class NewsAdapter extends BaseAdapter {

    Context context;
    String[] mTitle;
    String[] mDescription;

    public NewsAdapter(Context context, String[] titles, String[] description){
        this.context = context;
        this.mTitle = titles;
        this.mDescription = description;
    }

    @Override
    public int getCount() {
        return mTitle.length;
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
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_news,parent,false);
        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView descView = (TextView) view.findViewById(R.id.description);

        titleView.setText(mTitle[position]);
        descView.setText(mDescription[position]);
        return view;

    }
}
