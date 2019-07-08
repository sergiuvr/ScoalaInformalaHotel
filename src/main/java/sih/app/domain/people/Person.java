package sih.app.domain.people;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import sih.app.domain.HasId;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Person extends HasId {
    @EqualsAndHashCode.Include
    private String cnp;
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String lastName;
    @EqualsAndHashCode.Exclude
    private int age;

    public Person(long id, String cnp, String firstName, String lastName, int age) {
        super(id);
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age:" + age;
    }

}
