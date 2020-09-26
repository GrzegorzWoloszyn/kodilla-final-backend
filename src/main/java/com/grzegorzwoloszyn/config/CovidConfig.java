package com.grzegorzwoloszyn.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CovidConfig {

    @Value("${covid19.api.endpoint.prod}")
    private String covid19ApiEndpoint;
}
