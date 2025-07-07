package Listeners;

import Utilities.CommonUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        extentReports = CommonUtilities.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        extentTest= extentReports.createTest(result.getName());
        extentTest.log(Status.INFO,result.getName()+" Test started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

            extentTest.log(Status.PASS,result.getName()+" Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.log(Status.FAIL,result.getName()+" Test failed");
        extentTest.log(Status.INFO,result.getThrowable());
        WebDriver driver= null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        }catch (Throwable e){
            e.printStackTrace();
        }
        String path = CommonUtilities.takeScreenShot(result.getName(),driver);
        extentTest.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.log(Status.SKIP,result.getName()+" Test skipped");
        extentTest.log(Status.INFO,result.getThrowable());

    }



    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}
