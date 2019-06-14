package com.jsystems.qa.frontend.clasicfrontend.test;

import com.jsystems.qa.frontend.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigFrontend {
    WebDriver driver;
    String chromePath;
    String fireFoxPath;

    {
        try {
            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
    }

    @BeforeEach
    public void setUpEach() {

        String browser = Configuration.getBROWSER();

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();

        }
        setDriver();
        driver.get(Configuration.BASE_URL);

    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    private void setDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }
}
