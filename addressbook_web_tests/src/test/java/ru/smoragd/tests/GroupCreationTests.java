package ru.smoragd.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.smoragd.common.CommonFunctions;
import ru.smoragd.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("","group name")){
            for (var header : List.of("","group header")){
                for (var footer : List.of("","group footer")){
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
 /* Старый провайдер (без чтения из файла): for (int i = 0; i < 5; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i+10))
                    .withHeader(CommonFunctions.randomString(i+10))
                    .withFooter(CommonFunctions.randomString(i+10)));}*/

//3 метода прочитать содержимое файла groups.json (в строку или поток) и передать в mapper.readValue(...),
// чтобы получить List<GroupData>:

        // 1.) Метод прочитать файл построчно. Файл должен лежать в корне проекта.
        // Тогда ниже в mapper.readValue() передаем json, а не inputStream
//        var json = "";
//        try (var reader = new FileReader("groups.json");
//             var breader = new BufferedReader(reader);){
//                var line = breader.readLine();
//                while (line != null) {
//                    json = json + line;
//                    line = breader.readLine();
//                }  }

        // 2.) Еще метод прочитать файл целиком, не построчно. Файл должен лежать в корне проекта.
        // Тогда ниже в mapper.readValue() передаем json, а не inputStream
//        var json = Files.readString(Paths.get("groups.json"));

        //3.) Еще метод читать данные из файла. Файл должен лежать в src/test/resources (Gradle копирует оттуда в classpath).
        //.getResourceAsStream("groups.json") ищет файл в classpath, а не в рабочей директории, как File("groups.json").
        // Тогда ниже в mapper.readValue() передаем inputStream, а не json
        var inputStream = GroupCreationTests.class.getClassLoader()
                .getResourceAsStream("groups.json");
        var mapper = new ObjectMapper();

        //код для YAML
//        var inputStream = GroupCreationTests.class.getClassLoader()
//                .getResourceAsStream("groups.yaml");
//        var mapper = new YAMLMapper();

        //код для XML
//        var inputStream = GroupCreationTests.class.getClassLoader()
//                .getResourceAsStream("groups.xml");
//        var mapper = new XmlMapper();

        var value = mapper.readValue(inputStream, new TypeReference<List<GroupData>>(){});
        result.addAll(value);
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'","","")
        ));
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {
        var oldGroups = app.groups().getList();

        app.groups().createGroup(group);

        var newGroups = app.groups().getList();
        //compareById — компаратор, который упорядочивает группы по возрастанию id (от меньшего id  к бОльшему)
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        //сортируем элементы списка, передаем в sort() функцию-компаратор
        newGroups.sort(compareById);

        var expectedList = new ArrayList<>(oldGroups);
        //созданная группа в expectedList будет иметь id - как у последнего элемента newGroups
        //при этом хэдер и футер делаем "", чтобы они не участвовали в сравнении (не указать мы их не можем)
        expectedList.add(group.withId(newGroups.get(newGroups.size()-1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newGroups);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        var oldGroups = app.groups().getList();

        app.groups().createGroup(group);

        var newGroups = app.groups().getList();
        Assertions.assertEquals(oldGroups, newGroups);
    }

/*    @ParameterizedTest
    @ValueSource(strings = {"group name","group name'"}) // второй вариант задания параметров теста
    public void canCreateGroup(String name) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData(name, "group header", "group footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount+1, newGroupCount);
    }*/

}
