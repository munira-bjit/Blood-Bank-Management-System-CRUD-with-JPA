package com.munira.main.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
//@Table(name="patient")
@Component
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "blood_id")

    private Blood blood;

    public Patient() {
    }

    public Patient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patient(Integer id, String name, Blood blood) {
        this.id = id;
        this.name = name;
        this.blood = blood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }
}
