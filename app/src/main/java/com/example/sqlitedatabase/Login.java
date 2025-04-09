package com.example.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText log_email, log_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log_email=(EditText) findViewById(R.id.log_email);
        log_pass=(EditText) findViewById(R.id.log_pass);
    }

    public void loginUser(View view){

        String email1=log_email.getText().toString();
        String pass1=log_pass.getText().toString();

        DbHelper dbHelper=new DbHelper(this);
        boolean loggedin=dbHelper.login(email1, pass1);

        if(loggedin){
            Intent intent=new Intent(this, Profile.class);
            intent.putExtra("key_email", email1);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Email id and password didn't matched", Toast.LENGTH_LONG).show();
        }
    }
}