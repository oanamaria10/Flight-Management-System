package services;

import config.DatabaseConfiguration;
import model.Airline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineServices {

    public void createAirlineTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS airlines" + "(id INT AUTO_INCREMENT PRIMARY KEY," +
                                "name VARCHAR(255) NOT NULL, availableEconomySeats INT NOT NULL," +
                                "availableBusinessSeats INT NOT NULL, economyPrice DOUBLE NOT NULL," +
                                "businessPrice DOUBLE NOT NULL)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAirline(String name, int availableEconomySeats, int availableBusinessSeats, double economyPrice, double businessPrice) {
        String addAirlineSql = "INSERT INTO airlines (name, availableEconomySeats, availableBusinessSeats, economyPrice, businessPrice) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(addAirlineSql);
            pstmt.setString(1, name);
            pstmt.setInt(2, availableEconomySeats);
            pstmt.setInt(3, availableBusinessSeats);
            pstmt.setDouble(4, economyPrice);
            pstmt.setDouble(5, businessPrice);
            pstmt.executeUpdate();
            System.out.println("Airline added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding airline: " + e.getMessage());
        }
    }

    public Airline getAirline(int id) {
        String getAirlineSql = "SELECT * FROM airlines WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(getAirlineSql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Airline airline = new Airline(
                        rs.getString("name"),
                        rs.getInt("availableEconomySeats"),
                        rs.getInt("availableBusinessSeats"),
                        rs.getDouble("economyPrice"),
                        rs.getDouble("businessPrice")
                );
                return airline;
            } else {
                System.out.println("Airline not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving airline: " + e.getMessage());
        }
        return null;
    }

    public Airline getAirlineByName(String name) {
        String getAirlineByNameSql = "SELECT * FROM airlines WHERE name = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(getAirlineByNameSql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Airline airline = new Airline(
                        rs.getString("name"),
                        rs.getInt("availableEconomySeats"),
                        rs.getInt("availableBusinessSeats"),
                        rs.getDouble("economyPrice"),
                        rs.getDouble("businessPrice")
                );
                return airline;
            } else {
                System.out.println("Airline not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving airline: " + e.getMessage());
        }
        return null;
    }

    public List<Airline> getAllAirlines() {
        List<Airline> airlines = new ArrayList<>();

        String getAllAirlinesSql = "SELECT * FROM airlines";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(getAllAirlinesSql);
            while (rs.next()) {
                airlines.add(new Airline(
                        rs.getString("name"),
                        rs.getInt("availableEconomySeats"),
                        rs.getInt("availableBusinessSeats"),
                        rs.getDouble("economyPrice"),
                        rs.getDouble("businessPrice")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving airlines: " + e.getMessage());
        }
        return airlines;
    }


    public void updateEconomySeats(int availableEconomySeats, int id) {

        String updateEconomySeatsSql = "UPDATE airlines SET availableEconomySeats = ? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updateEconomySeatsSql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, availableEconomySeats);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Economy seats updated successfully");
            } else {
                System.out.println("Airline not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airline: " + e.getMessage());
        }
    }

    public void updateBusinessSeats(int availableBusinessSeats, int id) {

        String updateBusinessSeatsSql = "UPDATE airlines SET availableBusinessSeats = ? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updateBusinessSeatsSql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, availableBusinessSeats);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Business seats updated successfully");
            } else {
                System.out.println("Airline not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airline: " + e.getMessage());
        }
    }

    public void updateEconomyPrice(double economyPrice, int id) {

        String updateEconomyPriceSql = "UPDATE airlines SET economyPrice = ? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updateEconomyPriceSql);
            pstmt.setInt(1, id);
            pstmt.setDouble(2, economyPrice);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Economy price updated successfully");
            } else {
                System.out.println("Airline not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airline: " + e.getMessage());
        }
    }

    public void updateBusinessPrice(double businessPrice, int id) {

        String updateBusinessPriceSql = "UPDATE airlines SET businessPrice = ? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updateBusinessPriceSql);
            pstmt.setInt(1, id);
            pstmt.setDouble(2, businessPrice);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Business price updated successfully");
            } else {
                System.out.println("Airline not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating airline: " + e.getMessage());
        }
    }

    public void deleteAirline(int id) {

        String deleteAirlineSql = "DELETE FROM airlines WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(deleteAirlineSql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Airline deleted successfully");
            } else {
                System.out.println("Airline not found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting airline: " + e.getMessage());
        }
    }
}
