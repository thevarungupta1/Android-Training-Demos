package com.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterNews adapterNews;
    ArrayList<News> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        News news = new News();

        news.setImage("http://img5a.flixcart.com/image/sari/x/h/h/1-1-ss1096-r13-shoponn-275x340-imaeakw8ggmfzqce.jpeg");
        news.setTitle("Modi takes his place at Madame Tussauds");
        news.setDesciption("he PM was delighted with the final results, declaring that the Madame Tussauds team are \"exceptional at what they do\".");
        list.add(news);

        news.setImage("http://www.thehindu.com/multimedia/dynamic/02832/modi_wax_statue_2832179e.jpg");
        news.setTitle("Modi takes his place at Madame Tussauds");
        news.setDesciption("he PM was delighted with the final results, declaring that the Madame Tussauds team are \"exceptional at what they do\".");
        list.add(news);

        news.setImage("http://www.thehindu.com/multimedia/dynamic/02832/modi_wax_statue_2832179e.jpg");
        news.setTitle("Modi takes his place at Madame Tussauds");
        news.setDesciption("he PM was delighted with the final results, declaring that the Madame Tussauds team are \"exceptional at what they do\".");
        list.add(news);

        news.setImage("http://www.thehindu.com/multimedia/dynamic/02832/modi_wax_statue_2832179e.jpg");
        news.setTitle("Modi takes his place at Madame Tussauds");
        news.setDesciption("he PM was delighted with the final results, declaring that the Madame Tussauds team are \"exceptional at what they do\".");
        list.add(news);

        button = (Button) findViewById(R.id.button);
        adapterNews = new AdapterNews(this, list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapterNews);





    }
}
