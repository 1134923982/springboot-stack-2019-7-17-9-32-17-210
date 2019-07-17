package com.tw.apistackbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CriminalCase {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long caseTime;

    public CriminalCase(String name, long caseTime) {
        this.name = name;
        this.caseTime = caseTime;
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + caseTime +
                '}';
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

    public long getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(long caseTime) {
        this.caseTime = caseTime;
    }
}
