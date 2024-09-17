package services;

import config.DatabaseConfiguration;
import model.Passenger;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PassengerServices {
    public void createPassengerTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS passengers" + "id INT AUTO_INCREMENT PRIMARY KEY" +
                "fullName VARCHAR(255) NOT NULL" +
                "dateOfBirth DATE NOT NULL," +
                "passportNumber VARCHAR(255) NOT NULL)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPassenger(String fullName, LocalDate dateOfBirth, String passportNumber) {
        String addPassengerSql = "INSERT INTO passengers (fullName, dateOfBirth, passportNumber) VALUES (?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(addPassengerSql);
            pstmt.setString(1, fullName);
            pstmt.setDate(2, Date.valueOf(dateOfBirth));
            pstmt.setString(3, passportNumber);
            pstmt.executeUpdate();
            System.out.println("Passenger added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding passenger");
        }
    }

    public Passenger getPassenger(int id) {
        String getPassengerSql = "SELECT * FROM passengers WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(getPassengerSql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Passenger passenger = new Passenger(
                        rs.getString("fullName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("passportNumber")
                );
                return passenger;
            } else {
                System.out.println("Passenger not found");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving passenger: " + e.getMessage());
        }
        return null;
    }

    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();

        String getAllPassengersSql = "SELECT * FROM passengers";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(getAllPassengersSql);
            while (rs.next()) {
                passengers.add(new Passenger(
                        rs.getString("fullName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("passportNumber")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving passengers: " + e.getMessage());
        }
        return passengers;
    }

    public void updatePassengerName(String name, int id) {
        String updatePassengerNameSql = "UPDATE passengers SET fullName = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updatePassengerNameSql);
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Passenger updated successfully");
            } else {
                System.out.println("Passenger not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating passenger: " + e.getMessage());
        }
    }

    public void updatePassengerPassport(String passportNumber, int id) {
        String updatePassengerPassportSql = "UPDATE passengers SET passportNumber = ? WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement pstmt = connection.prepareStatement(updatePassengerPassportSql);
            pstmt.setString(1, passportNumber);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Passenger updated successfully");
            } else {
                System.out.println("Passenger not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating passenger: " + e.getMessage());
        }
    }

    public void deletePassenger(int id) {
        String deletePassengerSql = "DELETE FROM passengers WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(deletePassengerSql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Passenger deleted successfully");
            } else {
                System.out.println("Passenger not found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting passenger: " + e.getMessage());
        }
    }
}
