package com.grzegorzwoloszyn.repository;

import com.grzegorzwoloszyn.domain.CovidCase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CovidCaseRepository extends CrudRepository<CovidCase, Long> {

    @Override
    List<CovidCase> findAll();

    Optional<CovidCase> findById(Long id);

    CovidCase save(CovidCase covidcase);

    void deleteById(Long id);
}
