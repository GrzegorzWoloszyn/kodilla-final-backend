package com.grzegorzwoloszyn.config.client;

import com.grzegorzwoloszyn.domain.CovidStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class CovidClient {

    @Value("${covid19.api.endpoint.prod}")
    private String covid19ApiEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public CovidStat getSummary() {

        CovidStat summaryResponse = restTemplate.getForObject(createUrl(), CovidStat.class);

        if(summaryResponse != null) {
            return summaryResponse;
        }
        return new CovidStat();
    }

    private URI createUrl() {

        URI url = UriComponentsBuilder.fromHttpUrl(covid19ApiEndpoint + "/summary").build().toUri();
        return url;
    }
}
