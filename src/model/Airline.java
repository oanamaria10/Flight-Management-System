package model;

public class Airline {
    private Integer id;
    private String name;
    private int availableEconomySeats;
    private int availableBusinessSeats;
    private double economyPrice;
    private double businessPrice;

    public Airline(String name, int availableEconomySeats, int availableBusinessSeats, double economyPrice, double businessPrice) {
        this.name = name;
        this.availableEconomySeats = availableEconomySeats;
        this.availableBusinessSeats = availableBusinessSeats;
        economyPrice = economyPrice;
        businessPrice = businessPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableEconomySeats() {
        return availableEconomySeats;
    }

    public void setAvailableEconomySeats(int availableEconomySeats) {
        this.availableEconomySeats = availableEconomySeats;
    }

    public int getAvailableBusinessSeats() {
        return availableBusinessSeats;
    }

    public void setAvailableBusinessSeats(int availableBusinessSeats) {
        this.availableBusinessSeats = availableBusinessSeats;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        businessPrice = businessPrice;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availableEconomySeats=" + availableEconomySeats +
                ", availableBusinessSeats=" + availableBusinessSeats +
                ", economyPrice=" + economyPrice +
                ", businessPrice=" + businessPrice +
                '}';
    }
}