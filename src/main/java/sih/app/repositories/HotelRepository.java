package sih.app.repositories;

import sih.app.domain.hotel.Hotel;
import sih.app.exceptions.InvalidData;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements HotelRepositoryInterface {
    List<Hotel> hotels = new ArrayList<Hotel>();

    public HotelRepository() {
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void removeHotel(String name) {
        Hotel hotel = findByName(name);
        hotels.remove(hotel);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public Hotel findByName(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }

        return null;
    }
}
