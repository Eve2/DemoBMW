package com.example.eve.demobmw.utils;


public class Utils {

    public static final String BASE_API = "https://maps.googleapis.com/maps/api/directions/json?";

    public static String reFormatTime(String time) {
        String[] splitTeimt = time.split("T");
        String newTime = splitTeimt[0] + " " + splitTeimt[1];

        return newTime;
    }

}
