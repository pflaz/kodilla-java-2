package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class FlightSearch {

    private CitiesRetriever citiesRetriever = new CitiesRetriever();
    private List<City> cityList = citiesRetriever.retrieve();

    public void showFlightsFrom(City from) {
        if (!from.isOperatingAirport()) {
            System.out.println(from.getName() + " is not operating airport");
            return;
        }
        System.out.println("Flights from " + from.getName() + " to: ");
        from.getDestinations().stream()
                .filter(City::isOperatingAirport)
                .map(city -> city.getName())
                .forEach(System.out::println);
    }

    public void showFlightsTo(City to) {
        if (!to.isOperatingAirport()) {
            System.out.println(to.getName() + " is not operating airport");
            return;
        }
        System.out.println("Flights to " + to.getName() + " from: ");
        cityList.stream()
                .filter(City::isOperatingAirport)
                .filter(city -> city.getDestinations().contains(to))
                .map(city -> city.getName())
                .forEach(System.out::println);
    }

    public void showDirectFlight(City from, City to) {
        System.out.println("Direct flight from " + from.getName() + " to: " + to.getName());
        if (from.isOperatingAirport() && to.isOperatingAirport() && from.getDestinations().contains(to)) {
            System.out.println("AVAILABLE");
        } else {
            System.out.println("UNAVAILABLE");
        }
    }

    public void showIndirectFlight(City from, City to) {
        if (!from.isOperatingAirport()) {
            System.out.println(from.getName() + " is not operating airport");
            return;
        }
        if (!to.isOperatingAirport()) {
            System.out.println(to.getName() + " is not operating airport");
            return;
        }

        System.out.println("Indirect flight from " + from.getName() + " to: " + to.getName() + " via: ");

        from.getDestinations().stream()
                .filter(City::isOperatingAirport)
                .filter(city -> city.getDestinations().contains(to))
                .map(city -> city.getName())
                .forEach(System.out::println);
    }
}