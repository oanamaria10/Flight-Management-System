package model;

import services.AirlineServices;
import services.AirportServices;

import java.time.LocalDateTime;


public class Flight implements Comparable<Flight>{
    private Integer id;
    private int departureAirportId;
    private int arrivalAirportId;
    private int airlineId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(int departureAirport, int arrivalAirport, int airline, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.departureAirportId = departureAirport;
        this.arrivalAirportId = arrivalAirport;
        this.airlineId = airline;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDepartureAirport() {
        return departureAirportId;
    }

    public void setDepartureAirport(int departureAirport) {
        this.departureAirportId = departureAirport;
    }

    public int getArrivalAirport() {
        return arrivalAirportId;
    }

    public void setArrivalAirport(int arrivalAirport) {
        this.arrivalAirportId = arrivalAirport;
    }

    public int getAirline() {
        return airlineId;
    }

    public void setAirline(int airline) {
        this.airlineId = airline;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    AirportServices airportServices = new AirportServices();
    Airport departureAirport = airportServices.getAirport(departureAirportId);
    Airport arrivalAirport = airportServices.getAirport(arrivalAirportId);

    AirlineServices airlineServices = new AirlineServices();
    Airline airline = airlineServices.getAirline(airlineId);
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureAirport=" + departureAirport.getLocation() +
                ", arrivalAirport=" + arrivalAirport.getLocation() +
                ", airline=" + airlineId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public int compareTo(Flight otherFlight) {
        // Compare flights based on economy price
        Airline airlineOther = airlineServices.getAirline(otherFlight.airlineId);
        return Double.compare(this.airline.getEconomyPrice(), airlineOther.getEconomyPrice());
    }
}
