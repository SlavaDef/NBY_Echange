package com.homework.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//import java.sql.Date;

import java.time.LocalDate;
import java.util.Date;
@NamedQueries({
        @NamedQuery(name = "ExchangeCourse_By_Date",
                query = "from ExchangeCourse e where e.exchangedate = :exchangedate"),
        @NamedQuery(name = "ExchangeCourse_By",
        query = "from ExchangeCourse  where exchangedate < :exchangedate")
} )



@NoArgsConstructor
@Data
@Entity
public class ExchangeCourse {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ToString.Exclude
    private String txt;
    @JsonIgnore
    private String r030;
    private double rate;

    private String cc;
    @Temporal(value = TemporalType.DATE)
    //  @JsonFormat(pattern = "dd.MM.yyyy")
    private Date exchangedate;

    public ExchangeCourse(String txt, double rate, String cc, Date exchangedate) {
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public ExchangeCourse(double rate, String cc, Date exchangedate) {
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "ExchangeCourse{" +
                " rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exchangedate=" + exchangedate +
                '}';
    }
}
