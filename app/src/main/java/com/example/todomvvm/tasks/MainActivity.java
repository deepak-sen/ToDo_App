package com.example.todomvvm.tasks;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.todomvvm.Adapter.TabAdapter;
import com.example.todomvvm.R;
import com.example.todomvvm.addedittask.AddEditTaskActivity;
import com.example.todomvvm.database.LoginDatabase;
import com.google.android.material.tabs.TabLayout;

import org.xml.sax.helpers.XMLReaderAdapter;

import java.util.Collections;

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

    public  void logout (){
        SharedPreferences sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }




//    ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
//
//           int position_dragged = dragged.getAdapterPosition();
//           int position_target = target.getAdapterPosition();
//           Collections.swap(myDataset,position_dragged,position_target);
//           mAdapter.notifyiItemMoved(position_dragged,position_target);
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//        }
//    });
//    helper.attachToRecyclerView()
}

