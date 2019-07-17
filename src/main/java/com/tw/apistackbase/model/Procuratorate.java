package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Procuratorate {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false,length = 50)
    private String name;

    public Procuratorate(String name) {
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
