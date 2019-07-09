package sih.app.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class CheckInData {

    private Date checkInDate;
    private int peopleNumber;

    public CheckInData(Date checkInDate, int peopleNumber) {
        this.checkInDate = checkInDate;
        this.peopleNumber = peopleNumber;
    }
}
