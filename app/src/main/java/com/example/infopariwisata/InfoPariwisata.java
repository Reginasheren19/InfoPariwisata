package com.example.infopariwisata;

public class InfoPariwisata {
    private String name;
    private String location;
    private int imageResource;
    private String details;
    private double rating;

    public InfoPariwisata(String name, String location, int imageResource, String details, double rating) {
        this.name = name;
        this.location = location;
        this.imageResource = imageResource;
        this.details = details;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDetails() {
        return details;
    }

    public double getRating() {
        return rating;
    }
}
