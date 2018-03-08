package com.kodilla.exception.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Beijing", true);
        airports.put("Berlin", true);
        airports.put("Bucharest", false);
        airports.put("Buenos Aires", true);
        airports.put("Chicago", false);

        if (airports.containsKey(flight.getArrivalAirport()) && airports.containsKey(flight.getDepartureAirport())) {
            return airports.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException();
        }
    }
}
