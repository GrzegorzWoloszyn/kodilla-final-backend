package com.grzegorzwoloszyn.controller;

import com.grzegorzwoloszyn.domain.CovidCaseDto;
import com.grzegorzwoloszyn.mapper.CovidMapper;
import com.grzegorzwoloszyn.service.DbCovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/covidcases")
public class CovidController {

    @Autowired
    private CovidMapper covidMapper;

    @Autowired
    private DbCovidService dbCovidService;

    @RequestMapping(method = RequestMethod.GET, value = "cases")
    public List<CovidCaseDto> getCases() {
        return covidMapper.mapToCovidCaseDtoList(dbCovidService.getAllCases());
    }

    @RequestMapping(method = RequestMethod.GET, value = "case")
    public CovidCaseDto getCase(@RequestParam Long id) throws CaseNotFoundException {
        return covidMapper.mapToCovidCaseDto(dbCovidService.getCovidCase(id).orElseThrow(CaseNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void deleteCase(@RequestParam Long id) throws CaseNotFoundException {
        dbCovidService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update")
    public CovidCaseDto updateCase(@RequestBody CovidCaseDto covidCaseDto) {
        return covidMapper.mapToCovidCaseDto(dbCovidService.saveCovidCase(covidMapper.mapToCovidCase(covidCaseDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "saveCase", consumes = APPLICATION_JSON_VALUE)
    public void createCase(@RequestBody CovidCaseDto covidCaseDto) {
        dbCovidService.saveCovidCase(covidMapper.mapToCovidCase(covidCaseDto));
    }
}
