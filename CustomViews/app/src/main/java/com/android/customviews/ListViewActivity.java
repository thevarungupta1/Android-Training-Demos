package com.android.customviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);

        List<String> data = new ArrayList<>();
        data.add("India");
        data.add("USA");
        data.add("Pakistan");
        data.add("Nepal");

        DataAdapter adapter = new DataAdapter(this, data);

        listView.setAdapter(adapter);


    }
}
