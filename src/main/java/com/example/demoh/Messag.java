package com.example.demoh;

import com.google.gson.Gson;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Messag {
    private Date date = new Date();
    private static String name;
    private String to;
    private String text;

    public Messag(Date date, String name,  String to, String text) {
        this.date = date;
        this.name = name;
        this.to = to;
        this.text = text;
    }

    public Messag() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Messag fromJson(String message) {
        Gson gson = new Gson();

        return gson.fromJson(message, Messag.class);
    }

    @Override
    public String toString() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy  hh:mm:ss");
        String s = formatForDateNow.format(this.date) + "\n"
                + this.name + "\n"
                + this.text;
        return s;
    }
}
