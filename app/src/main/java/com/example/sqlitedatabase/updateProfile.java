package com.example.sqlitedatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class updateProfile extends AppCompatActivity  {

    TextView up_email;
    EditText up_name, up_gender;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile);

        up_email=(TextView) findViewById(R.id.up_email);
        up_name=(EditText) findViewById(R.id.up_name);
        up_gender=(EditText) findViewById(R.id.up_gender);

        userModel=(UserModel) getIntent().getSerializableExtra("key_usermodel");
        up_email.setText(userModel.getEmail());
        up_name.setText(userModel.getName());
        up_gender.setText(userModel.getGender());
    }

    public void updateMyProfile(View view){
        String name1=up_name.getText().toString();
        String gender1=up_gender.getText().toString();

        DbHelper dbHelper=new DbHelper(this);
        boolean b=dbHelper.updateProfileHelper(userModel.getEmail(), name1, gender1);
        
        if(b){
            Toast.makeText(this, "Values Update Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        }
    }
}