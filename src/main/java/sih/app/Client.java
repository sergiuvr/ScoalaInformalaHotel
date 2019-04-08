package sih.app;

public class Client extends Person {

    private String phoneNumber;

    public Client(String id, String firstName, String lastName, Integer age, String phoneNumber) {
        super(id, firstName, lastName, age);
        this.phoneNumber = phoneNumber;
    }
}
