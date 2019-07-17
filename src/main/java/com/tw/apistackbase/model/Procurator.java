package com.tw.apistackbase.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Procurator {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Procurator(String name) {
        this.name = name;
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
}
