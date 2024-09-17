package model;

import java.time.LocalDate;

public class Passenger {
    private Integer id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String passportNumber;

    public Passenger(String fullName, LocalDate dateOfBirth, String passportNumber) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id + '\''+
                "fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
