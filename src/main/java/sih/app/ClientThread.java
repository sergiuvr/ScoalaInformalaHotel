package sih.app;

import sih.app.domain.CheckInData;
import sih.app.domain.hotel.Hotel;

public class ClientThread implements Runnable {
    private Hotel hotel;
    private CheckInData checkInData;

    public ClientThread(Hotel hotel, CheckInData checkInData) {
        this.hotel = hotel;
        this.checkInData = checkInData;
    }

    /**
     * validates checkInData and adds data in hotel queue
     */
    public void run() {
        System.out.println("Client starts");
        if (checkInData.getCheckInDate() == null) {
            System.out.println("The check-in date must not be null");
        } else if (checkInData.getPeopleNumber() == 0) {
            System.out.println("The number of people must be greater than 0");
        } else {
            System.out.println("Everything ok");
            synchronized (hotel){
                hotel.addCheckInData(checkInData);
                System.out.println("Wrote check-in data");
            }
        }
        System.out.println("Client end");
    }
}
