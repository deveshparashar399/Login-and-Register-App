package com.example.sqlitedatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitedatabase.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    TextView profile_name, profile_email, profile_gender;
    String email1;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name=(TextView) findViewById(R.id.profile_name);
        profile_email=(TextView) findViewById(R.id.profile_email);
        profile_gender=(TextView) findViewById(R.id.profile_gender);

        email1=getIntent().getStringExtra("key_email");

        getUserDetails();
    }

    public void getUserDetails(){
        DbHelper dbHelper=new DbHelper(this);
        ArrayList<UserModel> al=dbHelper.getLoggedinUserDetails(email1);
        userModel=al.get(0);

        profile_name.setText(userModel.getName());
        profile_email.setText(userModel.getEmail());
        profile_gender.setText(userModel.getGender());
    }

    public void logoutUser(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void getAllUserDetails(View view){
        DbHelper dbHelper=new DbHelper(this);
        ArrayList al=dbHelper.getAllUserDetailsHelper();
        Toast.makeText(this, ""+al, Toast.LENGTH_SHORT).show();
    }

    public void updateProfile(View view){
//        startActivity(new Intent(this, updateProfile.class));

        Intent intent=new Intent(this, updateProfile.class);
        intent.putExtra("key_usermodel", userModel);
        startActivity(intent);
    }

    public void deleteProfile(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete Profile");
        builder.setMessage("Are you sure you want to delete this profile ?");

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DbHelper dbHelper=new DbHelper(Profile.this);
                boolean b=dbHelper.deleteProfileHelper(userModel.getEmail());
                if(b){
                    Toast.makeText(Profile.this, "Profile Deleted Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Profile.this, MainActivity.class));
                }else{
                    Toast.makeText(Profile.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.show();
    }
}