package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    private final String name;
    private final boolean operatingAirport;
    private final List<City> destinations = new ArrayList<>();

    public City(final String name, final boolean operatingAirport) {
        this.name = name;
        this.operatingAirport = operatingAirport;
    }

    public String getName() {
        return name;
    }

    public boolean isOperatingAirport() {
        return operatingAirport;
    }

    public boolean addDestination(City destination) {
        return destinations.add(destination);
    }

    public boolean removeDestination(City destination) {
        return destinations.remove(destination);
    }

    public List<City> getDestinations() {
        return destinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
