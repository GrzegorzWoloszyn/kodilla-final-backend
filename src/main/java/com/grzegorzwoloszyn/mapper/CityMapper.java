package com.grzegorzwoloszyn.mapper;

import com.grzegorzwoloszyn.domain.City;
import com.grzegorzwoloszyn.domain.CityDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public City mapToCity(final CityDto cityDto) {
        return new City(
                cityDto.getId(),
                cityDto.getName(),
                cityDto.getNewConfirmed(),
                cityDto.getTotalConfirmed(),
                cityDto.getNewDeath(),
                cityDto.getTotalDeaths(),
                cityDto.getNewRecovered(),
                cityDto.getTotalRecovered()
        );
    }

    public CityDto mapToCityDto(final City city) {
        return new CityDto(
                city.getId(),
                city.getName(),
                city.getNewConfirmed(),
                city.getTotalConfirmed(),
                city.getNewDeaths(),
                city.getTotalDeaths(),
                city.getNewRecovered(),
                city.getTotalRecovered()
        );
    }

    public List<CityDto> mapToCityDtoList(final List<City> cities) {
        return cities.stream()
                .map(c -> new CityDto(c.getId(), c.getName(), c.getNewConfirmed(), c.getTotalConfirmed(), c.getNewDeaths(),
                        c.getTotalDeaths(), c.getNewRecovered(), c.getTotalRecovered()))
                .collect(Collectors.toList());
    }
}
