package com.example.sqlitedatabase;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String name;
    private String email;
    private String gender;

    UserModel(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
