package sih.app.domain.people;

import lombok.Getter;

@Getter
public class Employee extends Person {

    private long salary;

    public Employee(long id, String cnp, String firstName, String lastName, int age, long salary) {
        super(id, cnp, firstName, lastName, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary:" + salary;
    }
}
