package services;

import model.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Passenger Client;

    public Passenger getClient() {
        return Client;
    }

    public void setClient(Passenger client) {
        Client = client;
    }

    private final List<Ticket> reservedTickets;
    private double totalCost;
    private boolean isConfirmed;
    public Reservation(Passenger Client) {
        this.Client = Client;
        reservedTickets = new ArrayList<>();
        totalCost = 0;
        isConfirmed = false;
    }
    AirlineServices airlineServices = new AirlineServices();
    AirportServices airportServices = new AirportServices();
    public void addTicket(Ticket ticket) {
        if (ticket instanceof BusinessTicket) {
            Flight flight = flightServices.getFlightById(ticket.getFlight());
            Airline airline = airlineServices.getAirline(flight.getId());
            Airport airport = airportServices.getAirport(flight.getId());
            if (airline.getAvailableBusinessSeats() > 0) {
                reservedTickets.add(ticket);
                totalCost += airline.getBusinessPrice();
                System.out.println("Business Ticket reserved successfully for " + ticket.getPassenger().getFullName());
            } else {
                System.out.println("Unfortunately, there are no more business seats available for the flight to " + airport.getLocation());
            }
        } else if (ticket instanceof EconomyTicket) {
            Flight flight = flightServices.getFlightById(ticket.getFlight());
            Airline airline = airlineServices.getAirline(flight.getId());
            Airport airport = airportServices.getAirport(flight.getId());
            if (airline.getAvailableEconomySeats() > 0) {
                reservedTickets.add(ticket);
                totalCost += airline.getEconomyPrice();
                System.out.println("Economy Ticket reserved successfully for " + ticket.getPassenger().getFullName());
            } else {
                System.out.println("Unfortunately, there are no more economy seats available for the flight to " + airport.getLocation());
            }
        }
    }

    public void removeTicket(Ticket ticket) {
        if (reservedTickets.contains(ticket)) {
            reservedTickets.remove(ticket);
            totalCost -= ticket.getTicketPrice();
            System.out.println("Ticket removed successfully.");
        } else {
            System.out.println("Ticket not found in the reservation.");
        }
    }
    public void cancelReservation() {
        if(isConfirmed) {
            for (Ticket ticket : reservedTickets) {
                if (ticket instanceof BusinessTicket) {
                    Flight flight = flightServices.getFlightById(ticket.getFlight());
                    Airline airline = airlineServices.getAirline(flight.getId());
                    airline.setAvailableBusinessSeats(airline.getAvailableBusinessSeats() + 1);
                } else if (ticket instanceof EconomyTicket) {
                    Flight flight = flightServices.getFlightById(ticket.getFlight());
                    Airline airline = airlineServices.getAirline(flight.getId());
                    airline.setAvailableEconomySeats(airline.getAvailableEconomySeats() + 1);
                }
            }
            reservedTickets.clear();
            totalCost = 0;
            isConfirmed = false;
            System.out.println("Reservation canceled successfully.");
        }
        else{
            System.out.println("The reservation is not confirmed.");
        }
    }
    FlightServices flightServices = new FlightServices();
    public void confirmReservation(){
        isConfirmed = true;
        for (Ticket ticket : reservedTickets) {
            if (ticket instanceof BusinessTicket) {
                Flight flight = flightServices.getFlightById(ticket.getFlight());
                Airline airline = airlineServices.getAirline(flight.getId());
                airline.setAvailableBusinessSeats(airline.getAvailableBusinessSeats() - 1);
            } else if (ticket instanceof EconomyTicket) {
                Flight flight = flightServices.getFlightById(ticket.getFlight());
                Airline airline = airlineServices.getAirline(flight.getId());
                airline.setAvailableEconomySeats(airline.getAvailableEconomySeats() - 1);
            }
        }
    }
    public void upgradeTicket(Ticket economyTicket) {
        Flight flight = flightServices.getFlightById(economyTicket.getFlight());
        Airline airline = airlineServices.getAirline(flight.getId());
        if(economyTicket instanceof EconomyTicket) {
            if (airline.getAvailableBusinessSeats() > 0) {
                Passenger passenger = economyTicket.getPassenger();
                BusinessTicket businessTicket = new BusinessTicket(flight.getId(), passenger);
                reservedTickets.remove(economyTicket);
                reservedTickets.add(businessTicket);
                totalCost += airline.getBusinessPrice() - airline.getEconomyPrice();
                airline.setAvailableEconomySeats(airline.getAvailableEconomySeats() + 1);
                airline.setAvailableBusinessSeats(airline.getAvailableBusinessSeats() - 1);
                System.out.println("Ticket upgraded to Business class successfully for " + passenger.getFullName());
            } else {
                System.out.println("Unfortunately, there are no seats available for Business class.");
            }
        }
        else{
            System.out.println("You can't upgrade a Business ticket.");
        }
    }

    public void displayReservationDetails() {
        System.out.println("Reservation Details:");
        for (Ticket ticket : reservedTickets) {
            ticket.displayTicketDetails();
        }
        System.out.println("Total Cost: " + totalCost);
    }
}
