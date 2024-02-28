package com.example.devfirstsssion;

public class User {

    private String name;
    private String email;
    private  String password;

    public  void User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;


    }


    public  void SetName(String name){
        this.name = name;
    }

    public  void SetEmail(String email){
        this.email = email;
    }

    public void SetPassword(String Password){
        this.password = password;
    }

    public String GetName(){
        return  name;
    }

    public String GetEmail(){
        return email;
    }

    public  String GetPassword(){
        return password;
    }
    @Override
    public String toString(){
        return "User{" + "name= " + this.name + '\'' + "email= " + this.email +'\'' + "password= " + this.password + '}';
    }







}
