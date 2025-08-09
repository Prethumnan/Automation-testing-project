import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

// doing some modification in my base class
public class Base {

    Properties prop;
    Properties testData;
    WebDriver driver;

    public Base(){
        prop = new Properties();
        testData = new Properties();
        try{
            File file = new File(System.getProperty("user.dir")+"/src/main/java/Files/config.properties");
            File f = new File(System.getProperty("user.dir")+"/src/main/java/Files/testData.properties");
            FileInputStream fi = new FileInputStream(file);
            FileInputStream ff = new FileInputStream(f);
            prop.load(fi);
            testData.load(ff);

        }catch (Throwable e ){
            e.printStackTrace();
        }
    }

    public WebDriver initializeWebDriver() {

        String name = prop.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

        if (name.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);

        } /*else if (name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
            }
            driver = new FirefoxDriver(options);

        } else if (name.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("headless");
                options.addArguments("window-size=1920,1080");
            }
            driver = new EdgeDriver(options);
        }*/

        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    public String testdata(String s){

        String k = testData.getProperty(s);
        return  k;
    }




}
