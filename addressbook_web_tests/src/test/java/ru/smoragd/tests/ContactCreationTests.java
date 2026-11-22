package ru.smoragd.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.smoragd.common.CommonFunctions;
import ru.smoragd.model.ContactData;
import ru.smoragd.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static ru.smoragd.manager.ContactHelper.*;

public class ContactCreationTests extends TestBase {

    @BeforeAll
    public static void createGroupForContacts() {
        app.groups().createGroup(new GroupData("", GROUP_FOR_CONTACT_CREATION, "header", "footer"));
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);

        var newContacts = app.contacts().getList();

        //compareById — компаратор, который упорядочивает контакты по возрастанию id (от меньшего id  к бОльшему)
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        //сортируем элементы списка, передаем в sort() функцию-компаратор
        newContacts.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);
        //созданный контакт в expectedList будет иметь id - как у последнего элемента newContacts
        //при этом все поля, кроме id+ФИ, делаем "", чтобы они не участвовали в сравнении (не указать мы их не можем)
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withEmptyFieldsExceptIdFirstnameLastname());
        expectedList.sort(compareById);

        Assertions.assertEquals(expectedList, newContacts);
    }

    @Test
    public void canCreateContact() {
        var contact = new ContactData()
                .withFirstname("firstname")
                .withLastname("lastname")
                .withPhoto(photoLink());
        app.contacts().createContact(contact);
    }


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();

        //1.) варианты "не заполнено - заполнено" для ГРУПП параметров
        for (var fioNickFilled : List.of(false, true)) {
            for (var photoFilled : List.of(false, true)) {
                for (var contactInfoFilled : List.of(false, true)) {
                    for (var datesFilled : List.of(false, true)) {
                        for (var groupFilled : List.of(false, true)) {
                            result.add(new ContactData(
                                    // 1. id + ФИО + никнейм
                                    fioNickFilled ? "Тест" : "",
                                    fioNickFilled ? "Тест" : "",
                                    fioNickFilled ? "Тестович" : "",
                                    fioNickFilled ? "Тестов" : "",
                                    fioNickFilled ? "Test_nick" : "",
                                    // 2. фото
                                    photoFilled ? photoLink() : "",
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
/*Старый провайдер (без чтения из файла):        for (int i = 0; i < 5; i++) {
            result.add(new ContactData("", CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10),photoLink, CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),randomPhone(),
                    randomPhone(),randomPhone(), CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),
                    randomDay(),randomMonth(),randomYear(),
                    randomDay(),randomMonth(),randomYear(),GROUP_FOR_CONTACT_CREATION));
        }*/

        //код для JSON
        var inputStream = ContactCreationTests.class.getClassLoader()
                .getResourceAsStream("contacts.json");
        var mapper = new ObjectMapper();

        var value = mapper.readValue(inputStream, new TypeReference<List<ContactData>>(){});
        result.addAll(value);
        return result;
    }

}
