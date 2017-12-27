/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.indexPage.IndexSliderPage;
import pages.photo.PhotoPage;
import page.users.UsersPage;
import static pages.basics.LoginPage.driver;
import static pages.basics.LoginPage.wait;

/**
 *
 * @author SonjaAleksa
 */
public class HomePage extends Page {

    public IndexSliderPage clickOnIndexSlider(WebDriver driver) {
        clickOnElement(driver, By.className("fa-sliders"));
        IndexSliderPage ip = new IndexSliderPage();
        return ip;
    }

    public PhotoPage clickOnPhotoGalery(WebDriver driver) {

        clickOnElement(driver, By.className("fa-photo"));
        PhotoPage ph = new PhotoPage();
        return ph;
    }

    public UsersPage clickOnAllUsers(WebDriver driver) {

        clickOnElement(driver, By.linkText("All Users"));

        waitForWebElement(driver, By.id("rows-table"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsersPage up = new UsersPage();
        return up;
    }

}
