package ui;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    //Define global objects
    public WebDriver driver;
    public WebDriverWait wait;
    public final int globalDelay = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, globalDelay);
    }

    //Define common Selenium methods to be used by all the page classes

    public void clickVisible(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public void clickVisible(String xpath) {
        clickVisible(By.xpath(xpath));
    }

    public boolean waitForElementToBeVisible(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public void sendTextToVisibleElement(By element, String text) {
        waitForElementToBeVisible(element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void sendTextToVisibleElement(String xpath, String text) {
        sendTextToVisibleElement(By.xpath(xpath), text);
    }

    public String getVisibleElementText(By element) {
        waitForElementToBeVisible(element);
        wait(50);
        return driver.findElement(element).getText();
    }

    public String getVisibleElementText(String xpath) {
        return getVisibleElementText(By.xpath(xpath));
    }

    public String getElementAttribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    public String getElementAttribute(String xpath, String attribute) {
        return getElementAttribute(By.xpath(xpath), attribute);
    }

    public void wait(int delay) {
        Uninterruptibles.sleepUninterruptibly(delay, TimeUnit.MILLISECONDS);
    }

}
