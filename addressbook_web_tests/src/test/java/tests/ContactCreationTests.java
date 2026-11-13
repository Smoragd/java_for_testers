package tests;

import manager.ContactHelper;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static manager.ContactHelper.PHOTO_LINK;

public class ContactCreationTests extends TestBase {

    @BeforeAll
    public static void createGroupForContacts() {
        app.groups().createGroup(new GroupData(ContactHelper.GROUP_FOR_CONTACT_CREATION, "header", "footer"));
    }

    @Test
    public void canCreateFullContact() {
        app.contacts().createContact(new ContactData("Тест", "Тестович", "Тестов",
                "Test_nick", PHOTO_LINK, "Должность", "Компания", "Адрес", "000111_дом",
                "222333_мобильный", "444555_рабочий", "email", "email2", "email3",
                "26","December","2012","25","November","2021","homepage.ru"));
    }

    @Test
    public void canCreateEmptyContact() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstnameOnly() {
        app.contacts().createContact(new ContactData().withFirstname("Петров"));
    }

}
