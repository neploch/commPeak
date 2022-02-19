package ui.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class GoogleHomePage extends BasePage {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //Page elements locators
    String googleHomeUrl = "https://www.google.com/";
    String searchInput = "//input[@name='q']";
    String python = "python";
    String downloadPythonLink = "//a[contains(@href,'python.org/downloads')]";

    //Page methods

    public void openGoogle() {
        driver.get(googleHomeUrl);
    }

    public void searchAndOpenPythonDownloads() {
        clickVisible(searchInput);
        sendTextToVisibleElement(searchInput, python + Keys.ENTER);
        clickVisible(downloadPythonLink);
    }

}
