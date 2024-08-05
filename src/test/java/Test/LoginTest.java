package Test;

import Core.DriverManager;
import Core.Element;
import Core.ExtentReport.ExtentTestManager;
import Core.ExtentReport.ReportListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ReportListener.class)
public class LoginTest {
    Element inputSearch = new Element(By.id("firstName"));

    @BeforeClass
    public void setUp() {
        DriverManager.initializeBrowser("chrome");
        ExtentTestManager.logMessage("bat dau test");
    }

    @Test
    public void InitialDriverManagerTest() throws InterruptedException {
        DriverManager.webDriver.get("https://demoqa.com/automation-practice-form");
       inputSearch.enterText("VInh dẹp trai");
       Thread.sleep(5000);

    }

    @AfterClass
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
