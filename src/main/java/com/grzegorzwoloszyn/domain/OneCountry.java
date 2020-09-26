package com.grzegorzwoloszyn.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OneCountry {

    private String country;
    private String lat;
    private String lon;
    private Integer cases;
    private String status;
    private String date;
}
