package sih.app.hotel;

import sih.app.people.Person;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private String address;
    private List<Room> rooms;
    private List<Person> employees;
    private Person owner;

    public Hotel(String name, String address, Person owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<Room>();
        this.employees = new ArrayList<Person>();
    }

    public Hotel(String name, String address, List<Room> rooms, List<Person> employees, Person owner) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.employees = employees;
        this.owner = owner;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "Hotel: "+ name + ", " + address;
    }
}
