package com.grzegorzwoloszyn.config.client;

import com.grzegorzwoloszyn.config.CovidConfig;
import com.grzegorzwoloszyn.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CovidClientTest {

    @InjectMocks
    private CovidClient covidClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CovidConfig covidConfig;

    @Before
    public void init() {
        when(covidConfig.getCovid19ApiEndpoint()).thenReturn("http://test.com");
    }

    @Test
    public void testShouldFetchSummary() throws URISyntaxException {
        //Given
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Poland", 3, 3, 3, 3, 3, 3, "24.09.2020"));
        CovidStatDto covidStatDto = new CovidStatDto(
                new Global(3, 3, 3, 3, 3, 3),
                countries,
                "24.09.2020");
        URI uri = new URI("http://test.com/summary");

        when(restTemplate.getForObject(uri, CovidStatDto.class)).thenReturn(covidStatDto);

        //When
        CovidStatDto result = covidClient.getSummary();

        //Then
        Assert.assertEquals("24.09.2020", result.getDate());
        Assert.assertEquals(Optional.of(3), Optional.of(result.getGlobal().getNewConfirmed()));
        Assert.assertEquals("Poland", result.getCountries().get(0).getCountry());
    }

    @Test
    public void shouldFetchAllCountries() throws URISyntaxException {
        //Given
        SingleCountryDto[] singleCountryDto = new SingleCountryDto[1];
        singleCountryDto[0] = new SingleCountryDto("Poland");
        URI uri = new URI("http://test.com/countries");
        when(restTemplate.getForObject(uri, SingleCountryDto[].class)).thenReturn(singleCountryDto);

        //When
        List<SingleCountryDto> result = covidClient.getCountries();

        //Then
        Assert.assertEquals("Poland", result.get(0).getCountry());
        Assert.assertTrue(result.size() == 1);
    }

}