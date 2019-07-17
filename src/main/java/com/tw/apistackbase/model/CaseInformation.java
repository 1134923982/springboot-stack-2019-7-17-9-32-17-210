package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class CaseInformation {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String subjectiveElement;
    @Column(nullable = false)
    private String objectiveElement;

    public CaseInformation(String subjectiveElement, String objectiveElement) {
        this.subjectiveElement = subjectiveElement;
        this.objectiveElement = objectiveElement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectiveElement() {
        return subjectiveElement;
    }

    public void setSubjectiveElement(String subjectiveElement) {
        this.subjectiveElement = subjectiveElement;
    }

    public String getObjectiveElement() {
        return objectiveElement;
    }

    public void setObjectiveElement(String objectiveElement) {
        this.objectiveElement = objectiveElement;
    }
}
