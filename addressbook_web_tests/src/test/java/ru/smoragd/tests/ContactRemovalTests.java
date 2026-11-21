package ru.smoragd.tests;

import ru.smoragd.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactsCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstname("Петр").withLastname("Петров"));
        }

        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        app.contacts().removeContact(oldContacts.get(index));

        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);

        Assertions.assertEquals(expectedList, newContacts);
    }

    @Test
    public void canRemoveAllContactsAtOnce() {
        if (app.contacts().getContactsCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstname("Петр").withLastname("Петров"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getContactsCount());
    }
}
