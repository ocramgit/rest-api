package com.mindera.users.model;

public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
