package model;


public class Airport {
    private Integer id;
    private String name;
    private String location;

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id = " + id + '\'' +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
