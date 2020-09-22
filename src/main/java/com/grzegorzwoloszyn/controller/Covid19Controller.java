package com.grzegorzwoloszyn.controller;

import com.grzegorzwoloszyn.config.client.CovidClient;
import com.grzegorzwoloszyn.domain.CovidStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/covid19")
public class Covid19Controller {

    @Autowired
    private CovidClient covidClient;

    @RequestMapping(method = RequestMethod.GET, value = "summary")
    public void getSummary() {
        CovidStat summary = covidClient.getSummary();
        System.out.println(summary.toString());

    }
}
