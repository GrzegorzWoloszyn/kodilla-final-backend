package com.grzegorzwoloszyn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CovidStat {
    private Global global;
    private List<Country> countries = new ArrayList<>();
    private String date;
}
