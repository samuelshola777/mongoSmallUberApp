package com.example.mongosmalluberapp.account.accountrExeption;

public class LoginExeption extends  Exception{

    private  String message;

    public LoginExeption(String message){
        super(message);
    }

}
