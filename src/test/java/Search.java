import Pages.SearchPage;
import Utilities.CommonUtilities;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search extends  Base{

    SearchPage sp;

    @BeforeMethod
    public void start(){
        driver= initializeWebDriver();
        sp = new SearchPage(driver);
    }

    @AfterMethod

    public void tearDown() {
        if (driver != null) //If webdriver was initialized only this condition will work
        {
            driver.quit();
        }
    }

   @DataProvider(name="search")
    public Object[][] search(){
        Object[][] k =CommonUtilities.data(new ArrayList<>(Arrays.asList("dress","T shirt","blouse","printed dress","summer dress")));
        return k;
    }

    @Test(dataProvider = "search")
    public void searchWithValidProducts(String i) throws InterruptedException {

        System.out.println("Testing search for: " + i);
        sp.search(i);
        sp.submit();
        boolean displayed = sp.isDisplayed();
        System.out.println("Results displayed: " + displayed);
        Assert.assertTrue(displayed, "Search results are not displayed");
    }

    @DataProvider(name="invalidInputs")
    public Object[][] invalidInput(){

        Object[][] k= CommonUtilities.data(new ArrayList<>(Arrays.asList("123456","*&^%$","bike","phone")));
        return k;
    }

    @Test(dataProvider = "invalidInputs")
    public void searchWithInvalidInputs(String i) throws InterruptedException {

        sp.search(i);
        sp.submit();
        String actual = sp.getNoResultsMsg();
        String expected = "No results were found for your search";
        Assert.assertTrue(actual.contains(expected),"Something went wrong");
    }



}
