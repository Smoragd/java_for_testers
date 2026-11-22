package ru.smoragd.tests;

import ru.smoragd.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeAll;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    //@BeforeEach + @AfterEach - это фикстура
    @BeforeAll
    public static void setUp() throws IOException {
        if (app == null){
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target","local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("browser","firefox"), properties);
            // browser options: firefox, chrome, edge
        }
    }

    //возвращает относительный путь к рандомному файлу в указанной папке
    public static String randomFile(String dir){
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

    public static String randomFileInResources(String dirInResources) {
        try {
            var url = TestBase.class.getClassLoader().getResource(dirInResources);
            if (url == null) {
                throw new IllegalArgumentException("Папка не найдена в resources: " + dirInResources);
            }
            var files = new File(url.toURI()).list();
            if (files == null || files.length == 0) {
                throw new IllegalArgumentException("Нет файлов в папке: " + dirInResources);
            }
            var rnd = new Random();
            var index = rnd.nextInt(files.length);
            return new File(new File(url.toURI()), files[index]).getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
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
