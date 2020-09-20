package com.grzegorzwoloszyn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityDto {

    private Long id;
    private String name;
    private int newConfirmed;
    private int totalConfirmed;
    private int newDeath;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;

}
