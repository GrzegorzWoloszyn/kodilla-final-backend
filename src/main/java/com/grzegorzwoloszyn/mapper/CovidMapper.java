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
                covidCaseDto.getDate()
        );
    }

    public CovidCaseDto mapToCovidCaseDto(final CovidCase covidCase) {
        return new CovidCaseDto(
                covidCase.getId(),
                covidCase.getCountry(),
                covidCase.getDate()
        );
    }

    public List<CovidCaseDto> mapToCovidCaseDtoList(final List<CovidCase> cases) {
        return cases.stream()
                .map(c -> new CovidCaseDto(c.getId(), c.getCountry(), c.getDate()))
                .collect(Collectors.toList());
    }
}
