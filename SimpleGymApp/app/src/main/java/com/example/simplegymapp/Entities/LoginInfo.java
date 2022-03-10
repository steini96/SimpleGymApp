package com.example.simplegymapp.Entities;

public class LoginInfo {
    private String password;
    private byte[] salt;
    private long ID;


    public LoginInfo(String password, long ID, byte[] salt) {
        this.password = password;
        this.ID = ID;
        this.salt = salt;
    }

    public LoginInfo(String password){
        this.password = password;
    }

    public LoginInfo() {
    }

    public String getPassword() {
        return password;
    }

    public long getID() {
        return ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public byte[] getSalt() { return salt;}

    public void setSalt(byte[] salt) {this.salt = salt;}
}

