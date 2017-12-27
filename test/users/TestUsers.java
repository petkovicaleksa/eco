/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import db.DbConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import pages.basics.HomePage;
import pages.basics.LoginPage;
import page.users.UsersPage;
import pageUtil.PageUtilities;
import setup.SeleniumProperties;
import domen.Users;
import org.junit.Assert;

/**
 *
 * @author SonjaAleksa
 */
public class TestUsers {

    private static WebDriver driver;

    private UsersPage usersPage;

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
    public void setUp() {
        System.out.println("Page title is: " + driver.getTitle());
        usersPage = homePage.clickOnAllUsers(driver);
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testCreateNewUser() throws InterruptedException {
        Users userWeb = usersPage.craateNewUser(driver);
        Users userDb = DbConnection.getUser("SELECT * FROM `cms_users` WHERE id = " + userWeb.getId());
        Assert.assertEquals(userWeb.getId(), userDb.getId());
        Assert.assertEquals(userWeb.getUserName(), userDb.getUserName());
        Assert.assertEquals(userWeb.getFirstName(), userDb.getFirstName());
        Assert.assertEquals(userWeb.getLastName(), userDb.getLastName());
        Assert.assertEquals(userWeb.getEmail(), userDb.getEmail());
    }

    @Test
    public void testEditUser() throws InterruptedException {
        Users userWeb = usersPage.editUser(driver);
        Users userDb = DbConnection.getUser("SELECT * FROM `cms_users` WHERE id = " + userWeb.getId());
        Assert.assertEquals(userWeb.getId(), userDb.getId());
        Assert.assertEquals(userWeb.getUserName(), userDb.getUserName());
        Assert.assertEquals(userWeb.getFirstName(), userDb.getFirstName());
        Assert.assertEquals(userWeb.getLastName(), userDb.getLastName());
        Assert.assertEquals(userWeb.getEmail(), userDb.getEmail());
    }

    @Test
    public void testDeleteUser() throws InterruptedException {
        Users userWeb = usersPage.deleteUser(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_users` WHERE id = " + userWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
