package sih.app.hotel;

import java.util.List;

public interface HotelRepositoryInterface {

    void addHotel(Hotel hotel);

    void removeHotel(Hotel hotel);

    List<Hotel> getHotels();
}
