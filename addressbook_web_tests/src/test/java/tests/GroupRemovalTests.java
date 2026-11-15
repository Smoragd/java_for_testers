package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        //if (!app.groups().isGroupPresent()) - метод getCount() более универсальный
        if (app.groups().getGroupsCount() == 0) {
            app.groups().createGroup(new GroupData("test group", "test group", "test group"));
        }
        int groupCount = app.groups().getGroupsCount();
        app.groups().removeGroup();
        int newGroupCount = app.groups().getGroupsCount();
        Assertions.assertEquals(groupCount-1, newGroupCount);
    }

    @Test
    public void canRemoveAllGroupsAtOnce() {
        if (app.groups().getGroupsCount() == 0) {
            app.groups().createGroup(new GroupData("test group", "test group", "test group"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getGroupsCount());
    }

}
