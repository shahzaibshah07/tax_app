package com.example.befilerclown;

public class User {
    String user_id;
    String email;
    String password;
    String mobile;


    public User(String email,String user_id,String password,String mobile) {
        this.email = email;
        this.password =password;
        this.user_id = user_id;
        this.mobile = mobile;

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
