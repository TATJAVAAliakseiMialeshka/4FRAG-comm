package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAreaPage;


public class VerifyLoginFunctionality extends MainPage {

    // again, where are all the assertions?
    // the test can do multiple steps, but in the end, it should check something, otherwise its not a test.
    //you could do you steps and then for exapmle check that you login form was successfully submitted
    @Test
    public void testLoginOption() {
       PersonalAreaPage personalArea = new MainPage()
               .openHomePage()
               .openLoginPage()
               .fillOutEmailField()
               .fillOutPasswordField();

   }
}
