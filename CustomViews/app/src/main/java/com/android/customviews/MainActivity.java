package com.android.customviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.p1);
        imageList.add(R.drawable.p2);
        imageList.add(R.drawable.p3);
        imageList.add(R.drawable.p4);
        imageList.add(R.drawable.p5);
        imageList.add(R.drawable.p6);
        imageList.add(R.drawable.p7);
        imageList.add(R.drawable.p8);

        ImageAdapter imageAdapter = new ImageAdapter(this, imageList);
        gridView.setAdapter(imageAdapter);




    }
}
