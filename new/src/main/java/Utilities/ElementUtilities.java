package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtilities {

    public static void enterField(WebElement element,String s){

        if(element.isEnabled()& element.isDisplayed()){
            element.clear();
            element.sendKeys(s);
        }
    }

    public static void click(WebElement element){
        if(element.isEnabled()& element.isDisplayed()){
            element.click();
        }
    }

    public static void select(WebElement element,Object s,String a){

        Select select = new Select(element);

        if(a.equalsIgnoreCase("visibletext")){
            select.selectByVisibleText((String) s);
        } else if (a.equalsIgnoreCase("index")) {
            select.selectByIndex((Integer) s);
        } else if (a.equalsIgnoreCase("value")) {
            select.selectByValue((String) s);
        }

    }

}
