package com.grzegorzwoloszyn.service;

import com.grzegorzwoloszyn.domain.CovidCase;
import com.grzegorzwoloszyn.repository.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbCovidService {

    @Autowired
    private CovidCaseRepository covidCaseRepository;

    public List<CovidCase> getAllCases() {
        return covidCaseRepository.findAll();
    }

    public Optional<CovidCase> getCovidCase(final Long id) {
        return covidCaseRepository.findById(id);
    }

    public CovidCase saveCovidCase(final CovidCase covidCase) {
        return covidCaseRepository.save(covidCase);
    }

    public void delete(final Long id) {
        covidCaseRepository.deleteById(id);
    }
}
