package com.grzegorzwoloszyn.service;

import com.grzegorzwoloszyn.domain.City;
import com.grzegorzwoloszyn.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbCityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCity(final Long id) {
        return cityRepository.findById(id);
    }

    public City saveCity(final City city) {
        return cityRepository.save(city);
    }

    public void delete(final Long id) {
        cityRepository.deleteById(id);
    }
}
