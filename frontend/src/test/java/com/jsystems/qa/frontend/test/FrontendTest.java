package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.page.LoginPage;
import com.jsystems.qa.frontend.page.MainWordpressPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrontendTest extends ConfigFrontend {


MainWordpressPage wordpressPage;
LoginPage loginPage;
    @Test
    public void firstFrontTest () {

        wordpressPage = new MainWordpressPage(driver);
//        assertTrue(wordpressPage.buildEWebsite.isDisplayed());
//        assertEquals(wordpressPage.buildEWebsite.getText(), "Build a website");

        assertTrue(wordpressPage.login.isDisplayed());
        assertEquals(wordpressPage.login.getText(), "log in");
        wordpressPage.login.click();
    }
    @Test
    public void LoginTest(){
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.WaitForVisiblityOfElement(wordpressPage.login, 30);
        wordpressPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.WaitForVisiblityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();

    }


//
//        driver.get("https://wordpress.com");
  //      try {
    //        sleep(10000);
      //  } catch (InterruptedException e) {
        //    e.printStackTrace();
//        WebElement login = driver.findElement(By.cssSelector("<a role=\"menuitem\" class=\"x-nav-link x-link\" href=\"//wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F\" title=\"Log In\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\tLog In\t\t\t\t\t\t\t\t\t\t</a>"));
//        assertTrue(login.isDisplayed());
//        assertEquals(login.getText(), "Log in");
//        login.click();
    }


