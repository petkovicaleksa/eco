/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.indexPage;

import domen.IndexSlider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static pages.basics.LoginPage.wait;
import pages.basics.Page;

/**
 *
 * @author SonjaAleksa
 */
public class IndexSliderPage extends Page {
//     private void linkTypeCombo(WebDriver driver) {
//        WebElement linkType = waitForElementClickability(driver, By.id("link_type"));
//
//        Select combo = new Select(linkType);
//        combo.selectByValue("InternalLink");
//    }

    private void clickOnAddIndex(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String setInternalLinkUrl(WebDriver driver, By locator) {
//      WebElement internalLinkUrl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("internal_link_url")));
//        internalLinkUrl.sendKeys(PageUtilities.getRandomUrl());
        return sendUrlOnField(driver, By.id("internal_link_url"));
    }

    private void photo(WebDriver driver) {
        setPhoto(driver, By.id("index_slide_photo"));
    }

    private void clickOnSave(WebDriver driver) {

        clickOnElement(driver, By.id("new_indexSlide_submit"));
    }

    public IndexSlider createNewIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();


        clickOnElement(driver, By.className("glyphicon-plus"));
        is.setTitle(sendTextOnField(driver, By.id("title")));

        is.setDescription(sendTextOnField(driver, By.id("description")));

        is.setLinkType(linkTypeComboEdit1(driver));
        is.setLinkLabel(sendTextOnField(driver, By.id("link_label")));

        is.setInternalLinkUrl(sendUrlOnField(driver, By.id("internal_link_url")));

        photo(driver);

        clickOnSave(driver);

        WebElement lastRow = findLastRow(driver);
//        WebElement disableButton = lastRow.findElement(By.xpath("//*[@id='rows-table']/tbody/tr[22]/td[7]/div/button[1]"));
//        String id = disableButton.getAttribute("data-index-slide-id");
        String id = lastRow.getAttribute("data-index-slide-id");
        is.setId(Integer.valueOf(id));
        return is;

    }

    public IndexSlider editIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();
//        is.setId(getIdFromWeb(driver));
        choosOptionFromLastRow(driver, By.className("glyphicon-pencil"));
        is.setTitle(sendTextOnField(driver, By.id("title")));
        is.setDescription(sendTextOnField(driver, By.id("description")));

        is.setLinkType(linkTypeComboEdit(driver));
        is.setLinkLabel(sendTextOnField(driver, By.id("link_label")));
        is.setInternalLinkUrl(sendUrlOnField(driver, By.id("external_link_url")));
        photo(driver);
        clickOnSave(driver);
//    
        WebElement lastRow = findLastRow(driver);

        String id = lastRow.getAttribute("data-index-slide-id");
        is.setId(Integer.valueOf(id));
        return is;
    }

    public IndexSlider deleteIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();

        choosOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return is;
    }

    public int getIdFromWeb(WebDriver driver) {
        return getIdFromLastRow(driver, "data-photo-gallery-id");
    }
}
