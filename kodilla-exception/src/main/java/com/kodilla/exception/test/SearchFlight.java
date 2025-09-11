package com.kodilla.exception.test;

import java.util.Map;

public class SearchFlight {

    /*
     * The findFlight method checks if a flight route is available based on predefined airport data.
     * It throws a RouteNotFoundException if the departure or arrival airport is not found or unavailable.
     */

    public void findFlight(Flight flight) throws RouteNotFoundException {

        final Map<String, Boolean> airports = Map.of(
            "Goleniów", true,
            "Warszawa Modlin", true,
            "Warszawa Chopin", true,
            "Radom", false,
            "Kraków", true,
            "Rzeszów", false
        );

        if (!airports.containsKey(flight.getDepartureAirport()) || !airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("One or both airports not found in the database.");
        }

        if (!airports.get((flight.getDepartureAirport()))) {
            throw new RouteNotFoundException("Departure airport " + flight.getDepartureAirport() + " is currently unavailable.");
        }

        if (!airports.get(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Arrival airport " + flight.getArrivalAirport() + " is currently unavailable.");
        }

        System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " is available.");
    }

    public static void main(String[] args) {
        SearchFlight searchFlight = new SearchFlight();

        Flight flight1 = new Flight("Goleniów", "Kraków");
        Flight flight2 = new Flight("Radom", "Warszawa Chopin");
        Flight flight3 = new Flight("Warszawa Modlin", "Goleniów");

        try {
            searchFlight.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            searchFlight.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            searchFlight.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
