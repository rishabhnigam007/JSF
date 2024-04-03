package com.crud.test.crudjsf.model;

import java.io.Serializable;

/**
 *
 * @author Rishabh
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String city;

    public User() {
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.city = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
