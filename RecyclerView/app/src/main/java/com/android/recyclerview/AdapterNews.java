package com.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by intel on 4/28/2016.
 */
public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {

    ArrayList<News> mList = new ArrayList<>();
    Context mContext;

    public AdapterNews(Context context, ArrayList<News> list) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_adapter,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = mList.get(position);

        holder.titleView.setText(news.getTitle());
        holder.descView.setText(news.getDesciption());

        //Loading Image from URL
        Picasso.with(mContext)
                .load(news.getImage())
                .placeholder(R.drawable.no)    // optional
                .error(R.drawable.no)          // optional
                .resize(100, 100)                        // optional
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleView;
        TextView descView;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            titleView = (TextView) itemView.findViewById(R.id.title_view);
            descView = (TextView) itemView.findViewById(R.id.desc_view);
        }
    }

}
