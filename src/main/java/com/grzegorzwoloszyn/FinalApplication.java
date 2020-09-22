package com.grzegorzwoloszyn;

import com.grzegorzwoloszyn.domain.CovidCaseDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FinalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FinalApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FinalApplication.class);
    }

}
