package com.aliniacoban.fishingindenmark.terraiot.Model;
/////////////////////////////////////
//                                //
//Whole class is written by Alin  //
//                                //
////////////////////////////////////
public class User {

    public String email, username, password;

    public User(){

    }

    public User(String username, String email, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
