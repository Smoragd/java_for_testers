package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname",
                "nickname", "title", "company", "address", "homePhone",
                "mobilePhone", "workPhone", "email", "email2", "email3", "",
                "bday"));
    }

    @Test
    public void canCreateContactNoPhotoNoDatesNoGroup() {
        app.contacts().createContact(new ContactData().noPhotoNoDatesNoGroup("firstname", "middlename", "lastname",
                "nickname", "title", "company", "address", "homePhone",
                "mobilePhone", "workPhone", "email", "email2", "email3", "homepage.ru"));
    }


        /*driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("name");
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys("middle");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("last");
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys("nick");
        driver.findElement(By.name("photo")).click();
        driver.findElement(By.name("photo")).sendKeys("C:\\fakepath\\ce15417f45a08594ee29f70ded9e022a.jpg");
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).sendKeys("title");
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).sendKeys("company");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("address");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("111");
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys("222");
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys("333");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("1@ya.ru");
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys("1@gmail.com");
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys("1@mail.ru");
        driver.findElement(By.name("homepage")).click();
        driver.findElement(By.name("homepage")).sendKeys("homepage.ru");
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
