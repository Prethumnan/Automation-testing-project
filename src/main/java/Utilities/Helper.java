package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    Actions actions;
    WebDriver driver;

    Alert alert;

    Select select;
    JavascriptExecutor js;


    //Constructor
    public Helper(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }



    //-------------------------------------------------------------------------------------------------------------------------------------------
    //To perform actions


    public void scrollToElement(WebElement e){


        actions.scrollToElement(e).build().perform();
    }

    public void dragAndDrop(WebElement source,WebElement destination){

        actions.dragAndDrop(source,destination).build().perform();;
    }

    public void rightClick(WebElement e){

        actions.contextClick(e).build().perform();
    }

    public void mouseHover(WebElement e){

        actions.moveToElement(e).build().perform();
    }

    public void doubleClick(WebElement e){

        actions.doubleClick(e).build().perform();
    }

    public void pressEnter(){

        actions.sendKeys(Keys.ENTER).build().perform();
    }


    //-------------------------------------------------------------------------------------------------------------------------------------------
    // To handle alerts
    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        getAlert().accept();
    }

    public void dismissAlert(){

        getAlert().dismiss();
    }

    public void getTextFromAlert(){

        getAlert().dismiss();
    }

    public void sentTextToAlert(String s){

        getAlert().sendKeys(s);
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------
    //To handle wait
    public WebElement explicitWait(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return e;
    }

    public void implicitwait(int duration){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //To handle dropdowns
    public Select dropDown(WebElement e){

        Select select = new Select(e);
        return select;
    }


    public void selectByVisibleText(WebElement e,String text){

        dropDown(e).selectByVisibleText(text);
    }

    public void selectByIndex(WebElement e,Integer i){

        dropDown(e).selectByIndex(i);
    }



    //-------------------------------------------------------------------------------------------------------------------------------------------
    //Javascrit executor

    public void clickusingJs(WebElement e){

        js.executeScript("arguments[0].click()",e);

    }

    public void sentKeysUsingJs(WebElement e, String s){

        js.executeScript("arguments[0].value=arguments[1];",e);
    }


}
