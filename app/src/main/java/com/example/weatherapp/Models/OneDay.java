package com.example.weatherapp.Models;

public class OneDay {
    public ThreeHours[] getHours() {
        return hours;
    }

    public void setHours(ThreeHours[] hours) {
        this.hours = hours;
    }

    public ThreeHours[] hours;
}
