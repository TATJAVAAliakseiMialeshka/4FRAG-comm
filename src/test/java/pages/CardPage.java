package pages;

import abstractPackage.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CardPage extends BasePageClass {

    // constants should be private static final
    //it's just a constant. 'locator' is redundant. moreover, constants have a convention - capitalize!
    // example. use it in all places.
    // private static final By SET_UP_ORDER =

    //NOTE
    //better to use 'locator' or 'xpath' in name when they're dynamic (have parameters)
    //ex:
    // private static final String SET_UP_ORDER_XPATH = "//a[text()='%s']";
    // then in calls in parameterized method. Common practice when you need to work with the element with dynamic content, for reusing xpath in many places etc.
    //     public CardPage initiateOrder(String linkText) {
    //        WebElement buyButton = setUpWaiterForWebElement((By.xpath(String.format(SET_UP_ORDER_XPATH, linkTExt)));
    //        buyButton.click();
    //        return this;
    //    }
    private By setUpOrderLocator = By.xpath("//a[text()='Оформить заказ']");



    public CardPage initiateOrder() {
        WebElement buyButton = setUpWaiterForWebElement(setUpOrderLocator);
        buyButton.click();
        return this;
    }
}
