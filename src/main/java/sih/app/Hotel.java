package sih.app;

import java.util.List;

public class Hotel {

    private String name;
    private String address;
    private List<Room> rooms;
    private List<Person> employees;
    private Person owner;

    public Hotel() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
