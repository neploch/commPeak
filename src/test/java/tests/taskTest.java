package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class taskTest extends BaseTest {

    //Test case parameters. Normally will be read from external files.
    //Set here for reducing code complexity
    String version38 = "3.8";
    String october2024 = "2024-10";

    @Test(priority = 1, groups= {"Sanity"}, description = "Performs steps defined in home assignment spec")
    public void homeAssignment() {
        googleHomePage.openGoogle();
        googleHomePage.searchAndOpenPythonDownloads();
        String downloadLatestPythonBtnText = pythonOrgDownloadsPage.getDownloadLatestPythonBtnText();
        String downloadLatestPythonBtnLink = pythonOrgDownloadsPage.getDownloadLatestPythonBtnLink();
        Assert.assertTrue(downloadLatestPythonBtnLink.contains(downloadLatestPythonBtnText),
                "The text inside 'Download Python' button is not compatible with the button `href` content");
        String actualEOS = pythonOrgDownloadsPage.getVersionEndOfSupport(version38);
        Assert.assertEquals(actualEOS, october2024, "End of support of " + version38 + " found not as expected");
    }

}
