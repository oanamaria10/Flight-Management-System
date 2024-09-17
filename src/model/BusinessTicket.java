package model;

import services.AirlineServices;
import services.AirportServices;

public class BusinessTicket extends Ticket{
    public BusinessTicket(Integer flight, Passenger passenger) {
        super(flight, passenger);
    }

    AirlineServices airlineServices = new AirlineServices();
    Airline airline = airlineServices.getAirline(flight.getId());
    @Override
    public double getTicketPrice() {
        return airline.getBusinessPrice();
    }

    @Override
    public void displayTicketDetails() {
        super.displayTicketDetails();
        System.out.println("Price:" + getTicketPrice());
        System.out.println("Class: Business");
    }
}
