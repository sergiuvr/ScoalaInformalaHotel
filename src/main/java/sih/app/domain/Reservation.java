package sih.app.domain;

import sih.app.domain.people.Client;

import java.util.Date;

public class Reservation {
    private long id;
    private Client client;
    private Date startDate;
    private Date endDate;

    public static class Builder {
        private long id;
        private Client client;
        private Date startDate;
        private Date endDate;

        public Builder(long id) {
            this.id = id;
        }
        public Builder ofClient(Client client){
            this.client = client;
            return this;  //By returning the builder each time, we can create a fluent interface.
        }
        public Builder atStartDate(Date startDate){
            this.startDate = startDate;
            return this;
        }
        public Builder atEndDate(Date endDate){
            this.endDate = endDate;
            return this;
        }

        public Reservation build(){
            Reservation reservation = new Reservation();
            reservation.id = this.id;
            reservation.client = this.client;
            reservation.startDate = this.startDate;
            reservation.endDate = this.endDate;
            return reservation;
        }
    }

    private Reservation() { }
}
