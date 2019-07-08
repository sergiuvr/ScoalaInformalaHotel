package sih.app.domain.hotel;

import lombok.Getter;
import sih.app.domain.HasId;

@Getter
public class Room extends HasId {

    private int number;
    private String name;
    private double price;
    private int capacity;
    private int floor;
    private String description;
    private Availability availability;

    public Room(long id, int number, String name, double price, int capacity, int floor, String description, Availability availability) {
        super(id);
        this.number = number;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.floor = floor;
        this.description = description;
        this.availability = availability;
    }

    public Room(long id, int number, double price, int capacity, int floor, String description) {
        super(id);
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.floor = floor;
        this.description = description;
    }


}
