package com.example.cinema;

public class News {
    public String nameOfNew;
    public String text;
    News(){
        this.nameOfNew = "";
        this.text = "";
    }
    News(String _nameOfNew, String _text){
        this.nameOfNew = _nameOfNew;
        this.text = _text;
    }
}
