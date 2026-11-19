package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactsCount() == 0) {
            app.contacts().createContact(new ContactData().withFirstname("Петр").withLastname("Петров"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        var testData = new ContactData().withFirstname("New_firstname").withLastname("New_lastname");
        app.contacts().modifyContact(oldContacts.get(index), testData);

        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        // новому объекту/контакту testData (у него пустой id) присваиваем id,
        // который был у контакта под этим же индексом до изменения,
        // и записываем в ожидаемый список.
        // expectedList — это старый список, где на месте index стоит контакт с новыми ФИ и старым id.
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));

        //compareById — компаратор, который упорядочивает группы по возрастанию id (от меньшего id  к бОльшему)
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        //сортируем элементы списка, передаем в sort() функцию-компаратор
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }
}
