package com.example.todomvvm.tasks;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.todomvvm.Adapter.TabAdapter;
import com.example.todomvvm.R;
import com.example.todomvvm.addedittask.AddEditTaskActivity;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        int id = item.getItemId();
//        if (id == R.id.settings){
//            Intent myintent = new Intent(MainActivity.this, AddEditTaskActivity.class);
//            StartActivity(myintent);
//            return false;

        switch(item.getItemId()){

            case R.id.settings:
                Toast.makeText(MainActivity.this,"Settings is clicked",Toast.LENGTH_LONG).show();

                break;

            case R.id.exit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

