package sih.app.domain.hotel;

import sih.app.domain.people.Person;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private String address;
    private List<Room> rooms;
    private List<Person> employees;
    private String description;
    private Person owner;

    public Hotel(String name, String address, Person owner, String description) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<Room>();
        this.employees = new ArrayList<Person>();
        this.description = description;
    }

    public Hotel(String name, String address, List<Room> rooms, List<Person> employees, Person owner) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.employees = employees;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Person employee) {
        employees.add(employee);
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

    public List<Person> getAllEmployees(){
        return employees;
    }

    @Override
    public String toString() {
        return "Hotel " + name + " from " + address + " with description " + description + " has " + rooms.size() + " rooms and " + employees.size() + " empolyees";
    }
}
