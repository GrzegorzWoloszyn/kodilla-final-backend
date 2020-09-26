package com.grzegorzwoloszyn.config.client;

import com.grzegorzwoloszyn.config.CovidConfig;
import com.grzegorzwoloszyn.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CovidClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CovidClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CovidConfig covidConfig;

    public CovidStatDto getSummary() {
        LOGGER.info("Starting method 'getSummary'");
        try{ CovidStatDto summary = restTemplate.getForObject(createUrlSummary(), CovidStatDto.class);
            return Optional.ofNullable(summary).orElse(new CovidStatDto());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new CovidStatDto();
        }
    }

    public List<SingleCountryDto> getCountries() {
        return Optional.ofNullable(Arrays.asList(restTemplate.getForObject(createUrlCountries(), SingleCountryDto[].class))).orElse(new ArrayList<>());
    }

    public List<OneCountryDto> getByCountry(String country, String status, String from, String to) {
        OneCountryDto[] oneCountry = restTemplate.getForObject(covidConfig.getCovid19ApiEndpoint() + "/country/" + country +
                "/status/" + status + "?from=" + from + "&to=" + to, OneCountryDto[].class);

        return Arrays.asList(oneCountry);
    }

    private URI createUrlSummary() {
        return UriComponentsBuilder.fromHttpUrl(covidConfig.getCovid19ApiEndpoint() + "/summary").build().toUri();
    }

    private URI createUrlCountries() {
        return UriComponentsBuilder.fromHttpUrl(covidConfig.getCovid19ApiEndpoint() + "/countries").build().toUri();
    }
}
