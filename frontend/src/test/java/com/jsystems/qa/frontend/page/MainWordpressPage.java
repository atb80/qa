package com.jsystems.qa.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css ="<a role=\"menuitem\" class=\"x-nav-link x-link\" href=\"//wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F\" title=\"Log In\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\tLog In\t\t\t\t\t\t\t\t\t\t</a>" )
    public WebElement buildEWebsite;

    //public WebElement login = driver.findElement(By.cssSelector("<a role=\"menuitem\" class=\"x-nav-link x-link\" href=\"//wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F\" title=\"Log In\">\n" +
        //    "\t\t\t\t\t\t\t\t\t\t\tLog In\t\t\t\t\t\t\t\t\t\t</a>"));

}
