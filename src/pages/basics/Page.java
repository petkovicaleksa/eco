/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUtil.PageUtilities;
import static pages.basics.LoginPage.wait;

/**
 *
 * @author SonjaAleksa
 */
public class Page {

    public WebElement waitForWebElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementClickability(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void clickOnElement(WebDriver driver, By locator) {
        WebElement target = waitForElementClickability(driver, locator);
        target.click();
    }

    public String sendTextOnField(WebDriver driver, By locator, String text) {
        WebElement title = waitForWebElement(driver, locator);
        title.clear();
        title.sendKeys(text);
        return text;

    }

    public String sendTextOnField(WebDriver driver, By locator) {
        WebElement title = waitForWebElement(driver, locator);
        title.clear();
        String text = PageUtilities.getRandomText();
        title.sendKeys(text);
        return text;
    }

    public String sendUrlOnField(WebDriver driver, By locator) {
        WebElement urlField = waitForWebElement(driver, locator);
        urlField.clear();
        String url = PageUtilities.getRandomUrl();
        urlField.sendKeys(url);
        return url;
    }

    public String sendEmailOnField(WebDriver driver, By locator) {
        WebElement emailField = waitForWebElement(driver, locator);
        emailField.clear();
        String email = PageUtilities.getRandomEmail();
        emailField.sendKeys(email);
        return email;
    }

    public WebElement findLastRow(WebDriver driver) {
        WebElement table = waitForElementClickability(driver, By.id("rows-table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    public void choosOptionFromLastRow(WebDriver driver, By locator) {
        WebElement lastRow = findLastRow(driver);
        WebElement optionButton = lastRow.findElement(locator);
        optionButton.click();

    }
//     public String setPhoto(WebDriver driver) {
//        return sendTextOnField(driver, By.id("index_slide_photo"), "C:\\Users\\SonjaAleksa\\Desktop\\222.jpg");

    public void setPhoto(WebDriver driver, By locator) {
        WebElement photo = waitForWebElement(driver, locator);
//        photo.sendKeys("/Users/qa/Desktop/1.jpg");
        photo.sendKeys("C:\\Users\\SonjaAleksa\\Desktop\\3.jpg");
    }

    public void linkTypeCombo(WebDriver driver) {
        WebElement linkType = waitForElementClickability(driver, By.id("link_type"));

        Select combo = new Select(linkType);
        combo.selectByValue("InternalLink");
    }

    public String linkTypeComboEdit(WebDriver driver) {
        WebElement linkType = waitForElementClickability(driver, By.id("link_type"));

        Select combo = new Select(linkType);
        combo.selectByValue("ExternalLink");
        return "ExternalLink";

    }

    public String linkTypeComboEdit1(WebDriver driver) {
        WebElement linkType = waitForElementClickability(driver, By.id("link_type"));

        Select combo = new Select(linkType);
        combo.selectByValue("InternalLink");
        return "InternalLink";
    }

    public int getIdFromLastRow(WebDriver driver, String attributeName) {
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute(attributeName);
        return Integer.valueOf(id);
    }
}
