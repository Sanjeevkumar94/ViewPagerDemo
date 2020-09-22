package com.example.CustomAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.viewpagerdemo.CallsFragment;
import com.example.viewpagerdemo.ChatsFragment;
import com.example.viewpagerdemo.R;
import com.example.viewpagerdemo.StatusFragment;
import com.example.viewpagerdemo.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CustomAdapterDemo extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_demo);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.myViewPager);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        createViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        createTabIcons();
    }

    private void createTabIcons() {

        View customLayout = LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        TextView textView = customLayout.findViewById(R.id.name);
        textView.setText("Chats");
        tabLayout.getTabAt(0).setCustomView(customLayout);


        View customLayout2 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        TextView textView2 = customLayout2.findViewById(R.id.name);
        textView2.setText("Calls");
        tabLayout.getTabAt(1).setCustomView(customLayout2);

        View customLayout3 = LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        TextView textView3 = customLayout3.findViewById(R.id.name);
        textView3.setText("Status");
        tabLayout.getTabAt(2).setCustomView(customLayout3);

    }

    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ChatsFragment(),"Chats");
        viewPagerAdapter.addFragments(new CallsFragment(),"Calls");
        viewPagerAdapter.addFragments(new StatusFragment(),"Status");
        viewPager.setAdapter(viewPagerAdapter);

    }
}
