/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.photo;

import domen.Photo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.basics.Page;

/**
 *
 * @author SonjaAleksa
 */
public class PhotoPage extends Page {

    private void photo(WebDriver driver) {
        setPhoto(driver, By.id("photo_gallery_leading_photo"));

    }

    public Photo createNewPhotoGalery(WebDriver driver) {
        Photo ph = new Photo();

        clickOnElement(driver, By.className("glyphicon-plus"));
        ph.setTitle(sendTextOnField(driver, By.id("title")));

        ph.setDescription(sendTextOnField(driver, By.id("description")));
        photo(driver);
        clickOnElement(driver, By.id("new_photoGallery_submit"));
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute("data-photo-gallery-id");
        ph.setId(Integer.valueOf(id));
        return ph;
    }

    public Photo editPhotoGalery(WebDriver driver) {
        Photo ph = new Photo();

        choosOptionFromLastRow(driver, By.className("glyphicon-pencil"));
        ph.setTitle(sendTextOnField(driver, By.id("title")));
        ph.setDescription(sendTextOnField(driver, By.id("description")));
        photo(driver);
        clickOnElement(driver, By.id("new_photoGallery_submit"));
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute("data-photo-gallery-id");
        ph.setId(Integer.valueOf(id));
        return ph;
    }

    public Photo deletePhotoGalery(WebDriver driver) {
        Photo ph = new Photo();

        choosOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return ph;
    }
}
