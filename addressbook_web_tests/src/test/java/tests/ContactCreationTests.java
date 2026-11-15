package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import static manager.ContactHelper.*;

public class ContactCreationTests extends TestBase {

    @BeforeAll
    public static void createGroupForContacts() {
        app.groups().createGroup(new GroupData(GROUP_FOR_CONTACT_CREATION, "header", "footer"));
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getContactsCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getContactsCount();
        Assertions.assertEquals(contactCount+1, newContactCount);
    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();

        //1.) варианты "не заполнено - заполнено" для ГРУПП параметров,
        // тк если перебирать для каждого отдельного параметра, то будет больше 2млн тестов
        for (var fioNickFilled : List.of(false, true)) {
            for (var photoFilled : List.of(false, true)) {
                for (var contactInfoFilled : List.of(false, true)) {
                    for (var datesFilled : List.of(false, true)) {
                        for (var groupFilled : List.of(false, true)) {
                            result.add(new ContactData(
                                    // 1. ФИО + никнейм
                                    fioNickFilled ? "Тест" : "",
                                    fioNickFilled ? "Тестович" : "",
                                    fioNickFilled ? "Тестов" : "",
                                    fioNickFilled ? "Test_nick" : "",
                                    // 2. фото
                                    photoFilled ? PHOTO_LINK : "",
                                    // 3. должность + компания + адрес + homepage + телефоны + email'ы
                                    contactInfoFilled ? "Должность" : "",
                                    contactInfoFilled ? "Компания" : "",
                                    contactInfoFilled ? "Адрес" : "",
                                    contactInfoFilled ? "000111_дом" : "",
                                    contactInfoFilled ? "222333_мобильный" : "",
                                    contactInfoFilled ? "444555_рабочий" : "",
                                    contactInfoFilled ? "email" : "",
                                    contactInfoFilled ? "email2" : "",
                                    contactInfoFilled ? "email3" : "",
                                    contactInfoFilled ? "homepage.ru" : "",
                                    // 4. день рождения + годовщина
                                    datesFilled ? "26" : "",
                                    datesFilled ? "December" : "",
                                    datesFilled ? "2012" : "",
                                    datesFilled ? "25" : "",
                                    datesFilled ? "November" : "",
                                    datesFilled ? "2021" : "",
                                    // 5. группа
                                    groupFilled ? GROUP_FOR_CONTACT_CREATION : ""
                            ));
                        }
                    }
                }
            }
        }

        //2.) варианты с генератором рандомных значений
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i+10),randomString(i+10),randomString(i+10),
                    randomString(i+10),PHOTO_LINK,randomString(i+10),
                    randomString(i+10),randomString(i+10),randomPhone(),
                    randomPhone(),randomPhone(),randomString(i+10),
                    randomString(i+10),randomString(i+10),randomString(i+10),
                    randomDay(),randomMonth(),randomYear(),
                    randomDay(),randomMonth(),randomYear(),GROUP_FOR_CONTACT_CREATION));
        }

        return result;
    }

/*    @Test
    public void canCreateEmptyContact() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstnameOnly() {
        app.contacts().createContact(new ContactData().withFirstname("Петров"));
    }

    @Test
    public void canCreateFullContact() {
        app.contacts().createContact(new ContactData("Тест", "Тестович", "Тестов",
                "Test_nick", PHOTO_LINK, "Должность", "Компания", "Адрес", "000111_дом",
                "222333_мобильный", "444555_рабочий", "email", "email2", "email3", "homepage.ru",
                "26","December","2012","25","November","2021", GROUP_FOR_CONTACT_CREATION));
    }*/

}
