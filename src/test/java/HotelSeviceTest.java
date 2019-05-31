import lombok.ToString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sih.app.domain.hotel.Hotel;
import sih.app.domain.people.Owner;
import sih.app.domain.people.Person;
import sih.app.repositories.HotelRepository;
import sih.app.services.HotelService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelSeviceTest {

    @Mock
    private HotelRepository hotelRepository;

    private HotelService hotelService;

    @Before // BeforeEach in JUnit 5
    public void setup() {
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void should_ValidateAndAddHotel_ForValidData() {

        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("Continental", "adresa", owner, "descriere hotel");

        //GIVEN
        doNothing().when(hotelRepository).addHotel(null);
        doNothing().when(hotelRepository).addHotel(any(Hotel.class));

        // WHEN
        String response = hotelService.validateAndAddHotel(hotel);

        // THEN
        assertEquals("EVERYTHING WENT WELL", response);
        verify(hotelRepository, times(1)).addHotel(hotel);
    }

    @Test
    public void should_ValidateAndAddHotel_ForInvalidData() {

        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("hjoiehwfeofiheihfweifewfwefw", "adresa", owner, "descriere hotel");

        //GIVEN
        doNothing().when(hotelRepository).addHotel(null);
        doNothing().when(hotelRepository).addHotel(any(Hotel.class));

        // WHEN
        String response = hotelService.validateAndAddHotel(hotel);
        // THEN
        assertEquals("NAME TOO LONG", response);


        // WHEN
        response = hotelService.validateAndAddHotel(null);
        // THEN
        assertEquals("HOTEL IS NULL", response);
    }

    @Test
    public void should_ValidateAndRemoveHotel_ForInvalidData() {
        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("hotel", "adresa", owner, "descriere hotel");

        //GIVEN
        doNothing().when(hotelRepository).removeHotel(any(String.class));
        doReturn(hotel).when(hotelRepository).findByName("hotel");
        doReturn(null).when(hotelRepository).findByName("");

        // WHEN
        String response = hotelService.validateAndRemoveHotel(null);
        // THEN
        assertEquals("HOTEL IS NULL", response);
        verify(hotelRepository, times(0)).removeHotel(null);

        Hotel hotel1 = new Hotel("", "", owner, "");

        // WHEN
        response = hotelService.validateAndRemoveHotel(hotel1);
        // THEN
        assertEquals("HOTEL DOES NOT EXIST", response);
        verify(hotelRepository, times(0)).removeHotel(null);
        verify(hotelRepository, times(1)).findByName(hotel1.getName());
    }

    @Test
    public void should_ValidateAndRemoveHotel_ForValidData() {
        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("hotel", "adresa", owner, "descriere hotel");

        //GIVEN
        doNothing().when(hotelRepository).removeHotel(any(String.class));
        doReturn(hotel).when(hotelRepository).findByName("hotel");

        // WHEN
        String response = hotelService.validateAndRemoveHotel(hotel);
        // THEN
        assertEquals("EVERYTHING WENT WELL", response);
        verify(hotelRepository, times(1)).removeHotel(hotel.getName());
        verify(hotelRepository, times(1)).findByName(hotel.getName());
    }

    @Test
    public void should_getHotels() {
        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("hotel", "adresa", owner, "descriere hotel");

        List<Hotel> hotels = new ArrayList();
        hotels.add(hotel);

        //GIVEN
        doReturn(hotels).when(hotelRepository).getHotels();

        // WHEN
        List<Hotel> hotelsResponse = hotelService.getHotels();

        // THEN
        assertEquals(hotels, hotelsResponse);
        verify(hotelRepository, times(1)).getHotels();
    }

    @Test
    public void should_findByName() {
        Person owner = new Owner("1", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel("hotel", "adresa", owner, "descriere hotel");

        //GIVEN
        doReturn(hotel).when(hotelRepository).findByName("hotel");

        // WHEN
        Hotel hotelResponse = hotelService.findByName("hotel");

        // THEN
        assertEquals(hotel, hotelResponse);
        verify(hotelRepository, times(1)).findByName("hotel");
    }
}
