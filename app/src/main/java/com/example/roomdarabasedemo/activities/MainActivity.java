package com.example.roomdarabasedemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdarabasedemo.R;
import com.example.roomdarabasedemo.models.users;
import com.example.roomdarabasedemo.roomdb.DatabaseProvider;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.email);
        editText2 = findViewById(R.id.pass);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void login(View view) {


        String email = editText1.getText().toString();
        String pass = editText2.getText().toString();

        if (email.equals("") || pass.equals("")) {
            Toast.makeText(this, "please fill details", Toast.LENGTH_SHORT).show();

        } else {

            /*users users = new users();
            users.setEmail(email);
            users.setPass(pass);*/
            DatabaseProvider databaseProvider = DatabaseProvider.getDbConnection(this.getApplicationContext());
            List<users> user  = databaseProvider.getuserDao().getAllUsers();
            Iterator<users> usersIterator= user.iterator();
            while (usersIterator.hasNext()){
                users user1 = (users) usersIterator.next();
                String email1 = user1.getEmail();
                String pass1 = user1.getPass();
                if (email.equals(email1) && pass.equals(pass1)){
                    Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();

                }


/*
                Toast.makeText(this, "userdata"+email1+" "+pass1, Toast.LENGTH_SHORT).show();
*/


            }
        }

    }
}
