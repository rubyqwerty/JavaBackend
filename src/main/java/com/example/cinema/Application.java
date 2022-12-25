package com.example.cinema;

public class Application {

    public String nameOfMovie;
    public String date;
    public String row;
    public String place;
    public String countGuests;
    public String nameFile;

    Application(String _nameOfMovie, String _date, String _row, String _place, String _countGuests, String _nameFile){
        this.nameOfMovie = _nameOfMovie;
        this.date = _date;
        this.row = _row;
        this.place = _place;
        this.countGuests = _countGuests;
        this.nameFile = _nameFile;
    }
    Application()
    {
        this.nameOfMovie = "";
        this.date = "";
        this.place = "";
        this.countGuests = "";
        this.row = "";
        this.nameFile = "";
    }

}
