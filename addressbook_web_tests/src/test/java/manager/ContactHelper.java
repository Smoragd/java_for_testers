package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public static final String PHOTO_LINK = "C:\\Users\\Admin\\Downloads\\Kitten.jpg";
    public static final String GROUP_FOR_CONTACT_CREATION = "group_for_contactCreation";

    public void createContact(ContactData contact) {
        openMainPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToMainPage();
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void returnToMainPage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        addPhoto(By.name("photo"), contact.photo());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.homePhone());
        type(By.name("mobile"), contact.mobilePhone());
        type(By.name("work"), contact.workPhone());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        selectDateAndMonth(By.name("bday"), contact.bday());
        selectDateAndMonth(By.name("bmonth"), contact.bmonth());
        type(By.name("byear"), contact.byear());
        selectDateAndMonth(By.name("aday"), contact.aday());
        selectDateAndMonth(By.name("amonth"), contact.amonth());
        type(By.name("ayear"), contact.ayear());
        selectGroup(By.name("new_group"), GROUP_FOR_CONTACT_CREATION);

    }

    public void openMainPage() {
        if (!manager.isElementPresent(By.linkText("home"))) {
            click(By.linkText("home"));
        }
    }

    private void addPhoto(By locator, String photoLink) {
        if (photoLink != null && !photoLink.isEmpty()) {
            manager.driver.findElement(locator).sendKeys(photoLink);
        }
    }

    protected void selectGroup(By locator, String groupName) {
        WebElement select = manager.driver.findElement(locator);
        select.click();
        select.findElement(By.xpath(".//option[. = '" + groupName + "']")).click();
    }

    protected void selectDateAndMonth(By selectLocator, String value) {
        if (value == null || value.isEmpty()) {
            return;   // пустое значение — ничего не выбираем
        }
        WebElement select = manager.driver.findElement(selectLocator);
        select.click();
        select.findElement(By.xpath(".//option[. = '" + value + "']")).click();
    }
}
