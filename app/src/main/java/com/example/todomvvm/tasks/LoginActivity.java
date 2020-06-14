package com.example.todomvvm.tasks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todomvvm.R;
import com.example.todomvvm.database.LoginDatabase;

import com.example.todomvvm.database.RoomDAO;
import com.example.todomvvm.database.UsernamePassword;

public class LoginActivity extends AppCompatActivity {

    private EditText user,pass;
    private Button login;
    private TextView register;
    private LoginDatabase loginDatabase;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        login = findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        register = findViewById(R.id.register);

        loginDatabase = LoginDatabase.geLoginDatabase(LoginActivity.this);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        RoomDAO roomDAO = loginDatabase.getRoomDAO();
        UsernamePassword temp = roomDAO.getLoggedInUser();
        if(temp!=null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(user.getText().toString().trim(),pass.getText().toString().trim());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

    }



    public void loginUser(String user, String pass){

        RoomDAO roomDAO = loginDatabase.getRoomDAO();
        UsernamePassword temp = roomDAO.getUserwithUsername(user);
        //Toast.makeText(this, temp.getPassword(), Toast.LENGTH_SHORT).show();
        if(temp==null){
            Toast.makeText(LoginActivity.this,"Invalid username or password", Toast.LENGTH_SHORT).show();
        }
        else{
            if(temp.getPassword().equals(pass)){
                temp.setIsloggedIn(1);
                roomDAO.Update(temp);
                LoginDatabase.destroyInstance();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(LoginActivity.this,"Invalid Password", Toast.LENGTH_SHORT).show();
            }
        }

    }


}
