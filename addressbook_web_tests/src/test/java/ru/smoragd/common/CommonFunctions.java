package ru.smoragd.common;

import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n){
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
            //rnd.nextInt(27) - случайное число от 0 до 25;
            // ('a' + rnd.nextInt(26)) - номер символа от 97('a'+0) до 122('a'+25);
            // (char)('a' + rnd.nextInt(26)) - предобразование номера символа в сам символ под этим номером
        }
        return result;
    }
}
