package com.example.roomdarabasedemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdarabasedemo.R;
import com.example.roomdarabasedemo.models.users;
import com.example.roomdarabasedemo.roomdb.DatabaseProvider;

public class RegisterActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3,editText4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.email);
        editText3 = findViewById(R.id.mobile);
        editText4 = findViewById(R.id.pass);

    }

    public void doRegister(View view) {
        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String mobile = editText3.getText().toString();
        String pass = editText4.getText().toString();

        if (name.equals("") || email.equals("") || pass.equals("") || mobile.equals("")){
            Toast.makeText(this, "please fill details", Toast.LENGTH_SHORT).show();

        }else{
            users users = new users();
            users.setName(name);
            users.setEmail(email);
            users.setMobile(mobile);
            users.setPass(pass);

            DatabaseProvider databaseProvider = DatabaseProvider.getDbConnection(this.getApplicationContext());
            databaseProvider.getuserDao().insertUser(users);
            Toast.makeText(this, "Data inserted succesfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            finish();



        }

    }
}