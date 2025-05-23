package com.example.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLoginActivity(View view){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openRegisterActivity(View view){
        Intent intent=new Intent(this, Register.class);
        startActivity(intent);
    }
}