package sih.app;

import sih.app.domain.hotel.*;
import sih.app.domain.people.Employee;
import sih.app.domain.people.Owner;
import sih.app.domain.people.Person;
import sih.app.repositories.HotelRepository;
import sih.app.repositories.HotelRepositoryInterface;
import sih.app.services.HotelService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        System.out.println(owner);

        Hotel hotel1 = new Hotel("Continental", "adresa", owner, "descriere hotel");

        Person employee1 = new Employee("1", "Cosmin", "Pop", 22, 2300L);
        Person employee2 = new Employee("2", "Mihaela", "Cosma", 30, 21121L);
        hotel1.addEmployee(employee1);
        hotel1.addEmployee(employee2);

        Room room1 = new Room(12, 1000L, 2, 1, "descriere", Availability.AVAILABLE);
        Room room2 = new Room(32, 20L, 1, 2, "descriere", Availability.AVAILABLE);
        Room room3 = new Room(22, 100L, 2, 1, "descriere", Availability.NOT_AVAILABLE);
        hotel1.addRoom(room1);
        hotel1.addRoom(room2);
        hotel1.addRoom(room3);

        Hotel hotel2 = new Hotel("Belvedere", "sus", owner, "descriere hotel");

        Person employee12 = new Employee("3", "Mircea", "Pavel", 65, 33300L);
        Person employee22 = new Employee("2", "Cristi", "Macovei", 32, 211L);
        hotel2.addEmployee(employee12);
        hotel2.addEmployee(employee22);

        Room room12 = new Room(1, 120L, 2, 3, "descriere", Availability.NOT_AVAILABLE);
        Room room22 = new Room(2, 2220L, 4, 3, "descriere", Availability.AVAILABLE);
        Room room32 = new Room(3, 500L, 1, 3, "descriere", Availability.NOT_AVAILABLE);
        hotel2.addRoom(room12);
        hotel2.addRoom(room22);
        hotel2.addRoom(room32);

        System.out.println(hotel1);
        System.out.println(hotel2);

        HotelRepositoryInterface hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        //add
        hotelService.validateAndAddHotel(hotel1);
        hotelService.validateAndAddHotel(hotel2);

        //list
        List<Hotel> hotels = hotelService.getHotels();

        // give me the information about Hotel with the name X
        Hotel hotelByName = hotelService.findByName("Belvedere");
        System.out.println(hotelByName.toString());

        //give me information about Employee Z
        for (Person employee : hotelByName.getAllEmployees()) {
            System.out.println(employee.toString() + " works for hotel " + hotelByName.getName());
        }

        //remove
        hotelService.validateAndRemoveHotel(hotel1);

    }
}
