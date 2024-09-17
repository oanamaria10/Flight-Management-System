package services;

import config.DatabaseConfiguration;
import model.Airline;
import model.Airport;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportServices {
    public void createAirportTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS airports" + "(id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL, location VARCHAR(255) NOT NULL)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAirport(String name, String location) {

        String addAirportSql = "INSERT INTO airports (name, location) VALUES (?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(addAirportSql);
            pstmt.setString(1, name);
            pstmt.setString(2, location);
            pstmt.executeUpdate();
            System.out.println("Airport added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding airport: " + e.getMessage());
        }
    }
    public Airport getAirport(int id) {
        String getAirportSql = "SELECT * FROM airports WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(getAirportSql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Airport airport = new Airport(
                        rs.getString("name"),
                        rs.getString("location")
                );
                return airport;
            } else {
                System.out.println("Airline not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving airline: " + e.getMessage());
        }
        return null;
    }
    public List<Airport> getAirportsbyLocation(String location) {
        List<Airport> airports = new ArrayList<>();

        String getAirportbyLocationSql = "SELECT * FROM airports WHERE location = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(getAirportbyLocationSql);
            pstmt.setString(1, location);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                airports.add(new Airport(
                        rs.getString("name"),
                        rs.getString("location")
                ));
                return airports;
            } else {
                System.out.println("There are not airports in this location");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving airport: " + e.getMessage());
        }
        return null;
    }

    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();

        String getAllAirportsSql = "SELECT * FROM airports";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(getAllAirportsSql);
            while (rs.next()) {
                airports.add(new Airport(
                        rs.getString("name"),
                        rs.getString("location")
                ));
            }
            System.out.println("All airports retrieved successfully.");
        } catch (SQLException e) {
            System.out.println("Error retrieving airports: " + e.getMessage());
        }
        return airports;
    }

    public void updateAirportName(String name, int id) {
        String updateAirportNameSql = "UPDATE airports SET name = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement pstmt = connection.prepareStatement(updateAirportNameSql);
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Airport updated successfully");
            } else {
                System.out.println("Airport not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airport: " + e.getMessage());
        }
    }

    public void deleteAirport(int id) {
        String deleteAirportSql = "DELETE FROM airports WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement pstmt = connection.prepareStatement(deleteAirportSql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Airport deleted successfully");
            } else {
                System.out.println("Airport not found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting airport: " + e.getMessage());
        }
    }
}
