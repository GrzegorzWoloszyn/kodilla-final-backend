package com.grzegorzwoloszyn.controller;

import com.grzegorzwoloszyn.domain.City;
import com.grzegorzwoloszyn.domain.CityDto;
import com.grzegorzwoloszyn.mapper.CityMapper;
import com.grzegorzwoloszyn.service.DbCityService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityMapper cityMapper;

    @MockBean
    private DbCityService dbCityService;

    @Test
    private void shouldFEtchCityList() throws Exception {
        //Given
        List<City> cities = new ArrayList<>();
        cities.add(new City(1L, "Poland", 1, 2, 3, 4, 5, 6));
        List<CityDto> cityDtos = new ArrayList<>();
        cityDtos.add(new CityDto(1L, "Germany", 20, 30, 40, 50, 60, 70));

        when(cityMapper.mapToCityDtoList(cities)).thenReturn(cityDtos);
        when(dbCityService.getAllCities()).thenReturn(cities);

        //When & Then
        mockMvc.perform(get("/v1/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Poland")));

    }
}
