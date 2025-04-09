package com.example.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText reg_name, reg_email, reg_password, reg_gender;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_name=(EditText) findViewById(R.id.reg_name);
        reg_email=(EditText) findViewById(R.id.reg_email);
        reg_password=(EditText) findViewById(R.id.reg_password);
        reg_gender=(EditText) findViewById(R.id.reg_gender);

        dbHelper=new DbHelper(getApplicationContext());
    }

    public void registerUser(View view){
        String name1=reg_name.getText().toString();
        String email1=reg_email.getText().toString();
        String password1=reg_password.getText().toString();
        String gender1=reg_gender.getText().toString();

        boolean check=dbHelper.checkEmailExist(email1);
        if(check){
            Toast.makeText(this, "Email id already Exists", Toast.LENGTH_SHORT).show();
        }else{
            boolean b=dbHelper.registerUserHelper(name1, email1, password1, gender1);
            if(b==true){
                Toast.makeText(this, "User Registered Successfully...!!", Toast.LENGTH_SHORT).show();

                reg_name.setText("");
                reg_email.setText("");
                reg_password.setText("");
                reg_gender.setText("");

                startActivity(new Intent(this, MainActivity.class));
            }
            else{
                Toast.makeText(this, "Error..!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}