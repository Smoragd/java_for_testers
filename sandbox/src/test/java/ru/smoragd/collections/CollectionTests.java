package ru.smoragd.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests(){
        //var array = new String[]{"a","b","c"};

        var array = new String[3];
        Assertions.assertEquals(3, array.length);
        array[0]="a";
        Assertions.assertEquals("a",array[0]);

        array[0]="d";
        Assertions.assertEquals("d",array[0]);
    }

    @Test
    void listTests(){
        //пустой список - требует указания типа данных и ручного заполнения элементов:
        //var list = new ArrayList<String>();
        //Assertions.assertEquals(0, list.size());
        //list.add("a");
        //list.add("b");
        //list.add("c");

        //список при помощи List.of - предзаполненный, но не модифицируемый:
        //var list = List.of("a","b","c");

        //поэтому предзаполненный значениями список можно передать прямо в конструктор + не указывать тип данных:
        var list = new ArrayList<>(List.of("a","b","c"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a",list.get(0));

        list.set(0,"d"); // изменение значения
        Assertions.assertEquals("d",list.get(0));

        list.add(2, "e"); // добавление значения
        Assertions.assertEquals("e",list.get(2));
        Assertions.assertEquals("c",list.get(3));

        Assertions.assertEquals("e", list.remove(2)); // удаление по индексу
        Assertions.assertEquals("c", list.get(2));

        list.add(2, "d");
        list.remove("d"); // удаление по значению
        Assertions.assertEquals("c", list.get(2));
    }
}
