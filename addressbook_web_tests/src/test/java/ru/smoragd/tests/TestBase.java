package ru.smoragd.tests;

import ru.smoragd.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    //@BeforeEach + @AfterEach - это фикстура
    @BeforeAll
    public static void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser","firefox")); // browser options: firefox, chrome, edge
    }

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

    //возвращает относительный путь к рандомному файлу в указанной папке
    public static String randomFile(String dir){
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

    /*      // метод выбирает из списка значений любого типа, в него передается список
            public static <T> T randomFromList(List<T> values) {
            var rnd = new Random();
            return values.get(rnd.nextInt(values.size()));
        }*/

    /*   @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }*/

}
