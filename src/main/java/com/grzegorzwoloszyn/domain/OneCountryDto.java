package com.grzegorzwoloszyn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OneCountryDto {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("Lat")
    private String lat;
    @JsonProperty("Lon")
    private String lon;
    @JsonProperty("Cases")
    private Integer cases;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Date")
    private String date;

    @Override
    public String toString() {
        return "OneCountry{" +
                "country='" + country + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", cases=" + cases +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
