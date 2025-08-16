package Pages;

import Utilities.ElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends RootPage{

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //WebElements

    @FindBy(id="email_create")
    private WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccount;

    @FindBy(id="id_gender1")
    private WebElement male;

    @FindBy(id="id_gender2")
    private WebElement Female;

    @FindBy(id="customer_firstname")
    private WebElement firstName;

    @FindBy(id="customer_lastname")
    private WebElement lastName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="days")
    private WebElement days;

    @FindBy(id="months")
    private WebElement months;

    @FindBy(id="years")
    private WebElement years;

    @FindBy(id="newsletter")
    private WebElement newsletter;

    @FindBy(id="submitAccount")
    private WebElement register;

    @FindBy(xpath = "//p[contains(text(),'Your account has been created.')]")
    private WebElement successMsg;

    @FindBy(xpath = "//li[contains(text(),'An account using this email address has already been registered. Please enter a valid password or request a new one.')]")
    private WebElement alreadyRegistered;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    private WebElement invalidEmail;

    @FindBy(linkText = "Sign out")
    private  WebElement signout;

    @FindBy(xpath = "//li[contains(text(),'is invalid.')]")
    private WebElement invalidPassword;


    //Methods

    public void selectMale(){
        ElementUtilities.click(male);
    }

    public void selectFemale(){
        ElementUtilities.click(Female);
    }

    public void enterFirstName(String s){
        ElementUtilities.enterField(firstName,s);
    }

    public void enterlastName(String s){
        ElementUtilities.enterField(lastName,s);
    }

    public void enterPassword(String s){
        ElementUtilities.enterField(password,s);
    }

    public void selectDay(String s){
        ElementUtilities.select(days,"visibletext",s);
    }

    public void selectMonth(String s){
        ElementUtilities.select(months,"visibletext",s);
    }

    public void selectYear(String s){
        ElementUtilities.select(years,"visibletext",s);
    }

    public void clickSignUpforNewsletter(){
        ElementUtilities.click(newsletter);
    }

    public void clickRegister(){
        ElementUtilities.click(register);
    }

    public String getSuccessMsg(){

        String msg = successMsg.getText();
        return  msg;
    }

    public String getAlreadyRegisteredMsg(){

        String k = alreadyRegistered.getText();
        return  k;
    }

    public String getInvalidEmailMsg(){

        String invalid = invalidEmail.getText();
        return  invalid;
    }

    public void enterEmailForNewAccount(String e){
        ElementUtilities.enterField(createEmail,e);
    }

    public void clickCreateAccount(){
        ElementUtilities.click(createAccount);
    }

    public void clickSignout(){

        ElementUtilities.click(signout);
    }

    public String getInvalidPasswordMsg(){

        String invalidpass= invalidPassword.getText();
        return  invalidpass;

    }






}
