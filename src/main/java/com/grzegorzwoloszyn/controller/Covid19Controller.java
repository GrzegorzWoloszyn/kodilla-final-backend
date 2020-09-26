package com.grzegorzwoloszyn.controller;

import com.grzegorzwoloszyn.config.client.CovidClient;
import com.grzegorzwoloszyn.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/covid19")
public class Covid19Controller {

    @Autowired
    private CovidClient covidClient;

    @RequestMapping(method = RequestMethod.GET, value = "summary")
    public CovidStatDto getSummary() {
        return covidClient.getSummary();

    }

    @RequestMapping(method = RequestMethod.GET, value = "countries")
    public void getCountries() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "country")
    public List<OneCountryDto> getAllForOneCountry(@RequestParam String country, @RequestParam String status, @RequestParam String from, @RequestParam String to) {
        return covidClient.getByCountry(country, status, from, to);
    }
}
