package com.grzegorzwoloszyn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "new_confirmed")
    private int newConfirmed ;

    @Column(name = "total_confirmed")
    private int totalConfirmed;

    @Column(name = "new_deaths")
    private int newDeaths;

    @Column(name = "total_deaths")
    private int totalDeaths;

    @Column(name = "new_recovered")
    private int newRecovered;

    @Column(name = "total_recovered")
    private int totalRecovered;

}
