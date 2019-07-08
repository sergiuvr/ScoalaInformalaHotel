package sih.app.domain.people;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Client extends Person implements Serializable {

    @EqualsAndHashCode.Exclude
    private String phoneNumber;

    public Client(long id, String cnp ,String firstName, String lastName, int age, String phoneNumber) {
        super(id, cnp, firstName, lastName, age);
        this.phoneNumber = phoneNumber;
    }
}
