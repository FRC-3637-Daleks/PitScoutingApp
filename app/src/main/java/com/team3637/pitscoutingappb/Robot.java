package com.team3637.pitscoutingappb;

/**
 * Created by Ben Goldberg on 2/6/2015.
 */
public class Robot {
    private long id;
    private String number;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return number;
    }
}
