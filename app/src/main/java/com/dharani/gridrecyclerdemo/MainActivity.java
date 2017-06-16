package com.dharani.gridrecyclerdemo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"};

    private final String android_image_urls[] = {
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg",
            "http://api.androidhive.info/json/movies/1.jpg"
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_ID);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroidVersionName(android_version_names[i]);
            androidVersion.setAndroidImage(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        
        DataAdapter adapter = new DataAdapter(getApplicationContext(), android_version);
        recyclerView.setAdapter(adapter);
    }

}
