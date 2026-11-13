package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstname("Петров"));
        }
        app.contacts().removeContact();
    }
}
