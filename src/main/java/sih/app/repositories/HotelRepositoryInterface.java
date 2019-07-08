package sih.app.repositories;

import sih.app.domain.hotel.Hotel;

public interface HotelRepositoryInterface  extends RepositoryInterface<Hotel> {

    /**
     * removes the hotel with a given name
     * @param name
     */
    void removeHotel(String name);

    /**
     * find the hotel with a given name
     * @param name
     * @return hotel with the given name
     */
    Hotel findByName(String name);
}
