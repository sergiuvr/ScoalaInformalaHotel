package sih.app;

import sih.app.domain.CheckInData;
import sih.app.domain.hotel.Hotel;

public class HotelStatisticsThread implements Runnable {
    private Hotel hotel;

    public HotelStatisticsThread(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Every 5 seconds a HotelStatisticsThread wakes up and reads the new data from the hotel and generates statistics:
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                //read from hotel only if it's not empty
                while (hotel.hasCheckInData()) {
                    synchronized (hotel) {
                        System.out.println("Get all data from hotel");
                        int numberOfPeopleArrivingToday = 0;
                        int numberOfPeopleArrivingBeforeLunch = 0;
                        Thread.sleep(3000);
                        CheckInData checkInData = hotel.pollCheckInData();

                        if (DateUtils.isToday(checkInData.getCheckInDate())) {
                            numberOfPeopleArrivingToday += checkInData.getPeopleNumber();

                            if (DateUtils.isBeforeLunch(checkInData.getCheckInDate())) {
                                numberOfPeopleArrivingBeforeLunch += checkInData.getPeopleNumber();
                            }
                        }

                        System.out.println("Get all data from hotel: Finished");
                        System.out.println("Number Of People Arriving Today " + numberOfPeopleArrivingToday);
                        System.out.println("Number Of People Arriving Before Lunch " + numberOfPeopleArrivingBeforeLunch);
                    }
                }
            } catch (InterruptedException intEx) {

            }
        }
    }
}
