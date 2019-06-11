package com.jsystems.qa.frontend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrontendTest {

    @BeforeAll
    public static void setUpAll(){
        System.setProperty("webdriver.gecko.driver", "D:/firefox/geckodriver.exe");
    }
    WebDriver driver;
    @Test
    public void firstFrontTest () {

         driver = new FirefoxDriver ();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        driver.get("https://wordpress.com");
  //      try {
    //        sleep(10000);
      //  } catch (InterruptedException e) {
        //    e.printStackTrace();
        WebElement login = driver.findElement(By.cssSelector("<a role=\"menuitem\" class=\"x-nav-link x-link\" href=\"//wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F\" title=\"Log In\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\tLog In\t\t\t\t\t\t\t\t\t\t</a>"));
        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log in");
        login.click();
        driver.quit();
    }
}
