package ru.smoragd.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.smoragd.common.CommonFunctions;
import ru.smoragd.model.ContactData;
import ru.smoragd.model.GroupData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static ru.smoragd.manager.ContactHelper.*;

public class Generator {

    @Parameter(names = {"--type","-t"})
    String type;

    @Parameter(names = {"--output","-o"})
    String output;

    @Parameter(names = {"--format","-f"})
    String format;

    @Parameter(names = {"--count","c"})
    int count;

    //с помощью JCommander программа читает аргументы, с которыми запущена, и раскладывает их по полям Generator
    public static void main(String[] args) throws IOException {
        var generator = new Generator();

        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);

        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i+10))
                    .withHeader(CommonFunctions.randomString(i+10))
                    .withFooter(CommonFunctions.randomString(i+10)));
        }
        return result;
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData("", CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10), photoLink(), CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),randomPhone(),
                    randomPhone(),randomPhone(), CommonFunctions.randomString(i+10),
                    CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10), CommonFunctions.randomString(i+10),
                    randomDay(),randomMonth(),randomYear(),
                    randomDay(),randomMonth(),randomYear(),GROUP_FOR_CONTACT_CREATION));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            // JsonMapper - наследник ObjectMapper
            // enable(SerializationFeature.INDENT_OUTPUT) - настройка для "красивого вывода" json
            ObjectMapper mapper = JsonMapper.builder()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .build();
            var json = mapper.writeValueAsString(data); //сохраняем строку (json) в переменную

/*            var writer = new FileWriter(output); //название файла output передаем в качестве параметра
            writer.write(json); //записываем в файл строку (json)
            writer.close(); //закрываем файл, чтобы произошла запись данных на диск*/
            //аналог close() выше - конструкция try
            //когда выполнится код из {}, для переменной из () автоматически будет вызван метод close()
            try (var writer = new FileWriter(output)) {
                writer.write(json); //записываем в файл строку (json)
            }
            // 2 вариант: сразу запись в файл (как у yaml ниже), без отдельной записи в строку
            //File(output)-куда пишем, data - что пишем (сгенерированные данные)
            //mapper.writeValue(new File(output), data);

        } else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        } else if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // включает отступы
            mapper.writeValue(new File(output), data);
        } else if ("csv".equals(format)) {
            var mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(GroupData.class).withHeader(); // заголовки = названия полей GroupData
            mapper.writer(schema).writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }
}
