package com.example.simplegymapp.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long ID;
    private String emailAddress;
    private String name;

    LoginInfo loginInfo;
    UserFitnessInfo userFitnessInfo;

    public User() {
    }

    public User(String Name, String emailAddress, LoginInfo LoginInfo, UserFitnessInfo userFitnessInfo){
        this.name = Name;
        this.emailAddress = emailAddress;
        this.loginInfo = LoginInfo;
        this.userFitnessInfo = userFitnessInfo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public LoginInfo getLoginInfo() {

        return loginInfo;
    }

    public UserFitnessInfo getUserFitnessInfo() {
        return userFitnessInfo;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginInfo(LoginInfo loginInfo) {

        this.loginInfo = loginInfo;
    }

    public void setUserFitnessInfo(UserFitnessInfo userFitnessInfo) {
        this.userFitnessInfo = userFitnessInfo;
    }
}