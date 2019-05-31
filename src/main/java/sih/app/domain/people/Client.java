package sih.app.domain.people;

public class Client extends Person {

    private String phoneNumber;

    public Client(String id, String firstName, String lastName, int age, String phoneNumber) {
        super(id, firstName, lastName, age);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
