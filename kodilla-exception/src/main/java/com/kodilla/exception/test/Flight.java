package com.kodilla.exception.test;

/*
    Flight class represents a flight with departure and arrival airports.
    It includes a constructor to initialize these fields and getter methods to access them.
*/

public class Flight {

    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
