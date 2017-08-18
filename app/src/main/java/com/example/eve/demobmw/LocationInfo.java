package com.example.eve.demobmw;

/**
 * Created by Eve on 8/14/17.
 */

public class LocationInfo {

    String ID, Name, Latitude, Longitude, Address, ArrivalTime;

    public LocationInfo(String ID, String name, String latitude,
                        String longitude, String address,
                        String arrivalTime) {
        this.ID = ID;
        Name = name;
        Latitude = latitude;
        Longitude = longitude;
        Address = address;
        ArrivalTime = arrivalTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }
}
