package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public static final String PHOTO_LINK = "src/test/resources/images/Kitten.jpg"; //относительный путь
    public static final String GROUP_FOR_CONTACT_CREATION = "group_for_contactCreation";
    public static final List<String> MONTHS = List.of(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );

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

    public void openMainPage() {
        if (!manager.driver.getCurrentUrl().contains("index.php")) {
            click(By.linkText("home"));
        }
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
        attach(By.name("photo"), contact.photo());
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
        if (contact.group() != null && !contact.group().isEmpty()) {
            selectContactGroup(By.name("new_group"), contact.group());
        }

    }

    //Paths.get(file) - превращает строку пути из константы в объект Path;
    //toAbsolutePath() - относительный путь превращает в абсолютный;
    //toString() - путь превращает обратно в строку
    private void attach(By locator, String file) {
        if (file != null && !file.isEmpty()) {
            manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
        }
    }

/*  //второй вариант attach():
    private void attach(By locator, String resourceName) {
        if (resourceName != null && !resourceName.isEmpty()) {
            String path = getClass().getClassLoader()
                    .getResource(resourceName)
                    .getPath();
            manager.driver.findElement(locator).sendKeys(path);
        }
    }*/

    protected void selectContactGroup(By locator, String groupName) {
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

    public void removeContact(ContactData contact) {
        openMainPage();
        selectContact(contact);
        removeSelectedContacts();
        //manager.driver.switchTo().alert().accept(); - диалоговое окно (alert) при удалении контакта не появляется
        returnToMainPage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openMainPage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToMainPage();
    }

    private void initContactModification(ContactData contact) {
        // Ищем ссылку, в адресе (href) которой есть edit.php?id=<ID контакта>
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", contact.id())));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isContactPresent() {
        openMainPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    private void removeSelectedContacts() {
        click(By.name("delete"));
    }

    public int getContactsCount() {
        openMainPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openMainPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    public List<ContactData> getList() {
        openMainPage();
        var contacts = new ArrayList<ContactData>();
        //ищем целые строки контактов - и потом элементы ищем внутри каждой строки, а не по всему дереву
        var rows = manager.driver.findElements(By.cssSelector("tr[name=entry]"));
        for (var row : rows) {
            var lastname  = row.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var firstname = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var checkbox = row.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    public static String randomDay() {
        var rnd = new Random();
        int day = 1 + rnd.nextInt(28);
        return String.valueOf(day);
    }

    public static String randomMonth() {
        var rnd = new Random();
        return MONTHS.get(rnd.nextInt(MONTHS.size()));
    }

    public static String randomYear() {
        var rnd = new Random();
        int currentYear = Year.now().getValue();
        int year = 1901 + rnd.nextInt(currentYear - 1901);  // 1901 … currentYear-1
        return String.valueOf(year);
    }

    public static String randomPhone() {
        var rnd = new Random();
        String number = String.valueOf(1000000000L + rnd.nextInt(900000000));
        return "+7" + number;
    }
}
