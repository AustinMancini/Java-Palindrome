package com.example.demo;

import java.io.Serializable;

public class Post implements Serializable {

    public int id;
    public String name;

    public Post() {
        this.id = id;
        this.name = name;
    }

    // getters and setters
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
}
