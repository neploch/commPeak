package tests;

import com.google.inject.Injector;
import com.google.inject.Module;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import java.util.*;

import ui.Pages.GoogleHomePage;
import ui.Pages.PythonOrgDownloadsPage;

public class BaseTest implements ITestContext {

    public WebDriver driver;

    public GoogleHomePage googleHomePage;
    public PythonOrgDownloadsPage pythonOrgDownloadsPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext con) {

        //Define and initialize Chrome WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Passing the driver object into ITestContext con for creating screenshots
        con.setAttribute("WebDriver", driver);

        // maximize the browser window
        driver.manage().window().maximize();

        //initialize page class objects
        googleHomePage = new GoogleHomePage(driver);
        pythonOrgDownloadsPage = new PythonOrgDownloadsPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeMethod() {
        driver.quit();
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public Set<String> getAttributeNames() {
        return null;
    }

    @Override
    public Object removeAttribute(String s) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Date getStartDate() {
        return null;
    }

    @Override
    public Date getEndDate() {
        return null;
    }

    @Override
    public IResultMap getPassedTests() {
        return null;
    }

    @Override
    public IResultMap getSkippedTests() {
        return null;
    }

    @Override
    public IResultMap getFailedButWithinSuccessPercentageTests() {
        return null;
    }

    @Override
    public IResultMap getFailedTests() {
        return null;
    }

    @Override
    public String[] getIncludedGroups() {
        return new String[0];
    }

    @Override
    public String[] getExcludedGroups() {
        return new String[0];
    }

    @Override
    public String getOutputDirectory() {
        return null;
    }

    @Override
    public ISuite getSuite() {
        return null;
    }

    @Override
    public ITestNGMethod[] getAllTestMethods() {
        return new ITestNGMethod[0];
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public Collection<ITestNGMethod> getExcludedMethods() {
        return null;
    }

    @Override
    public IResultMap getPassedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getSkippedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getFailedConfigurations() {
        return null;
    }

    @Override
    public XmlTest getCurrentXmlTest() {
        return null;
    }

    @Override
    public List<Module> getGuiceModules(Class<? extends Module> aClass) {
        return null;
    }

    @Override
    public Injector getInjector(List<Module> list) {
        return null;
    }

    @Override
    public Injector getInjector(IClass iClass) {
        return null;
    }

    @Override
    public void addInjector(List<Module> list, Injector injector) {

    }

}