package model;

import services.AirportServices;
import services.FlightServices;

import java.sql.SQLOutput;
import java.util.List;

public abstract class Ticket {
    protected Integer flightId;
    protected Passenger passenger;
    public Ticket(Integer flight, Passenger passenger) {
        this.flightId = flight;
        this.passenger = passenger;
    }

    public abstract double getTicketPrice();

    public Integer getFlight() {
        return flightId;
    }

    public void setFlight(Integer flight) {
        this.flightId = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    AirportServices airportServices= new AirportServices();
    Airport airport = airportServices.getAirport(flightId);
    FlightServices flightServices = new FlightServices();
    Flight flight = flightServices.getFlightById(flightId);
    public void displayTicketDetails() {
        System.out.println("Passenger: " + passenger.getFullName());
        System.out.println("Destination: " + airport.getLocation());
        System.out.println("Departure time: " + flight.getDepartureTime());
        System.out.println("Arrival time: " + flight.getArrivalTime());
    }
}
