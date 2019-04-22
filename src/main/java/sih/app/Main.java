package sih.app;

import sih.app.hotel.Hotel;
import sih.app.hotel.HotelRepository;
import sih.app.hotel.HotelRepositoryInterface;
import sih.app.people.Owner;
import sih.app.people.Person;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        System.out.println(owner);

        Hotel hotel1 = new Hotel("Continental", "adresa", owner);
        Hotel hotel2 = new Hotel("Belvedere", "sus", owner);
        System.out.println(hotel1);
        System.out.println(hotel2);

        HotelRepositoryInterface hotelRepository = new HotelRepository();

        //add
        hotelRepository.addHotel(hotel1);
        hotelRepository.addHotel(hotel2);

        //list
        List<Hotel> hotels = hotelRepository.getHotels();

        //remove
        hotelRepository.removeHotel(hotel1);

    }
}
