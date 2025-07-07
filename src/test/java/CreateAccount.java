import Pages.CreateAccountPage;
import Pages.HomePage;
import Utilities.CommonUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccount extends Base{

    CreateAccountPage cap;

    //Reusable methods
    public void common(){
        cap.enterEmailForNewAccount(CommonUtilities.emailGenerator());
        cap.clickCreateAccount();
    }





    //------------------------------------------------------------------------------------------------------------------------




    //Actual test cases
    @BeforeMethod
    public void start(){
        driver = initializeWebDriver();
        HomePage home = new HomePage(driver);
        home.clickSignin();
        cap = new CreateAccountPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    @Test(priority = 1,groups = {"Regression"})
    public void RegisterWithValidData(){
            common();
            cap.selectMale();
            cap.enterFirstName(testdata("firstName"));
            cap.enterlastName(testdata("lastName"));
            cap.enterPassword(testdata("password"));
            cap.selectDay("14");
            cap.selectMonth("June");
            cap.selectYear("1999");
            cap.clickSignUpforNewsletter();
            cap.clickRegister();
            String k = cap.getSuccessMsg();
            Assert.assertEquals(k,"Your account has been created.");
            cap.clickSignout();
    }

    @Test(priority = 2,groups = {"Regression"})
    public void RegisterWithBlankSpace(){

        cap.enterEmailForNewAccount(" ");
        cap.clickCreateAccount();
        String k = cap.getInvalidEmailMsg();
        Assert.assertEquals(k,"Invalid email address.");
    }

    @Test(priority = 3,groups = {"Regression"})
    public void RegisterWithExistingEmail(){
        cap.enterEmailForNewAccount(testdata("existingEmail"));
        cap.clickCreateAccount();
        String k = cap.getAlreadyRegisteredMsg();
        Assert.assertEquals(k,"An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }

    @Test(priority = 4,groups = {"Regression"})
    public void RegisterWithPasswordLessthanFiveCharacter(){
        common();
        cap.selectMale();
        cap.enterFirstName(testdata("firstName"));
        cap.enterlastName(testdata("lastName"));
        cap.enterPassword(testdata("lessCharacterPassword"));
        cap.selectDay("14");
        cap.selectMonth("June");
        cap.selectYear("1999");
        cap.clickSignUpforNewsletter();
        cap.clickRegister();
        String k = cap.getInvalidPasswordMsg();
        Assert.assertEquals(k,"passwd is invalid.");

    }

    @DataProvider(name = "excelData")
    public Object[][] getDataFromExcel(){

        Object[][] d = CommonUtilities.readDataFromExcel("Register data");
        return d;
    }

    @Test(dataProvider = "excelData")
    public void combinations(String testID, String description, String gender,
                             String firstName, String lastName, String password,
                             String date, String month, String year, String newsletter,String result) {

        common();
        if(gender.equals("Male")){
            cap.selectMale();
        }

        cap.enterFirstName(firstName);
        cap.enterlastName(lastName);
        cap.enterPassword(password);
        cap.selectDay(date);
        cap.selectMonth(month);
        cap.selectYear(year);
        if (newsletter.equals("Yes")){
            cap.clickSignUpforNewsletter();
        }
        CommonUtilities.takeScreenShot(testID+"Before",driver);
        cap.clickRegister();
        CommonUtilities.takeScreenShot(testID+"After",driver);

    }



}
