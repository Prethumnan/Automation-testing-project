package Pages;

import Utilities.ElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends RootPage{

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(xpath = "//span[contains(text(),'Retrieve Password')]")
    private WebElement retrivePassword;

    @FindBy(xpath = "//p[contains(text(),'A confirmation email has been sent to your address: ')]")
    private WebElement successMsg;

    @FindBy(xpath = "//ol/li[contains(text(),'Invalid email address.')]")
    private WebElement invalidEmailMsg;

    @FindBy(xpath = "//ol/li[contains(text(),'There is no account registered for this email address.')]")
    private WebElement noAccountMsg;


    public void clickForgotPassword(){
        ElementUtilities.click(forgotPassword);
    }

    public void enterEmail(String s){
        ElementUtilities.enterField(email,s);
    }

    public void clickRetrivePassword(){
        ElementUtilities.click(retrivePassword);
    }



    public String getSuccessMsg(){

        String k = successMsg.getText();
        return  k;
    }

    public String getInvalidEmailMsg(){

        String msg = invalidEmailMsg.getText();
        return  msg;
    }

    public String getNoAccountMsg(){

        String msg = noAccountMsg.getText();
        return  msg;
    }
}
