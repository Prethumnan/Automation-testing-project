package Pages;

import Utilities.ElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends RootPage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    //WebElements
    @FindBy(linkText = "Sign in")
    private WebElement signin;

    //Methods

    public void clickSignin(){
        ElementUtilities.click(signin);
    }






}
