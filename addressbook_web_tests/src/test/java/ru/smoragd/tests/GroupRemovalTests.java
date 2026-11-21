package ru.smoragd.tests;

import ru.smoragd.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groups().getGroupsCount() == 0) {
            app.groups().createGroup(new GroupData("", "test group", "test group", "test group"));
        }
        //int groupCount = app.groups().getGroupsCount();
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        //int newGroupCount = app.groups().getGroupsCount();
        Assertions.assertEquals(expectedList, newGroups);
    }

    @Test
    public void canRemoveAllGroupsAtOnce() {
        if (app.groups().getGroupsCount() == 0) {
            app.groups().createGroup(new GroupData("", "test group", "test group", "test group"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getGroupsCount());
    }

}
