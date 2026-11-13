package manager;

import model.ContactData;
import org.openqa.selenium.By;

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
        selectGroup(By.name("new_group"), GROUP_FOR_CONTACT_CREATION);
    }



    public void openMainPage() {
        if (!manager.isElementPresent(By.linkText("home"))) {
            click(By.linkText("home"));
        }
    }
}
