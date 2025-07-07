import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Utilities.CommonUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPassword extends Base{

    ForgotPasswordPage fp;

    @BeforeMethod
    public void start(){
        driver = initializeWebDriver();
        HomePage home = new HomePage(driver);
        home.clickSignin();
        fp = new ForgotPasswordPage(driver);
        fp.clickForgotPassword();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void enterValidEmail(){
        fp.enterEmail(testdata("existingEmail"));
        fp.clickRetrivePassword();
        String actual = fp.getSuccessMsg();
        String expected = "A confirmation email has been sent to your address: "+ testdata("existingEmail");
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void enterNoEmail(){
        fp.clickRetrivePassword();
        String actual= fp.getInvalidEmailMsg();
        String expected = "Invalid email address.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void enterUnregisteredEmail(){
        fp.enterEmail(CommonUtilities.emailGenerator());
        fp.clickRetrivePassword();
        String actual = fp.getNoAccountMsg();
        String expected = "There is no account registered for this email address.";
        Assert.assertEquals(actual,expected);

    }

}
