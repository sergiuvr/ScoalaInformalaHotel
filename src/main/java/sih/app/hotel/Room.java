package sih.app.hotel;

public class Room {

    private int number;
    private double price;
    private int capacity;
    private int floor;
    private String description;
    private Availability availability;

    public Room(int number, double price, int capacity, int floor, String description, Availability availability) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.floor = floor;
        this.description = description;
        this.availability = Availability.AVAILABLE;
    }

    public Room(int number, double price, int capacity, int floor, String description) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.floor = floor;
        this.description = description;
    }
}
