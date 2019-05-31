package sih.app.repositories;

import sih.app.domain.hotel.Hotel;

import java.util.List;

public class HotelRepositoryMock extends HotelRepository {

    @Override
    public void addHotel(Hotel hotel) {

    }

    @Override
    public void removeHotel(String name) {

    }

    @Override
    public List<Hotel> getHotels() {
        return null;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }
}