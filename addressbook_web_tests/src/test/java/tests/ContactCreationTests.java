package tests;

import manager.ContactHelper;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

import static manager.ContactHelper.PHOTO_LINK;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.groups().createGroup(new GroupData(ContactHelper.GROUP_FOR_CONTACT_CREATION, "header", "footer"));
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname",
                "nickname", PHOTO_LINK,"title", "company", "address", "homePhone",
                "mobilePhone", "workPhone", "email", "email2", "email3", "",
                "bday"));
    }

    @Test
    public void canCreateContactNoDatesNoGroup() {
        app.groups().createGroup(new GroupData(ContactHelper.GROUP_FOR_CONTACT_CREATION, "header", "footer"));
        app.contacts().createContact(new ContactData().noDates("firstname", "middlename", "lastname",
                "nickname", PHOTO_LINK,"title", "company", "address", "homePhone",
                "mobilePhone", "workPhone", "email", "email2", "email3", "homepage.ru"));
    }


        /*

        driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '12']")).click();
        }
        driver.findElement(By.cssSelector("select:nth-child(58) > option:nth-child(14)")).click();
        driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'December']")).click();
        }
        driver.findElement(By.cssSelector("select:nth-child(59) > option:nth-child(13)")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).sendKeys("2012");
        driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '12']")).click();
        }
        driver.findElement(By.cssSelector("select:nth-child(63) > option:nth-child(14)")).click();
        driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'December']")).click();
        }
        driver.findElement(By.cssSelector("select:nth-child(64) > option:nth-child(13)")).click();
        driver.findElement(By.name("ayear")).click();
        driver.findElement(By.name("ayear")).sendKeys("2022");
        driver.findElement(By.name("new_group")).click();
        {
            WebElement dropdown = driver.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath("//option[. = 'new group 2']")).click();
        }
        driver.findElement(By.cssSelector("select:nth-child(68) > option:nth-child(9)")).click();
        driver.findElement(By.cssSelector("input:nth-child(71)")).click();*/

}
