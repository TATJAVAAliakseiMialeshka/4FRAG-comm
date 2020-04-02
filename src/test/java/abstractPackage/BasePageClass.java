package abstractPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class BasePageClass extends APIClass {


    private static final int DRIVER_WAIT_TIME = 60;

    @Override
    public WebDriver getDriver() {
        return driver;
    }


    public WebDriver initializeDriver() {
        //this is a hardcoded local constant - will break on other than your machine. can try to set in systems variables of your pc, not in the code.
        //or at least .properties file should be used for such constants
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    //you're not setupping wait here, you actually trying to wait element
    //better call method as waitForExpectedElement or similar
    public WebElement setUpWaiterForWebElement(By webElementLocator) {
        //no magic numbers - have it as class constant
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(webElementLocator));
    }

    //could be useful to have a method for waiting not only for element to appear but also after some actions are performed:
    //example

    // you than can call this method after any .click() or at least when after clicks when new page opens.
    // Will greatly help to reduce failures in cases of high load on the side, when it's freezes etc.

    public void waitPageIsLoadedAndJQueryIsProcessed() {
        waitPageIsLoaded();
        waitJQueryIsProcessed();
    }

    public void waitPageIsLoaded() {
        try {
            ExpectedCondition<Boolean> expectedCondition = driver -> getDocumentReadyState().equals("complete");
            Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
            wait.until(expectedCondition);
        } catch (Exception ex) {
            LOGGER.warning("Fail waiting for document ready state. Current state:" + getDocumentReadyState());
        }
    }

    private String getDocumentReadyState() {
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return document.readyState");
    }

    private void waitJQueryIsProcessed() {
        new WebDriverWait(getDriver(), DRIVER_WAIT_TIME) {
        }.until((ExpectedCondition<Boolean>) driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return typeof jQuery != 'undefined' && jQuery.active == 0"));
    }


    @BeforeClass
    public void setUp() {
        initializeDriver();
    }

    @AfterClass
    public void closeDown() {
        // are this waiting after each test necessary? looks like a waiting of resources
        delay(2000);
        driver.quit();
    }
}