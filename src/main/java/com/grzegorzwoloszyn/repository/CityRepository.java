package com.grzegorzwoloszyn.repository;

import com.grzegorzwoloszyn.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {

    @Override
    List<City> findAll();

    @Override
    Optional<City> findById(Long id);

    @Override
    City save(City city);

    @Override
    void deleteById(Long id);
}
