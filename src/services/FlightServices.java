package services;

import config.DatabaseConfiguration;
import model.Airline;
import model.Airport;
import model.Flight;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightServices {
    private final Map<Integer, Flight> flights;

    public FlightServices() {
        this.flights = new HashMap<>();
    }
    public void createFlightTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS flights" + "(id INT AUTO_INCREMENT PRIMARY KEY," +
                "departureAirportId INT NOT NULL," +
                "arrivalAirportId INT NOT NULL," +
                "airlineId INT NOT NULL," +
                "departureTime DATETIME NOT NULL," +
                "arrivalTime DATETIME NOT NULL)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addFlight(int departureAirportId, int arrivalAirportId, int airlineId, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        String addFlightSql = "INSERT INTO flights (departureAirportId, arrivalAirportId, airlineId, departureTime, arrivalTime) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(addFlightSql);
            pstmt.setInt(1, departureAirportId);
            pstmt.setInt(2, arrivalAirportId);
            pstmt.setInt(3, airlineId);
            pstmt.setTimestamp(4, Timestamp.valueOf(departureTime));
            pstmt.setTimestamp(4, Timestamp.valueOf(arrivalTime));
            pstmt.executeUpdate();
            Flight flight = new Flight(departureAirportId, arrivalAirportId, airlineId, departureTime,arrivalTime);
            flights.put(flight.getId(), flight);
            System.out.println("Flight added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding flight: " + e.getMessage());
        }
    }

    public void removeFlight(int id) {
        String removeFlightSql = "DELETE FROM flights WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(removeFlightSql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            flights.remove(id);
            if (rowsDeleted > 0) {
                System.out.println("Flight removed successfully");
            } else {
                System.out.println("Flight not found");
            }
        } catch (SQLException e) {
            System.out.println("Error removing flight: " + e.getMessage());
        }
    }

    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        String getFlightsSql = "SELECT * FROM flights";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(getFlightsSql);
            while (rs.next()) {
                Flight flight = new Flight(
                        rs.getInt("departureAirport"),
                        rs.getInt("arrivalAirport"),
                        rs.getInt("airline"),
                        rs.getTimestamp("departureTime").toLocalDateTime(),
                        rs.getTimestamp("arrivalTime").toLocalDateTime()
                );
                flights.add(flight);
            }
            System.out.println("All flights retrieved successfully.");
        } catch (SQLException e) {
            System.out.println("Error retrieving flights: " + e.getMessage());
        }
        return flights;
    }

    public void updateFlightDepartureTime(LocalDateTime departureTime, int id) {
        String updateFlightDepartureTimeSql = "UPDATE airports SET departureTime = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement pstmt = connection.prepareStatement(updateFlightDepartureTimeSql);
            pstmt.setTimestamp(1, Timestamp.valueOf(departureTime));
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Departure time updated successfully");
            } else {
                System.out.println("Flight not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airport: " + e.getMessage());
        }
    }

    public void updateFlightArrivalTime(LocalDateTime arrivalTime, int id) {
        String updateFlightArrivalTimeSql = "UPDATE airports SET arrivalTime = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement pstmt = connection.prepareStatement(updateFlightArrivalTimeSql);
            pstmt.setTimestamp(1, Timestamp.valueOf(arrivalTime));
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Arrival time updated successfully");
            } else {
                System.out.println("Flight not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airport: " + e.getMessage());
        }
    }
    AirportServices airportServices = new AirportServices();
    public Flight getFlightById(Integer id) {
        for (Flight flight : flights.values()) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }
    public List<Flight> getFlightsByDepartureLocation(String departureLocation) {
        List<Flight> flightsByDepartureLocation = new ArrayList<>();
        for (Flight flight : flights.values()) {
            Airport departureAirport = airportServices.getAirport(flight.getDepartureAirport());
            if (departureAirport.getLocation().contains(departureLocation)) {
                flightsByDepartureLocation.add(flight);
            }
        }
        return flightsByDepartureLocation;
    }

    public List<Flight> getFlightsByArrivalLocation(String arrivalLocation) {
        List<Flight> flightsByArrivalLocation = new ArrayList<>();
        for (Flight flight : flights.values()) {
            Airport arrivalAirport = airportServices.getAirport(flight.getArrivalAirport());
            if (arrivalAirport.getLocation().contains(arrivalLocation)) {
                flightsByArrivalLocation.add(flight);
            }
        }
        return flightsByArrivalLocation;
    }

    public List<Flight> getFlightsByLocation(String departureLocation, String arrivalLocation) {
        List<Flight> flightsByLocation = new ArrayList<>();
        for (Flight flight : flights.values()) {
            Airport departureAirport = airportServices.getAirport(flight.getDepartureAirport());
            Airport arrivalAirport = airportServices.getAirport(flight.getArrivalAirport());
            if (departureAirport.getLocation().contains(departureLocation) && arrivalAirport.getLocation().contains(arrivalLocation)) {
                flightsByLocation.add(flight);
            }
        }
        return flightsByLocation;
    }

    public List<Flight> getFlightsByLocationAndDateTime(String departureLocation, String arrivalLocation, LocalDate date) {
        List<Flight> flightsByLocationAndDateTime = new ArrayList<>();
        for (Flight flight : flights.values()) {
            LocalDate departureDate = flight.getDepartureTime().toLocalDate();
            Airport departureAirport = airportServices.getAirport(flight.getDepartureAirport());
            Airport arrivalAirport = airportServices.getAirport(flight.getArrivalAirport());
            if (departureAirport.getLocation().contains(departureLocation) && arrivalAirport.getLocation().contains(arrivalLocation) && departureDate.equals(date)) {
                flightsByLocationAndDateTime.add(flight);
            }
        }
        return flightsByLocationAndDateTime;
    }

    public List<Flight> getFlightsByDateTime(LocalDate date) {
        List<Flight> flightsByDateTime = new ArrayList<>();
        for (Flight flight : flights.values()) {
            LocalDate departureDate = flight.getDepartureTime().toLocalDate();
            if (departureDate.equals(date)) {
                flightsByDateTime.add(flight);
            }
        }
        return flightsByDateTime;
    }

}
