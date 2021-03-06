package com.example.searchview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        List<String> data = new ArrayList<>();
        data.add("Java");
        data.add("Java 8");
        data.add("Java jdk");
        data.add("Python");
        data.add("Android");
        data.add("Kotlin");
        data.add("Firebase");
        data.add("Networking");
        Collections.sort(data);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }

    private void init() {
        searchView = findViewById(R.id.searchview);
        listView = findViewById(R.id.list_item);
        imageView = findViewById(R.id.image);
    }
}