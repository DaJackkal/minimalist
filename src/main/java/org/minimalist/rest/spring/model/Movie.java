package org.minimalist.rest.spring.model;

public class Movie {

    private int id;
    private String name;
    private int year;

    public Movie(final int id, final String name, final int year){
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
