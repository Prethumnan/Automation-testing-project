import Pages.HomePage;
import Pages.SignPage;
import Utilities.CommonUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signin extends  Base{

    SignPage sign;

    @BeforeMethod
    public void start(){
        driver = initializeWebDriver();
        HomePage home = new HomePage(driver);
        home.clickSignin();
        sign = new SignPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void signinWithValidData(){
        sign.enterEmail(testdata("existingEmail"));
        sign.enterPassword(testdata("password"));
        sign.clickSignin();
        String k = sign.getWelcomeMsg();
        Assert.assertEquals(k,"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void signinWithNoData(){
        sign.clickSignin();
        String msg= sign.getEmailErrorMsg();
        Assert.assertEquals(msg,"An email address required.");
    }

    @Test
    public void signinWithValidEmailAndInvalidPassword(){
        sign.enterEmail(testdata("existingEmail"));
        sign.enterPassword(testdata("wrongPassword"));
        sign.clickSignin();
        String msg= sign.getAuthenticationFailedMsg();
        Assert.assertEquals(msg,"Authentication failed.");
    }

    @Test(invocationCount = 5)
    public void signinWithInvalidEmailAndInvalidPassword(){
        sign.enterEmail(CommonUtilities.emailGenerator());
        sign.enterPassword(testdata("wrongPassword"));
        sign.clickSignin();
        String msg= sign.getAuthenticationFailedMsg();
        Assert.assertEquals(msg,"Authentication failed.");
    }


}
