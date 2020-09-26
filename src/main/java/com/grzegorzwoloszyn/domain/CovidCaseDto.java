package com.grzegorzwoloszyn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CovidCaseDto {

    private Long id;
    private String country;
    private String date;

    
}
