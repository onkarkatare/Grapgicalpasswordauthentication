package com.example.graphicalpassword;

public class getAllData {
    String uname,email;

    public getAllData() {
    }

    public getAllData(String uname, String email) {
        this.uname = uname;
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
