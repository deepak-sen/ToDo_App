package com.example.todomvvm.tasks;

import android.content.Intent;
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

public class Register extends AppCompatActivity {

    private EditText user,pass;
    private Button register;
    private TextView login;
    private LoginDatabase loginDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        register = findViewById(R.id.button);
        login = findViewById(R.id.login);

        loginDatabase = LoginDatabase.geLoginDatabase(Register.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(user.getText().toString().trim(),pass.getText().toString().trim());
            }
        });

    }


    public void registerUser(String user, String pass){

        RoomDAO roomDAO = loginDatabase.getRoomDAO();
        UsernamePassword temp = new UsernamePassword();
        temp.setUsename(user);
        temp.setPassword(pass);
        temp.setIsloggedIn(0);

        UsernamePassword temp2 = roomDAO.getUserwithUsername(user);
        if(temp2==null) {
            roomDAO.Insert(temp);
            Toast.makeText(Register.this,"Registered Successfully", Toast.LENGTH_SHORT).show();
            LoginDatabase.destroyInstance();
            Intent intent = new Intent(Register.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(Register.this,"User Already Registered", Toast.LENGTH_SHORT).show();

    }
}
