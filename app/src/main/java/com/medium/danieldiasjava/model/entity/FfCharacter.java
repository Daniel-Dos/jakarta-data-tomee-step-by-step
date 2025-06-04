package com.medium.danieldiasjava.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FfCharacter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String eikon;
    private boolean dominant;

    public FfCharacter() {
    }

    public FfCharacter(String name, String eikon, boolean dominant) {
        this.name = name;
        this.eikon = eikon;
        this.dominant = dominant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEikon() {
        return eikon;
    }

    public void setEikon(String eikon) {
        this.eikon = eikon;
    }

    public boolean isDominant() {
        return dominant;
    }

    public void setDominant(boolean dominant) {
        this.dominant = dominant;
    }
}

