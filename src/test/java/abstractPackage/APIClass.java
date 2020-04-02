package abstractPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class APIClass {

    protected static WebDriver driver;


    public abstract WebDriver getDriver();

    public void open(String url) {
        getDriver().get(url);
    }

    //method never used
    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }


    public void delay(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            //logger should be used to print the exception
            e.printStackTrace();
        }
    }

    public void maximizeWindow(){
       driver.manage().window().maximize();
    }
}
