package sih.app;

public class Room {

    private Integer number;
    private Double price;
    private Integer capacity;
    private Integer floor;
    private String description;

    public Room(Integer number, Double price, Integer capacity, Integer floor, String description) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.floor = floor;
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
