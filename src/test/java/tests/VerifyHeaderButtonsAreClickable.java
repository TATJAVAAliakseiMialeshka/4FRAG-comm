package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class VerifyHeaderButtonsAreClickable extends MainPage {


    //test should have an assertion. these tests only open something, not verify anything.
    // these are only intermidiary steps which could be used as part of other tests.
    // You could vefiry that buttons is visible, not clickable.
    // For example make 1 parameterized test which will check that all these buttons are visible.
    @Test
    public void testLoginButtonIsClickable(){
        LoginPage loginPage = new MainPage()
                .openHomePage()
                .openLoginPage();

    }

    @Test
    public void testDeliveryButtonIsClickable(){
        DeliveryPage deliveryPage = new MainPage()
                .openHomePage()
                .openDeliveryPage();

    }

    @Test
    public void testPaymentButtonIsClickable(){
        PaymentPage paymentPage = new MainPage()
                .openHomePage()
                .openPaymentPage();

    }

    @Test
    public void testDiscountSystemButtonIsClickable(){
        DiscountSystemPage discountSystemPage = new MainPage()
                .openHomePage()
                .openDiscountSystemPage();

    }

    @Test
    public void testWarrantyButtonIsClickable(){
        WarrantyPage warrantyPage = new MainPage()
                .openHomePage()
                .openWarrantyPage();

    }

    @Test
    public void testBookmarksButtonIsClickable(){
        BookmarksPage bookmarksPage = new MainPage()
                .openHomePage()
                .openBookmarksPage();

    }

    @Test
    public void testComparasionOfProductsButtonIsClickable(){
        ComparasionListPage comparasionListPage = new MainPage()
                .openHomePage()
                .openComparasionListPage();

    }

    @Test
    public void testBasketButtonIsClickable(){
         BasketPage basketPage = new MainPage()
                .openHomePage()
                .openBasketPage();

    }






}
