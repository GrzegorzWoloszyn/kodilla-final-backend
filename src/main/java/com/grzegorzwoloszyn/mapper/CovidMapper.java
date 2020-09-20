package com.grzegorzwoloszyn.mapper;

import com.grzegorzwoloszyn.domain.CovidCase;
import com.grzegorzwoloszyn.domain.CovidCaseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CovidMapper {

    public CovidCase mapToCovidCase(final CovidCaseDto covidCaseDto) {
        return new CovidCase(
                covidCaseDto.getId(),
                covidCaseDto.getCountry(),
                covidCaseDto.getCountryCode(),
                covidCaseDto.getLat(),
                covidCaseDto.getLon(),
                covidCaseDto.getDate()
        );
    }

    public CovidCaseDto mapToCovidCaseDto(final CovidCase covidCase) {
        return new CovidCaseDto(
                covidCase.getId(),
                covidCase.getCountry(),
                covidCase.getCountryCode(),
                covidCase.getLat(),
                covidCase.getLon(),
                covidCase.getDate()
        );
    }

    public List<CovidCaseDto> mapToCovidCaseDtoList(final List<CovidCase> cases) {
        return cases.stream()
                .map(c -> new CovidCaseDto(c.getId(), c.getCountry(), c.getCountryCode(), c.getLat(), c.getLon(), c.getDate()))
                .collect(Collectors.toList());
    }
}
