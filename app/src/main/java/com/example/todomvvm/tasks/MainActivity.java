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
import android.widget.SearchView;
import android.widget.Toast;

import com.example.todomvvm.Adapter.TabAdapter;
import com.example.todomvvm.R;
import com.example.todomvvm.addedittask.AddEditTaskActivity;
import com.example.todomvvm.database.LoginDatabase;
import com.example.todomvvm.database.RoomDAO;
import com.example.todomvvm.database.UsernamePassword;
import com.google.android.material.tabs.TabLayout;

import org.xml.sax.helpers.XMLReaderAdapter;

import java.util.Collections;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener
{

    // Constant for logging
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LoginDatabase loginDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfragment);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ListFragment(), "Todo-List");
        adapter.addFragment(new SecondFragment(), "About");

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
            case R.id.logout:
                logout();

                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void logout (){
        loginDatabase = LoginDatabase.geLoginDatabase(MainActivity.this);
        RoomDAO roomDAO = loginDatabase.getRoomDAO();
        UsernamePassword temp = roomDAO.getLoggedInUser();
        if(temp!=null){
            temp.setIsloggedIn(0);
            roomDAO.Update(temp);
            LoginDatabase.destroyInstance();
        }
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }



}

