/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.indexPage.IndexSliderPage;
import pages.photo.PhotoPage;

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

}
