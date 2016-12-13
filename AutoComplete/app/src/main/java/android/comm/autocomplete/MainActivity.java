package android.comm.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity  {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line);
        arrayAdapter.add("India");
        arrayAdapter.add("Inreland");
        arrayAdapter.add("Delhi");
        arrayAdapter.add("USA");
        arrayAdapter.add("New York");

        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(arrayAdapter);


    }
}
