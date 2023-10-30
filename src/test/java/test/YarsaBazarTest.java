package test;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.dashboard;
import pages.loginPage;



public class YarsaBazarTest {

	private static WebDriver driver = null;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	String actualBrowserURL = "https://www.yarsabazar.com/";

	@Test(priority = 1)
	public void dashboardTest() {
		ExtentTest test = extent.createTest("Launch website");
		dashboard dashboardobject = new dashboard(driver);
		String browserURL = driver.getCurrentUrl();
		assertEquals(browserURL, actualBrowserURL);
		test.pass("User launced to website URL : " + browserURL);
		test.pass("Website Launch Verified");

		dashboardobject.isLogoDisplayed();
	}

	@Test(priority = 2, dataProvider = "dsm")
	public void LoginPageTest(String name, String phone, String email, String password) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Login");
		loginPage loginpageobj = new loginPage(driver);

		loginpageobj.click_login_button();
		Thread.sleep(1000);

		String browserLoginURL = driver.getCurrentUrl();
		String loginURL = loginpageobj.LoginURL;
		assertEquals(browserLoginURL, loginURL);
		test.pass("The Login url is: " + browserLoginURL);
		test.pass("Login Page is opened");

		Object[][] data = datasupply();
		Object[] lastRow = data[6];
		String PhoneNumber = (String) lastRow[1];
		String Password = (String) lastRow[3];

		loginpageobj.email_Input(PhoneNumber);
		Thread.sleep(2000);
		loginpageobj.password_Input(Password);
		Thread.sleep(2000);
		loginpageobj.login_Click();
		Thread.sleep(2000);

		String browserLoggedInURL = driver.getCurrentUrl();
		String loggedinURL = loginpageobj.LoggedInURL;
		assertEquals(browserLoggedInURL, loggedinURL);
		test.pass("The Logged in url is: " + browserLoggedInURL);
		test.pass("User " + PhoneNumber + " is logged in successfully");
	}
	
	@DataProvider(name = "dsm")

	public Object[][] datasupply() {

		Object[][] data = {
				{ "Sabina", "9898989898", "sabina@gmail.com", "Sabina@1" }

		};
		return data;

	}


	@BeforeTest
	public void setUpTest() throws InterruptedException {

		extent.attachReporter(spark);

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yarsabazar.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		extent.flush();

	}

}
