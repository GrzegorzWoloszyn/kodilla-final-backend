
package com.grzegorzwoloszyn.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Global {

    @JsonProperty("NewConfirmed")
    private Integer newConfirmed;
    @JsonProperty("TotalConfirmed")
    private Integer totalConfirmed;
    @JsonProperty("NewDeaths")
    private Integer newDeaths;
    @JsonProperty("TotalDeaths")
    private Integer totalDeaths;
    @JsonProperty("NewRecovered")
    private Integer newRecovered;
    @JsonProperty("TotalRecovered")
    private Integer totalRecovered;

    @Override
    public String toString() {
        return "Global{" +
                " newConfirmed = " + newConfirmed +
                ", totalConfirmed = " + totalConfirmed +
                ", newDeaths = " + newDeaths +
                ", totalDeaths = " + totalDeaths +
                ", newRecovered = " + newRecovered +
                ", totalRecovered = " + totalRecovered + "}"
                + '\n';
    }
}
