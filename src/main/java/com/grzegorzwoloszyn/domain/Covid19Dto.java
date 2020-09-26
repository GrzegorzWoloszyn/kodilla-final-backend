package com.grzegorzwoloszyn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Covid19Dto {

    private String name;
    private int confirmed;
    private int deaths;
    private int active;
    private String data;


    @Override
    public String toString() {
        return "Covid19Dto:" +
                "name='" + name + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", active=" + active +
                ", data='" + data + '\'';
    }
}
