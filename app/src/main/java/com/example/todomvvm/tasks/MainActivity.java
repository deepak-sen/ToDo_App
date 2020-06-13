package com.example.todomvvm.tasks;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.todomvvm.Adapter.TabAdapter;
import com.example.todomvvm.R;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity  {

    // Constant for logging
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfragment);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ListFragment(), "Todo-List");
        adapter.addFragment(new SecondFragment(), "Category");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

