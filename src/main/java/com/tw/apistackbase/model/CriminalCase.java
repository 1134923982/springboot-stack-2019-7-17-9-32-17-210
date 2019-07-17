package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CriminalCase {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long caseTime;
    @OneToOne(cascade = CascadeType.ALL)
    private CaseInformation caseInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Procuratorate procuratorate;

//    public CriminalCase(String name, long caseTime, @NotNull Procuratorate procuratorate) {
//        this.name = name;
//        this.caseTime = caseTime;
//        this.procuratorate = procuratorate;
//    }

    public CriminalCase() {
    }

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

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public void setCaseTime(long caseTime) {
        this.caseTime = caseTime;
    }
}
