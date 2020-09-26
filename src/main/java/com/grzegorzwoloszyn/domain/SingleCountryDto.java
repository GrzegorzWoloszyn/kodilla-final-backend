package com.grzegorzwoloszyn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleCountryDto {

    @JsonProperty("Country")
    private String country;

    @Override
    public String toString() {
        return "SingleCountry{" +
                "country='" + country + '\'' +
                '}';
    }
}
