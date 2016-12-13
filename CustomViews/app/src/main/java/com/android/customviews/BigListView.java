package com.android.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class BigListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] title = getResources().getStringArray(R.array.title);
        String[] description = getResources().getStringArray(R.array.description);

        NewsAdapter adapter = new NewsAdapter(this,title,description);
        listView.setAdapter(adapter);

    }
}
