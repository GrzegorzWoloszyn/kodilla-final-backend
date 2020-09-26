
package com.grzegorzwoloszyn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidStatDto {

    @JsonProperty("Global")
    private Global global;

    @JsonProperty("Countries")
    private List<Country> countries = new ArrayList<>();

    @JsonProperty("Date")
    private String date;

    @Override
    public String toString() {
        return "CovidStat{" +
                " global = " + global +
                ", countries = " + countries +
                ", date = " + date + '}';
    }
}
