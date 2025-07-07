package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommonUtilities {

    public CommonUtilities(){

    }

    public static ExtentReports generateExtentReport(){

        ExtentReports extentReports = new ExtentReports();
        File file = new File(System.getProperty("user.dir")+"/ExtentReports/ExtentReport.html");
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);

        extentSparkReporter.config().setReportName("Automation practice");
        extentSparkReporter.config().setDocumentTitle("Automation");
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Name","prethumnan");
        extentReports.setSystemInfo("Role","Automation tester");
        extentReports.setSystemInfo("Experience","Fresher and new to automation");

        return extentReports;

    }

    public static String takeScreenShot(String name,WebDriver driver){

        String destination = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try{
            FileHandler.copy(screenshot,new File(destination));
        }catch (Throwable e){
            e.printStackTrace();
        }

        return destination;

    }

    // To read data from excel
    public static Object[][] readDataFromExcel(String name){

        File file = new File(System.getProperty("user.dir")+"/src/main/java/TestData/TestData.xlsx");
        XSSFWorkbook workbook = null;
        try{
            FileInputStream fs = new FileInputStream(file);
            workbook = new XSSFWorkbook(fs);
        }catch (Throwable e){
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(name);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for(int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i+1);
            for(int j=0;j<cols;j++){
                XSSFCell cell = row.getCell(j);
                CellType type = cell.getCellType();

                switch (type){
                    case STRING :
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j]= Integer.toString((int) cell.getNumericCellValue());
                        break;

                    case BLANK:
                        data[i][j] = "";
                        break;
                }
            }
        }

        return  data;
    }


    // To generate random emailId
    public static String emailGenerator(){
        Random rand = new Random();
        int num = rand.nextInt(2000);
        String email = "prethumnan"+Integer.toString(num)+"@gmail.com";
        return  email;
    }

    //To handle alerts

    public static void acceptAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // To handle actions

    public static void rClick(WebDriver driver, WebElement e){
        Actions actions = new Actions(driver);
        actions.contextClick(e);
    }


    //Explicit wait
    public static WebElement wait(WebDriver driver,String i){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement k = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(i)));
        return k;
    }

    public static List<WebElement> waits(WebDriver driver,String i){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> k = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(i)));
        return k;

    }

    //To return 2d array for dataprovider

    public static Object[][] data(ArrayList<String> a){

        List<String> inv = a;
        int size = inv.size();
        Object[][] data = new Object[size][1];

        for(int i =0;i<size;i++){
            data[i][0]=inv.get(i);
        }

        return data;
    }

}
