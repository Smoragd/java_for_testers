package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstname("Петров"));
        }
        app.contacts().removeContact();
    }

    @Test
    public void canRemoveAllContactsAtOnce() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstname("Петров"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getContactsCount());
    }
}
