/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author SonjaAleksa
 */
public class LoginPage extends Page {

    public static WebDriver driver;
    public static WebDriverWait wait;
////

    public HomePage login(WebDriver driver) {
        driver.get("http://ecotest.school.cubes.rs/admin_session/login");

        WebElement username = waitForWebElement(driver, By.className("form-control"));
        username.sendKeys("admin");


        WebElement password = waitForWebElement(driver, By.name("password"));
        password.sendKeys("cubesqa");


        WebElement login = waitForWebElement(driver, By.className("btn-success"));
        login.click();
         HomePage hp = new HomePage();
        return hp;
// 

    }
}
