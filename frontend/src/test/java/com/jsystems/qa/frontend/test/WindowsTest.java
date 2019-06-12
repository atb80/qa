package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;

public class WindowsTest extends ConfigFrontend {
    @Test
    public void testWindows()  {
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        firstPageWindowHandle = driver.getWindowHandle();

        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        driver.findElement(By.linkText("Open page in a new window")).click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

    }
}
