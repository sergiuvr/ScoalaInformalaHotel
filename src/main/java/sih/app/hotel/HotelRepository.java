package sih.app.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements HotelRepositoryInterface {
    List<Hotel> hotels = new ArrayList<Hotel>();

    public HotelRepository() {}

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
}
