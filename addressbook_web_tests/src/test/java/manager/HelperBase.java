package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void addPhoto(By locator, String text) {
        manager.driver.findElement(locator).sendKeys(text);
    }

    /*protected void selectGroup(By locator, By groupName) {
        manager.driver.findElement(locator).click();
        WebElement dropdown = manager.driver.findElement(locator);
        dropdown.findElement(groupName).click();
    }*/

    protected void selectGroup(By locator, String groupName) {
        WebElement select = manager.driver.findElement(locator);
        select.click();
        select.findElement(By.xpath(".//option[. = '" + groupName + "']")).click();
    }


}
