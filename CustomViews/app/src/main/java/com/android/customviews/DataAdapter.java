package com.android.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by intel on 4/13/2016.
 */
public class DataAdapter extends BaseAdapter {

    Context context;
    List<String> mList;

    public DataAdapter(Context context, List<String> list){
        this.context = context;
        this.mList = list;
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
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_row, parent,false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mList.get(position));
        return view;

    }
}
