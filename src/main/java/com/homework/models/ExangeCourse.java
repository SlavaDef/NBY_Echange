package com.homework.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@Entity
public class ExangeCourse {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ToString.Exclude
    private String txt;
    private double rate;

    private String cc;

    private String exchangedate;

    public ExangeCourse(String txt, double rate, String cc, String exchangedate) {
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public ExangeCourse(double rate, String cc, String exchangedate) {
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }
}
