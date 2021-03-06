package com.grzegorzwoloszyn.scheduler;

import com.grzegorzwoloszyn.config.client.CovidClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    private CovidClient covidClient;


    @Scheduled(cron = "0 0 12 * * *")
    public void getSummary(){
        covidClient.getSummary();

    }

}
