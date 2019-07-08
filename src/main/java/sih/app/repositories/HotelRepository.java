package sih.app.repositories;

import sih.app.domain.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelRepository implements HotelRepositoryInterface {

    List<Hotel> hotels = new ArrayList<Hotel>();

    public HotelRepository() {
    }

    @Override
    public void add(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override
    public void removeHotel(String name) {
        Hotel hotel = findByName(name);
        hotels.remove(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotels;
    }

    @Override
    public Hotel findByName(String name) {
        Optional<Hotel> hotel = hotels.stream().filter(el -> el.getName().equals(name)).findFirst();
        if(hotel.isPresent()){
            return hotel.get();
        }else {
            return null;
        }
    }
}
