package ui.Pages;

import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class PythonOrgDownloadsPage extends BasePage {
    public PythonOrgDownloadsPage(WebDriver driver) {
        super(driver);
        setDownloadLatestPythonBtnXpath();
    }

    //Page elements locators
    String downloadLatestPythonForWindows = "//div[@class='download-os-windows']";
    String downloadLatestPythonForMac = "//div[@class='download-os-macos']";
    String downloadLatestPythonForLinux = "//div[@class='download-os-source']";
    String downloadLatestPythonBtn = "//p[@class='download-buttons']//a[@class='button']";
    String activeReleaseTable = "//div[contains(@class,'active-release-list')]";
    String versionEndOfSupport = activeReleaseTable + "//li[.//span[@class='release-version'][text()='%s']]//span[@class='release-end']";
    String OS = System.getProperty("os.name", "unknown").toLowerCase();
    String actualDownloadLatestPythonBtn;

    //Page methods
    //Set actualDownloadLatestPythonBtn XPath accordingly to this machine OS
    void setDownloadLatestPythonBtnXpath() {
        if (OS.contains("wind")) {
            actualDownloadLatestPythonBtn = downloadLatestPythonForWindows + downloadLatestPythonBtn;
        } else if (OS.contains("mac")) {
            actualDownloadLatestPythonBtn = downloadLatestPythonForMac + downloadLatestPythonBtn;
        } else {
            actualDownloadLatestPythonBtn = downloadLatestPythonForLinux + downloadLatestPythonBtn;
        }
    }

    public String getDownloadLatestPythonBtnText() {
        String btnText = getVisibleElementText(actualDownloadLatestPythonBtn);
        String[] btnTexts = btnText.split(" ");
        return btnTexts[2];
    }

    public String getDownloadLatestPythonBtnLink() {
        return getElementAttribute(actualDownloadLatestPythonBtn, "href");
    }

    public String getVersionEndOfSupport(String version) {
        String versionEOS = String.format(versionEndOfSupport, version);
        return getVisibleElementText(versionEOS);
    }

}
