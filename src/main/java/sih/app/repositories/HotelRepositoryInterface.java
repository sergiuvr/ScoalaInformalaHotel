package sih.app.repositories;

import sih.app.domain.hotel.Hotel;
import sih.app.exceptions.InvalidData;

import java.util.List;

public interface HotelRepositoryInterface {

    void addHotel(Hotel hotel);

    void removeHotel(String name);

    List<Hotel> getHotels();

    Hotel findByName(String name);
}
