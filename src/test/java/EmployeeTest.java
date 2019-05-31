import org.junit.Test;
import sih.app.domain.people.Client;
import sih.app.domain.people.Employee;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void createClient() {

        String id = "1";
        String firstName = "Robert";
        String lastName = "Pop";
        int age = 30;
        String phoneNumber = "423423";
        long salary = 100L;
        Employee employee = new Employee(id, firstName, lastName, age, salary);
        assertEquals(employee.getId(), id);
        assertEquals(employee.getFirstName(), firstName);
        assertEquals(employee.getLastName(), lastName);
        assertEquals(employee.getAge(), age);
        assertEquals(employee.getSalary(), salary);
    }
}
