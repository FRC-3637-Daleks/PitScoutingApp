package com.team3637.pitscoutingappb;

import java.io.Serializable;

/**
 * Created by Ben Goldberg on 2/6/2015.
 */
public class Robot implements Serializable {
    private static final long serialVersionUID = 9001L;
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
