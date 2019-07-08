package sih.app.services;

import sih.app.domain.hotel.Hotel;
import sih.app.repositories.HotelRepositoryInterface;

import java.util.Collection;

public class HotelService implements HotelServiceInterface {

    HotelRepositoryInterface hotelRepository;

    public HotelService(HotelRepositoryInterface hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public String validateAndRemoveHotel(Hotel hotel) {
        if(hotel == null){
            return "HOTEL IS NULL";
        }

        if(hotelRepository.findByName(hotel.getName()) == null){
            return "HOTEL DOES NOT EXIST";
        }

        hotelRepository.removeHotel(hotel.getName());
        return "EVERYTHING WENT WELL";
    }

    @Override
    public Collection<Hotel> getHotels() {
        return hotelRepository.getAll();
    }

    @Override
    public Hotel findByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public String validateAndAddHotel(Hotel hotel) {
        if (hotel == null) {
            return "HOTEL IS NULL";
        }

        if (hotel.getName().length() > 20) {
            return "NAME TOO LONG";
        }

        hotelRepository.add(hotel);
        return "EVERYTHING WENT WELL";
    }

}
