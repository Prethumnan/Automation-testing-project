import Pages.CreateAccountPage;
import Pages.HomePage;
import Utilities.CommonUtilities;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Checking extends Base{

    HomePage home;
    JavascriptExecutor js;

    CreateAccountPage cap;

    //Reusable methods
    public void common(){
        cap.enterEmailForNewAccount(CommonUtilities.emailGenerator());
        cap.clickCreateAccount();
    }

    public String testdata(String s){

        String k = testData.getProperty(s);
        return  k;
    }

    //Actual test cases
    @BeforeMethod
    public void start(){
        driver = initializeWebDriver();
        home = new HomePage(driver);
        home.clickSignin();
        cap = new CreateAccountPage(driver);

        js =  (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void nothing(){
        Object[][] data = CommonUtilities.readDataFromExcel("Register data");
        System.out.println(Arrays.deepToString(data));


    }

    public void screenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sc = screenshot.getScreenshotAs(OutputType.FILE);
    }

    }





