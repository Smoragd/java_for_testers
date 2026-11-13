package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

    /*   @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }*/

}
