package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.NoSuchElementException;

public class CityObjectGetter {
    public City get(String cityName) throws CityObjectGetterException {
        CitiesRetriever citiesRetriever = new CitiesRetriever();
        List<City> cityList = citiesRetriever.retrieve();
        try {
            return cityList.stream()
                    .filter(city -> city.getName().equals(cityName))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            throw new CityObjectGetterException();
        }
    }



}
