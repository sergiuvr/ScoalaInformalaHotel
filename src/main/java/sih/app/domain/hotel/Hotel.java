package sih.app.domain.hotel;

import lombok.Getter;
import sih.app.domain.HasId;
import sih.app.domain.Order;
import sih.app.domain.people.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Hotel extends HasId {

    private String name;
    private String address;
    private List<Room> rooms;
    private List<Person> employees;
    private String description;
    private Person owner;

    public Hotel(long id, String name, String address, Person owner, String description) {
        super(id);
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.description = description;
    }

    public Hotel(long id, String name, String address, List<Room> rooms, List<Person> employees, Person owner) {
        super(id);
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.employees = employees;
        this.owner = owner;
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

    public void sortRoomsByName(Order order) {
        if (Order.ASC.equals(order))
            rooms = rooms.stream().sorted(Comparator.comparing(Room::getName)).collect(Collectors.toList());
        else if (Order.DESC.equals(order)) {
            rooms = rooms.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public List<Person> getAllEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Hotel " + name + " from " + address + " with description " + description + " has " + rooms.size() + " rooms and " + employees.size() + " employees";
    }
}
