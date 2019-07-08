package sih.app.services;

import sih.app.domain.hotel.Hotel;

import java.util.Collection;

public interface HotelServiceInterface {

    /**
     * if the hotel is null then returns a error message
     * if the hotel doesn't exists returns a error message
     * if everything is ok then it removed the hotel
     * @param hotel
     * @return a message with information regarding this operation
     */
    public String validateAndRemoveHotel(Hotel hotel);

    /**
     * @return a collection with all the hotels
     */
    public Collection<Hotel> getHotels();

    /**
     * @param name
     * @return hotel with a given name
     */
    public Hotel findByName(String name);

    /**
     * validates the hotel, if everything is ok adds the hotel
     * @param hotel
     * @return a message with information regarding this operation
     */
    public String validateAndAddHotel(Hotel hotel);
}
