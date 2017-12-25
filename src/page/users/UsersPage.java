package page.users;

import domen.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static pages.basics.LoginPage.driver;
import pages.basics.Page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends Page {

    private void clickOnAddUser(WebDriver driver) {
        clickOnElement(driver, By.linkText("Add user"));
    }

    private void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_user_submit"));
    }

    public Users craateNewUser(WebDriver driver) throws InterruptedException {
        Users us = new Users();

        clickOnAddUser(driver);
        us.setUserName(sendTextOnField(driver, By.id("username")));
        us.setFirstName(sendTextOnField(driver, By.id("first_name")));
        us.setLastName(sendTextOnField(driver, By.id("last_name")));
        us.setEmail(sendEmailOnField(driver, By.id("email")));
        clickOnSave(driver);
        
        Thread.sleep(3000);
                
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute("data-user-id");
        us.setId(Integer.valueOf(id));
        return us;
    }

    public Users editUser(WebDriver driver) throws InterruptedException {
        Users us = new Users();
        choosOptionFromLastRow(driver, By.className("glyphicon-pencil"));
        us.setUserName(sendTextOnField(driver, By.id("username")));
        us.setFirstName(sendTextOnField(driver, By.id("first_name")));
        us.setLastName(sendTextOnField(driver, By.id("last_name")));
        us.setEmail(sendEmailOnField(driver, By.id("email")));
        clickOnSave(driver);
        
        Thread.sleep(3000);
        
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute("data-user-id");
        us.setId(Integer.valueOf(id));
        return us;
    }

    public Users deleteUser(WebDriver driver) {
        Users us = new Users();

        choosOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return us;
    }
}
