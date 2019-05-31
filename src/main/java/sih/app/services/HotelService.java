package sih.app.services;

import sih.app.domain.hotel.Hotel;
import sih.app.exceptions.InvalidData;
import sih.app.repositories.HotelRepository;
import sih.app.repositories.HotelRepositoryInterface;

import java.util.List;

public class HotelService {

    HotelRepositoryInterface hotelRepository;

    public HotelService(HotelRepositoryInterface hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

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

    public List<Hotel> getHotels() {
        return hotelRepository.getHotels();
    }

    public Hotel findByName(String name) {
        return hotelRepository.findByName(name);
    }

    public String validateAndAddHotel(Hotel hotel) {
        if (hotel == null) {
            return "HOTEL IS NULL";
        }

        if (hotel.getName().length() > 20) {
            return "NAME TOO LONG";
        }

        hotelRepository.addHotel(hotel);
        return "EVERYTHING WENT WELL";
    }
}
