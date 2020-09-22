package com.grzegorzwoloszyn.controller;

import com.grzegorzwoloszyn.domain.CityDto;
import com.grzegorzwoloszyn.mapper.CityMapper;
import com.grzegorzwoloszyn.service.DbCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cities")
public class CityController {

    @Autowired
    private DbCityService dbCityService;
    @Autowired
    private CityMapper cityMapper;

    @RequestMapping(method = RequestMethod.GET, value = "cities")
    public List<CityDto> getCities() {
        return cityMapper.mapToCityDtoList(dbCityService.getAllCities());
    }

    @RequestMapping(method = RequestMethod.GET, value = "city")
    public CityDto getCity(@RequestParam Long id) throws CityNotFoundException {
        return cityMapper.mapToCityDto(dbCityService.getCity(id).orElseThrow(CityNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete")
    public void deleteCity(@RequestParam Long id) throws CityNotFoundException {
        dbCityService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update")
    public CityDto updateCity(@RequestBody CityDto id) {
        return cityMapper.mapToCityDto(dbCityService.saveCity(cityMapper.mapToCity(id)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "saveCity", consumes = APPLICATION_JSON_VALUE)
    public void createCity(@RequestBody CityDto cityDto) {
        dbCityService.saveCity(cityMapper.mapToCity(cityDto));
    }
}
