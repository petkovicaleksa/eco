/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexSlider;

import db.DbConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.HomePage;
import pages.basics.LoginPage;
import pages.indexPage.IndexSliderPage;
import setup.SeleniumProperties;
import domen.IndexSlider;
import org.junit.Assert;

/**
 *
 * @author SonjaAleksa
 */
public class TestIndexSlider {

    private static WebDriver driver;

    private IndexSliderPage indexSliderPage;

    private static LoginPage loginPage;
    private static HomePage homePage;

    @BeforeClass
    public static void testLogin() {
        driver = PageUtilities.initWebDriver(driver);
        loginPage = new LoginPage();
        SeleniumProperties.init();
        homePage = loginPage.login(driver);
        DbConnection.getConnection();
    }

    @AfterClass
    public static void tearDownClass() {
        DbConnection.close();
        driver.quit();
    }

    @Before
    public void testOpenIndexSlider() {
        System.out.println("Page title is: " + driver.getTitle());
        indexSliderPage = homePage.clickOnIndexSlider(driver);

    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testCreateNewIndexSlider() {
        IndexSlider indexWeb = indexSliderPage.createNewIndexSlider(driver);

        System.out.println("IndexSlider is saved");
        IndexSlider indexDb = DbConnection.getIndex("SELECT * FROM `cms_index_slides` WHERE id = " + indexWeb.getId());

        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
        Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkType(), indexDb.getLinkType());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
    }

    @Test
    public void testEditIndexSlider() {
        IndexSlider indexWeb = indexSliderPage.editIndexSlider(driver);

        IndexSlider indexDb = DbConnection.getIndex("SELECT * FROM `cms_index_slides` WHERE id = " + indexWeb.getId());
        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
        Assert.assertEquals(indexWeb.getDescription(), indexDb.getDescription());
        Assert.assertEquals(indexWeb.getLinkType(), indexDb.getLinkType());
        Assert.assertEquals(indexWeb.getLinkLabel(), indexDb.getLinkLabel());
    }

    @Test
    public void testDeleteIndexSlider() {
        IndexSlider indexDel = indexSliderPage.deleteIndexSlider(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_index_slides` WHERE id =" + indexDel.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }

}
