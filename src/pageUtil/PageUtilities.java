/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author SonjaAleksa
 */
public class PageUtilities {

    public static WebDriver initWebDriver(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Predavanje 25 DB\\Cas25\\chromedriver.exe");
// System.setProperty("webdriver.chrome.driver", "/Users/qa/Desktop/workspace/Cas23");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;

    }

    public static String getRandomText() {
        return "Test" + (int) (Math.random() * 1000);
    }

    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".te");
    }
    public static String getRandomEmail(){
    return "aaaa".concat(getRandomText()).concat("@students.nyu.edu");
    }
}
