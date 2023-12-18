package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("chrome")String browser) throws Exception{
System.out.println("Browser:" + browser);
                //Check if parameter passed from TestNg is "firefox"
                if
                (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\YarsaBazar_Automation\\drivers\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
//

                }
                //Check if parameter passed from TestNg is "Chrome"
                else if
                (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
                     driver = new FirefoxDriver();
//
                }
                else
                {
                    //If no browser passed throw exception
                    throw new Exception("Incorrect Browser");
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
