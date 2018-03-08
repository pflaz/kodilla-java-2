package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

public class CitiesRetriever {

    public List<City> retrieve() {
        List<City> cityList = new ArrayList<>();
        City cityWarszawa = new City("Warszawa", true);
        City cityGdansk = new City("Gdańsk", true);
        City cityWroclaw = new City("Wrocław", true);
        City cityPoznan = new City("Poznań", false);
        City cityRadom = new City("Radom", true);
        City cityKatowice = new City("Katowice", true);
        City cityKrakow = new City("Kraków", false);

        cityWarszawa.addDestination(cityGdansk);
        cityWarszawa.addDestination(cityWroclaw);
        cityWroclaw.addDestination(cityRadom);
        cityWroclaw.addDestination(cityGdansk);
        cityKatowice.addDestination(cityRadom);

        cityList.add(cityWarszawa);
        cityList.add(cityGdansk);
        cityList.add(cityWroclaw);
        cityList.add(cityPoznan);
        cityList.add(cityRadom);
        cityList.add(cityKatowice);
        cityList.add(cityKrakow);

        return cityList;
    }
}
