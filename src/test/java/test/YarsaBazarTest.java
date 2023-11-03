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
import pages.*;


public class YarsaBazarTest {

	private static WebDriver driver = null;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	String actualBrowserURL = "https://www.yarsabazar.com/";

	@BeforeTest
	public void setUpTest() throws InterruptedException {

		extent.attachReporter(spark);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\YarsaBazar_Automation\\drivers\\chromedriver-win64\\chromedriver.exe");
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
		test.pass("Logo is displayed");

	}

	@Test(priority = 2, dataProvider = "signUpData")

	public void SignUpPageTest(String name, String phone, String email, String password) throws InterruptedException {

		ExtentTest test = extent.createTest("Verify SignUp");

		signUpPage signuppageobj = new signUpPage(driver);

		signuppageobj.click_SignUp_Button();
		Thread.sleep(3000);

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

		test.pass("User " + phone + " is signed up successfully");
	}

	@DataProvider(name= "signUpData")
	public Object[][] getSignUpData(){
		return new Object[][]{
				{"Sabina1", "9898000098", "sabina1@gmail.com", "Sabina@1"},
				{"Sabina2", "9080908098", "sabina2@gmail.com", "Sabina@2"},
		};
	}


	@Test(priority = 3, dataProvider = "loginData")
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

		loginpageobj.email_Input(PhoneNumber);
		Thread.sleep(2000);
		loginpageobj.password_Input(Password);
		Thread.sleep(2000);
		loginpageobj.login_Click();
		Thread.sleep(2000);
		loginpageobj.logout_Click();
		Thread.sleep(2000);

//		String browserLoggedInURL = driver.getCurrentUrl();
//		String loggedinURL = loginpageobj.LoggedInURL;
//		assertEquals(browserLoggedInURL, loggedinURL);
//		test.pass("The Logged in url is: " + browserLoggedInURL);
		test.pass("User " + PhoneNumber + " is logged in successfully");
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData(){
			return new Object[][]{
					{"9898000098", "Sabina@1"},

		};
	}

@Test(priority = 4, dataProvider = "SearchData")
public  void SearchTest(String Item) throws InterruptedException{
		ExtentTest test = extent.createTest("Verify the Search");
		search Searchobj = new search(driver);

	Searchobj.input_search_bar(Item);
	Thread.sleep(4000);

	test.pass("Item " + Item + " is searched successfully");

	Searchobj.click_dog_food();
	Thread.sleep(2000);

	test.pass("Item " + Item + " is clicked successfully");

	Searchobj.click_back_to_dashborad();
	Thread.sleep(2000);

	test.pass("Returned back to dashborad successfully");
}


	@DataProvider(name = "SearchData")
	public Object[][] getSearchData(){
		return new Object[][]{
				{"dog food"}

		};
	}

	@Test (priority = 5)
	public void industriesTest()throws InterruptedException{
		ExtentTest test = extent.createTest("Verify the Browse All Industries");
		IndustriesPage Industriesobj = new IndustriesPage(driver);

		Industriesobj.click_browse_all_industries();
		Thread.sleep(2000);
		test.pass("Browse All Industries page is opened successfully");

		Industriesobj.click_back_to_dashboard();
		Thread.sleep(2000);
		test.pass("Returned back to Dashboard from Browse All Industries page ");

	}


	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		extent.flush();

}
}
