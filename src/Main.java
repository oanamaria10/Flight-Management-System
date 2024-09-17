import model.*;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            Menu instance = new Menu();
            instance.interact();
//        Airport OTP = new Airport("Henri Coanda International Airport", "Bucharest, Romania");
//        Airport MXP = new Airport("Milan Malpensa Airport", "Milano, Italy");
//        Airport BCM = new Airport("George Enescu National Airport", "Bacau, Romania");
//
//        Airline wizzAir = new Airline("WizzAir", 120, 30, 200.0, 500.0);
//        Airline ryanair = new Airline("Ryanair", 100, 20, 180.0, 400.0);
//
//        LocalDateTime departureTime = LocalDateTime.of(2024, 5, 2, 8, 0);
//        LocalDateTime arrivalTime = departureTime.plusHours(2);
//        Flight flight1 = new Flight(OTP, MXP, wizzAir, departureTime, arrivalTime, "N1");
//
//        LocalDateTime departureTime2 = LocalDateTime.of(2024, 5, 9, 7, 0 );
//        LocalDateTime arrivalTime2 = departureTime2.plusHours(3);
//        Flight flight2 = new Flight(MXP, BCM, wizzAir, departureTime2, arrivalTime2, "N2");
//
//        LocalDateTime departureTime3 = LocalDateTime.of(2024, 5, 9, 19, 0 );
//        LocalDateTime arrivalTime3 = departureTime3.plusHours(3);
//        Flight flight3 = new Flight(MXP, OTP, ryanair, departureTime3, arrivalTime3, "N3");
//
//        Passenger passenger1 = new Passenger("Anastasia Ionescu", LocalDate.of(2001, 10, 9), "SP1234567");
//        Passenger passenger2 = new Passenger("Cristian Popescu", LocalDate.of(1998, 5, 10), "SP9876543");
//        Passenger passenger3 = new Passenger("Miriam Stoica", LocalDate.of(1987, 5, 10), "SP5678398");
//
//        Ticket ticket1 = new EconomyTicket(flight1, passenger1);
//        Ticket ticket2 = new BusinessTicket(flight1, passenger2);
//        Ticket ticket3 = new EconomyTicket(flight3,passenger3);
//        //Reservation service
//        Reservation reservation = new Reservation();
//
//        //add ticket
//        reservation.addTicket(ticket1);
//        reservation.addTicket(ticket2);
//
//        //display reservation
//        reservation.displayReservationDetails();
//
//        //upgrade EconomyTicket
//        reservation.upgradeTicket(ticket1);
//
//        //remove ticket
//        reservation.removeTicket(ticket2);
//
//        //confirm reservation
//        reservation.confirmReservation();
//
//        //cancel reservation
//        reservation.cancelReservation();
//
//        Reservation reservation2 = new Reservation();
//        reservation2.addTicket(ticket3);
//        reservation2.confirmReservation();
//        reservation2.displayReservationDetails();
//
//        //Flight services
//        FlightServices flightServices = new FlightServices();
//        flightServices.addFlight(flight1);
//        flightServices.addFlight(flight2);
//        flightServices.addFlight(flight3);
//
//        //getting all flights
//        List<Flight> allflights = flightServices.getFlights();
//        System.out.println("All flights:");
//        for (Flight f : allflights) {
//            System.out.println(f);
//        }
//
//        //getting flights by departure location
//        List<Flight> flightsByDepartureLocation = flightServices.getFlightsByDepartureLocation("Romania");
//        System.out.println("Flights from Bucharest:");
//        for (Flight f : flightsByDepartureLocation) {
//            System.out.println(f);
//        }
//
//        //getting flights by arrival location
//        List<Flight> flightsByArrivalLocation = flightServices.getFlightsByArrivalLocation("Italy");
//        System.out.println("Flights to Milano:");
//        for (Flight f : flightsByArrivalLocation) {
//            System.out.println(f);
//        }
//
//        //getting flights by airline
//        List<Flight> flightsByAirline = flightServices.getFlightsByAirline(wizzAir);
//        System.out.println("Flights of WizzAir: ");
//        for (Flight f : flightsByAirline) {
//            System.out.println(f);
//        }
//
//        //getting flights by location
//        List<Flight> flightsByLocation = flightServices.getFlightsByLocation("Milano", "Bacau");
//        System.out.println("Flights from Milano to Bacau:");
//        for (Flight f : flightsByLocation) {
//            System.out.println(f);
//        }
//
//        //getting flights by location and date time
//        LocalDate date = LocalDate.of(2024, 5, 2);
//        List<Flight> flightsByLocationAndDateTime = flightServices.getFlightsByLocationAndDateTime("Bucharest", "Milano", date);
//        System.out.println("Flights from Bucharest to Milano on 2nd of May:");
//        for (Flight f : flightsByLocationAndDateTime) {
//            System.out.println(f);
//        }
//
//        LocalDate date2 = LocalDate.of(2024, 5, 9);
//        List<Flight> flightsByDateTime = flightServices.getFlightsByDateTime(date2);
//        System.out.println("Flights on 9th of May:");
//        for (Flight f : flightsByDateTime) {
//            System.out.println(f);
//        }
//
//        //remove flight
//        flightServices.removeFlight(flight1);
//        System.out.println("All Flights:");
//
//        for (Flight f : flightServices.getFlights()) {
//            System.out.println(f);
//        }
    }
}
