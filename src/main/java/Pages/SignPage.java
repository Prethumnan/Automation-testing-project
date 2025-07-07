package Pages;

import Utilities.CommonUtilities;
import Utilities.ElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignPage extends RootPage{

    public SignPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="passwd")
    private WebElement passwd;



    @FindBy(id = "SubmitLogin")
    private WebElement signin;


    @FindBy(xpath = "//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
    private WebElement welcomeMsg;

    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    private WebElement AuthenticationFailedMsg;



    public void enterEmail(String s){
        ElementUtilities.enterField(email,s);
    }

    public void enterPassword(String s){
        ElementUtilities.enterField(passwd,s);
    }



    public void clickSignin(){
        ElementUtilities.click(signin);
    }

    public String getWelcomeMsg(){

        String k = welcomeMsg.getText();
        return  k;
    }

    public String getEmailErrorMsg(){
        String k = emailErrorMsg.getText();
        return k;
    }

    public String getAuthenticationFailedMsg(){
        String k = AuthenticationFailedMsg.getText();
        return k;
    }




}
