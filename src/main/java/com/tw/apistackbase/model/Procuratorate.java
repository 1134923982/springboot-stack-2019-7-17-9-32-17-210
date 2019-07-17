package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false,length = 50,unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Procurator> procurators = new ArrayList<>();

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

    public List<Procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<Procurator> procurators) {
        this.procurators = procurators;
    }
}
