package com.jsystems.qa.frontend.clasicfrontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.clasicfrontend.test.page.LoginPage;
import com.jsystems.qa.frontend.clasicfrontend.test.page.MainWordpressPage;
import com.jsystems.qa.frontend.clasicfrontend.test.page.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrontendTest extends ConfigFrontend {
    MainWordpressPage wordporessPage;
    LoginPage loginPage;
    UserPage userPage;

    @Test
    public void firstFrontTest() {
        wordporessPage = new MainWordpressPage(driver);
        assertTrue(wordporessPage.buildEWebsite.isDisplayed());
        assertEquals(wordporessPage.buildEWebsite.getText(), "Build a website,");
        assertTrue(wordporessPage.login.isDisplayed());
        assertEquals(wordporessPage.login.getText(), "Log In");
        wordporessPage.login.click();
    }

    @Test
    public void loginTest() {
        login();

        userPage = new UserPage(driver);
        userPage.WaitForVisiblityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());

//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        driver.switchTo().alert();

    }

    @Test
    public void loginActionTest() {

        wordporessPage = new MainWordpressPage(driver);
        wordporessPage.WaitForVisiblityOfElement(wordporessPage.login, 30);
        wordporessPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.WaitForVisiblityOfElement(loginPage.emailInput, 30);

        Actions action = new Actions(driver);
        action
                .moveToElement(loginPage.emailInput)
                .sendKeys(Configuration.LOGIN)
                .sendKeys(Keys.chord(Keys.ENTER))
                .build()
                .perform();

        loginPage.WaitForVisiblityOfElement(loginPage.passwordInput, 30);
        assertTrue(loginPage.buttonContinue.getText().equals("Log In"));
    }

    private void login() {
        wordporessPage = new MainWordpressPage(driver);
        wordporessPage.WaitForVisiblityOfElement(wordporessPage.login, 30);
        wordporessPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.WaitForVisiblityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.WaitForVisiblityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }


}


