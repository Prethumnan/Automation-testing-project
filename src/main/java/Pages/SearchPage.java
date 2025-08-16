package Pages;

import Utilities.CommonUtilities;
import Utilities.ElementUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends RootPage{

    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }

    @FindBy(id = "search_query_top")
    private WebElement search;

    @FindBy(name = "submit_search")
    private WebElement submitSearch;

    @FindBy(xpath = "//p[contains(text(),'Please enter a search keyword')]")
    private WebElement searchKeyword;








    public void search(String a){
        ElementUtilities.enterField(search,a);
    }

    public void submit(){
        ElementUtilities.click(submitSearch);
    }

    public boolean isDisplayed() {
        try {
            List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class,'product_list')]//a[@class='product-name']")));

            ArrayList<String> prod = new ArrayList<>();
            for(WebElement i : results) {
                System.out.println(i.getText());
                prod.add(i.getText());
            }
            return prod.size() >= 1;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSearchKeywordMsg(){

        return searchKeyword.getText();
    }

    public String getNoResultsMsg(){
        String path = "//p[contains(text(),'No results were found for your search')]";
        WebElement e = CommonUtilities.wait(driver,path);
        return e.getText();

    }








    }


