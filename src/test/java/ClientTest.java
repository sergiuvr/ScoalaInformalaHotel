import org.junit.Test;
import sih.app.domain.people.Client;
import sih.app.domain.people.Person;

import static org.junit.Assert.assertEquals;

public class ClientTest {

    @Test
    public void createClient() {

        long id = 1;
        String cnp = "3213121";
        String firstName = "Robert";
        String lastName = "Pop";
        int age = 30;
        String phoneNumber = "423423";
        Client client = new Client(id, cnp, firstName, lastName, age, phoneNumber);
        assertEquals(client.getId(), id);
        assertEquals(client.getFirstName(), firstName);
        assertEquals(client.getLastName(), lastName);
        assertEquals(client.getAge(), age);
        assertEquals(client.getPhoneNumber(), phoneNumber);
    }
}
