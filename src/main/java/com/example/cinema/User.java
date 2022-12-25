package com.example.cinema;

import java.util.ArrayList;

public class User {

    public String name;
    public String email;
    public String password;

    public String role;
    public String nameOfPicture;
    public ArrayList<Application> Applications = new ArrayList<>();

    User (String _name, String _email, String _password){
        this.name = _name;
        this.email = _email;
        this.password = _password;
    }



    User(){
        this.name = "";
        this.email = "";
        this.password = "";
        this.nameOfPicture = "";
        this.role = "";
    }

}
