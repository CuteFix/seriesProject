package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Series")
public class Series {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOS=" + numberOS +
                ", rate=" + rate +
                ", description=" + description +
                '}';
    }

    private String name;
    private Integer numberOS;
    private double rate;
    private String description;

    public Series(String name, Integer numberOS, double rate, String description) {
        this.name = name;
        this.numberOS = numberOS;
        this.rate = rate;
        this.description = description;
    }
}
