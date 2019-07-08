package sih.app.repositories;

import sih.app.domain.hotel.Hotel;

import java.util.List;

public class HotelRepositoryMock extends HotelRepository {

    @Override
    public void add(Hotel hotel) {

    }

    @Override
    public void removeHotel(String name) {

    }

    @Override
    public List<Hotel> getAll() {
        return null;
    }

    @Override
    public Hotel findByName(String name) {
        return null;
    }
}