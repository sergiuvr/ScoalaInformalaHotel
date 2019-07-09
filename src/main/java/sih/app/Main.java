package sih.app;

import sih.app.domain.CheckInData;
import sih.app.domain.Order;
import sih.app.domain.Reservation;
import sih.app.domain.hotel.*;
import sih.app.domain.people.Client;
import sih.app.domain.people.Employee;
import sih.app.domain.people.Owner;
import sih.app.domain.people.Person;
import sih.app.repositories.ClientRepository;
import sih.app.repositories.ClientRepositoryInterface;
import sih.app.repositories.HotelRepository;
import sih.app.repositories.HotelRepositoryInterface;
import sih.app.services.ClientService;
import sih.app.services.HotelService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ParseException, InterruptedException {
        partFour();
        partFiveAndSix();
        addAndSortRooms();
        useMap();
        partSeven();
        partEight(1000);
    }

    private static void partEight(int numberOfClients) throws ParseException, InterruptedException {
        Person owner = new Owner(1, "1321312312", "Ion", "Pop", 30, 23000L);
        Hotel hotel = new Hotel(1, "Continental", "adresa", owner, "descriere hotel");

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = format.parse("07-07-2019");
        Date d2 = format.parse("10-07-2019");
        Random r = new Random();
        int low = 1;
        int high = 10;

        HotelStatisticsThread hotelStatisticsThread = new HotelStatisticsThread(hotel);
        Thread t1 = new Thread(hotelStatisticsThread);
        t1.start();

        while (numberOfClients > 0) {
            //randomly generate client threads
            Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
            int randomPeopleNumber = r.nextInt(high - low) + low;
            ClientThread clientThread = new ClientThread(hotel, new CheckInData(randomDate, randomPeopleNumber));
            Thread t2 = new Thread(clientThread);
            t2.start();
            numberOfClients--;
        }
    }

    /**
     * use:  map, max (min or count), reduce, collect
     * create the streams and using a stream function
     * use the Builder pattern in one of you models
     */
    private static void partSeven() throws ParseException {
        Person owner = new Owner(1, "1321312312", "Ion", "Pop", 30, 23000L);

        Hotel hotel = new Hotel(1, "Continental", "adresa", owner, "descriere hotel");

        Person employee1 = new Employee(1, "31232132", "Cosmin", "Pop", 22, 2300L);
        Person employee2 = new Employee(2, "2312312", "Mihaela", "Cosma", 30, 21121L);
        Person employee3 = new Employee(3, "2312312", "Ion", "Mircea", 18, 2121L);
        hotel.addEmployee(employee1);
        hotel.addEmployee(employee2);
        hotel.addEmployee(employee3);

        //compute the average age of the employees of an hotel
        List<Person> allEmployees = hotel.getAllEmployees();
        Integer sum = allEmployees.stream().map(Person::getAge).reduce(0, (subtotal, element) -> subtotal + element);
        int average = sum / allEmployees.size();


        //find the max number from a random generated list
        Stream.generate(Math::random)
                .limit(10)
                .max(Double::compareTo).ifPresent(n -> System.out.println("The max number is " + n));


        // create reservation with builder
        Client client = new Client(1, "33243213", "Cristi", "Muresan", 23, "0732321312");
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date startDate = format.parse("01-03-2019");
        Date endDate = format.parse("12-10-2019");
        Reservation account = new Reservation.Builder(1)
                .ofClient(client)
                .atStartDate(startDate)
                .atEndDate(endDate)
                .build();
    }

    /**
     * create a map structure that makes sense (ex: <K,V> => <hotel identifier, list of rooms>)
     */
    private static void useMap() {
        Person owner = new Owner(1, "34234231", "Ion", "Pop", 30, 23000L);
        Hotel hotel1 = new Hotel(1L, "Continental", "adresa", owner, "descriere hotel");
        Room room1 = new Room(1, 12, "", 1000L, 2, 1, "descriere", Availability.AVAILABLE);
        Room room2 = new Room(2, 32, "", 20L, 1, 2, "descriere", Availability.AVAILABLE);
        Room room3 = new Room(3, 22, "", 100L, 2, 1, "descriere", Availability.NOT_AVAILABLE);
        hotel1.addRoom(room1);
        hotel1.addRoom(room2);
        hotel1.addRoom(room3);

        Hotel hotel2 = new Hotel(2L, "Belvedere", "sus", owner, "descriere hotel");
        Room room12 = new Room(1, 1, "", 120L, 2, 3, "descriere", Availability.NOT_AVAILABLE);
        Room room22 = new Room(2, 2, "", 2220L, 4, 3, "descriere", Availability.AVAILABLE);
        Room room32 = new Room(3, 3, "", 500L, 1, 3, "descriere", Availability.NOT_AVAILABLE);
        hotel2.addRoom(room12);
        hotel2.addRoom(room22);
        hotel2.addRoom(room32);

        HotelRepositoryInterface hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        //add
        hotelService.validateAndAddHotel(hotel1);
        hotelService.validateAndAddHotel(hotel2);

        //list
        Collection<Hotel> hotels = hotelService.getHotels();

        // create Map with hotel id and rooms
        Map<Long, List<Room>> hotelsWithRooms = hotels.stream().collect(Collectors.toMap(Hotel::getId, Hotel::getRooms));
    }

    /**
     * add 10 rooms and sort them
     */
    private static void addAndSortRooms() {
        Person owner = new Owner(1, "3213121", "Ion", "Pop", 30, 23000L);
        System.out.println(owner);

        Hotel hotel = new Hotel(1, "Continental", "adresa", owner, "descriere hotel");

        Room room1 = new Room(1, 1, "room1", 1000L, 2, 1, "", Availability.AVAILABLE);
        Room room2 = new Room(2, 2, "room2", 20L, 1, 1, "", Availability.AVAILABLE);
        Room room3 = new Room(3, 3, "room3", 100L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room4 = new Room(4, 4, "room4", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room5 = new Room(5, 5, "room5", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room6 = new Room(6, 6, "room6", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room7 = new Room(7, 7, "room7", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room8 = new Room(8, 8, "room8", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room9 = new Room(9, 9, "room9", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        Room room10 = new Room(10, 10, "room10", 3213L, 2, 1, "", Availability.NOT_AVAILABLE);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);
        hotel.addRoom(room6);
        hotel.addRoom(room7);
        hotel.addRoom(room8);
        hotel.addRoom(room9);
        hotel.addRoom(room10);

        hotel.sortRoomsByName(Order.DESC);
    }

    /**
     * read an write data from/to a file
     * use a Set( 2 clients with the same cnp cannot be added)
     */
    private static void partFiveAndSix() {
        ClientRepositoryInterface clientRepository = new ClientRepository();
        ClientService clientService = new ClientService(clientRepository);
        clientService.readFromFile("in.txt");
        clientService.writeToFile("out.txt");
    }

    /**
     * adds, removes and search hotels
     */
    public static void partFour() {
        Person owner = new Owner(1, "1321312312", "Ion", "Pop", 30, 23000L);
        System.out.println(owner);

        Hotel hotel1 = new Hotel(1, "Continental", "adresa", owner, "descriere hotel");

        Person employee1 = new Employee(1, "31232132", "Cosmin", "Pop", 22, 2300L);
        Person employee2 = new Employee(2, "2312312", "Mihaela", "Cosma", 30, 21121L);
        hotel1.addEmployee(employee1);
        hotel1.addEmployee(employee2);

        Room room1 = new Room(1, 12, "", 1000L, 2, 1, "descriere", Availability.AVAILABLE);
        Room room2 = new Room(2, 32, "", 20L, 1, 2, "descriere", Availability.AVAILABLE);
        Room room3 = new Room(3, 22, "", 100L, 2, 1, "descriere", Availability.NOT_AVAILABLE);
        hotel1.addRoom(room1);
        hotel1.addRoom(room2);
        hotel1.addRoom(room3);

        Hotel hotel2 = new Hotel(2, "Belvedere", "sus", owner, "descriere hotel");

        Person employee12 = new Employee(3, "334234", "Mircea", "Pavel", 65, 33300L);
        Person employee22 = new Employee(4, "2342423", "Cristi", "Macovei", 32, 211L);
        hotel2.addEmployee(employee12);
        hotel2.addEmployee(employee22);

        Room room12 = new Room(4, 1, "", 120L, 2, 3, "descriere", Availability.NOT_AVAILABLE);
        Room room22 = new Room(5, 2, "", 2220L, 4, 3, "descriere", Availability.AVAILABLE);
        Room room32 = new Room(6, 3, "", 500L, 1, 3, "descriere", Availability.NOT_AVAILABLE);
        hotel2.addRoom(room12);
        hotel2.addRoom(room22);
        hotel2.addRoom(room32);

        System.out.println(hotel1);
        System.out.println(hotel2);

        HotelRepositoryInterface hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        //add
        hotelService.validateAndAddHotel(hotel1);
        hotelService.validateAndAddHotel(hotel2);

        //list
        Collection<Hotel> hotels = hotelService.getHotels();

        // give me the information about Hotel with the name X
        Hotel hotelByName = hotelService.findByName("Belvedere");
        System.out.println(hotelByName.toString());

        //give me information about Employee Z
        for (Person employee : hotelByName.getAllEmployees()) {
            System.out.println(employee.toString() + " works for hotel " + hotelByName.getName());
        }

        //remove
        hotelService.validateAndRemoveHotel(hotel1);
    }

}
