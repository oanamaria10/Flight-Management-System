package model;

import services.AirlineServices;

public class EconomyTicket extends Ticket {

    public EconomyTicket(Integer flight, Passenger passenger) {
        super(flight, passenger);
    }
    AirlineServices airlineServices = new AirlineServices();
    Airline airline = airlineServices.getAirline(flight.getId());
    @Override
    public double getTicketPrice() {
        return airline.getEconomyPrice();
    }

    @Override
    public void displayTicketDetails() {
        super.displayTicketDetails();
        System.out.println("Price:" + getTicketPrice());
        System.out.println("Class: Economy");
    }
}
