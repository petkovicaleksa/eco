/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photo;

import db.DbConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUtil.PageUtilities;
import pages.basics.HomePage;
import pages.basics.LoginPage;
import pages.indexPage.IndexSliderPage;
import pages.photo.PhotoPage;
import setup.SeleniumProperties;
import domen.Photo;
import org.junit.Assert;
/**
 *
 * @author SonjaAleksa
 */
public class TestPhoto {
    
  private static WebDriver driver;

    private PhotoPage photoPage;

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
        //         DbConnection.close();
//         driver.quit();
    }
    
    @Before
    public void testOpenPhotoGalery() {
        photoPage = homePage.clickOnPhotoGalery(driver);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testCreateNewPhotoGalery() {
     Photo photoWeb = photoPage.createNewPhotoGalery(driver);
        Photo photoDb = DbConnection.getPhoto("SELECT * FROM `cms_photo_galleries` WHERE id ="+photoWeb.getId());
         Assert.assertEquals(photoWeb.getId(), photoDb.getId());
//         Assert.assertEquals(photoWeb.getTitle(), photoDb.getTitle());
//         Assert.assertEquals(photoWeb.getDescription(), photoDb.getDescription());
     }
     
     @Test
     public void testEditPhotoGalery(){
     Photo photoWeb = photoPage.editPhotoGalery(driver);
       Photo photoDb = DbConnection.getPhoto("SELECT * FROM `cms_photo_galleries` WHERE id ="+photoWeb.getId());
        Assert.assertEquals(photoWeb.getId(), photoDb.getId());
         Assert.assertEquals(photoWeb.getTitle(), photoDb.getTitle());
     
         Assert.assertEquals(photoWeb.getDescription(), photoDb.getDescription());
     }
     
     @Test
     public void testDeletePhotoGalery(){
     Photo photoDel = photoPage.deletePhotoGalery(driver);
     Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_index_slides` WHERE id ="+photoDel.getId());
         Assert.assertEquals(Boolean.TRUE, isDeleted);
     }
}
