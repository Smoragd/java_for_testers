package ru.smoragd.tests;

import ru.smoragd.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getGroupsCount() == 0) {
            app.groups().createGroup(new GroupData("", "test group", "test group", "test group"));
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());

        var testData = new GroupData().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testData);

        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        // новому объекту/группе testData (у него пустой id) присваиваем id,
        // который был у группы под этим же индексом до изменения,
        // и записываем в ожидаемый список.
        // expectedList — это старый список, где на месте index стоит группа с новым именем и старым id.
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));

        //compareById — компаратор, который упорядочивает группы по возрастанию id (от меньшего id  к бОльшему)
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        //сортируем элементы списка, передаем в sort() функцию-компаратор
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newGroups);
    }
}
