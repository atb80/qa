package com.jsystems.qa.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.IdentityHashMap;

public class LoginPage extends BasePage {

    public IdentityHashMap<Object, Object>.EntrySet passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public WebElement emailInput = driver.findElement(By.id("//*[@id=\"usernameOrEmail\"]"));
    public WebElement buttonContinue = driver.findElement(By.cssSelector("/html/body/div[1]/div/div/div[1]/div/main/div/div[1]/div/form/div[1]/div[2]/button"));

}
