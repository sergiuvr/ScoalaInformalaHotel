package sih.app;

public class Employee extends Person{

    private Long salary;

    public Employee(String id, String firstName, String lastName, Integer age, Long salary) {
        super(id, firstName, lastName, age);
        this.salary = salary;
    }
}
