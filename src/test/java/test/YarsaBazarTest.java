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
import pages.signUpPage;


public class YarsaBazarTest {

	private static WebDriver driver = null;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	String actualBrowserURL = "https://www.yarsabazar.com/";

	@BeforeTest
	public void setUpTest() throws InterruptedException {

		extent.attachReporter(spark);

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yarsabazar.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}


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

	public void SignUpPageTest(String name, String phone, String email, String password) throws InterruptedException {

		ExtentTest test = extent.createTest("Verify SignUp");

		signUpPage signuppageobj = new signUpPage(driver);

		signuppageobj.click_SignUp_Button();
		Thread.sleep(2000);

		String browserSignUpURL = driver.getCurrentUrl();
		String actualsignupURL = signuppageobj.actualSignUpURL;
		assertEquals(browserSignUpURL, actualsignupURL);

		test.pass("User Redirected to Sign Up URL as: " + browserSignUpURL);
		test.pass("Sign Up Page Redirection Verified");

		signuppageobj.input_Name(name);
		Thread.sleep(2000);
		signuppageobj.input_PhoneNumber(phone);
		Thread.sleep(2000);
		signuppageobj.input_Email(email);
		Thread.sleep(2000);
		signuppageobj.input_Password(password);
		Thread.sleep(2000);
		signuppageobj.click_SignUp();
		Thread.sleep(2000);
		signuppageobj.back_button();
		Thread.sleep(2000);

	}


	@Test(priority = 3, dataProvider = "dsm")
	public void LoginPageTest(String PhoneNumber, String Password) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Login");
		loginPage loginpageobj = new loginPage(driver);

		loginpageobj.click_login_button();
		Thread.sleep(3000);

		String browserLoginURL = driver.getCurrentUrl();
		String loginURL = loginpageobj.LoginURL;
		assertEquals(browserLoginURL, loginURL);
		test.pass("The Login url is: " + browserLoginURL);
		test.pass("Login Page is opened");

		Object[][] data = datasupply();
		Object[] lastRow = data[0];
        PhoneNumber = (String) lastRow[1];
        Password = (String) lastRow[2];

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

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		extent.flush();

	}

	@DataProvider(name = "dsm")

	public Object[][] datasupply() {

		Object[][] data = {
				{"9898989898", "Sabina@1" }

		};
		return data;

	}
	private void assertEqual(String actual, String expected, ExtentTest test, String passMessage, String failMessage) {
		if (actual.equals(expected)) {
			test.pass(passMessage);
		} else {
			test.fail(failMessage);
		}
}
}
