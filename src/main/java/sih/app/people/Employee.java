package sih.app;

public class Employee extends Person{

    private long salary;

    public Employee(String id, String firstName, String lastName, int age, long salary) {
        super(id, firstName, lastName, age);
        this.salary = salary;
    }
}
