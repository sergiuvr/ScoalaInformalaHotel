package sih.app.people;

public class Person {

    private String id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age:" + age;
    }
}
