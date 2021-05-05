package com.example.pmobakhir;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        TabLayout Tab= findViewById(R.id.tabs);
        Tab.setupWithViewPager(viewPager);
    }

}