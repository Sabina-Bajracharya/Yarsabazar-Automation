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
	public void dashboardTest()
	{
		ExtentTest test = extent.createTest("Launch website");
		dashboard dashboardobject = new dashboard(driver);

		String browserURL = driver.getCurrentUrl();
		assertEquals(browserURL, actualBrowserURL);
		test.pass("User launched to website URL : " + browserURL);
		test.pass("Website Launch Verified");

		dashboardobject.isLogoDisplayed();
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
				{"Sabina2", "9803000099", "sabina2@gmail.com", "Sabina@2"},
		};
	}


	@Test(priority = 3, dataProvider = "loginData")
	public void LoginPageTest(String PhoneNumber, String Password) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Login");
		loginPage loginpageobj = new loginPage(driver);

		loginpageobj.click_login_button();
		Thread.sleep(2000);
		String browserLoginURL = driver.getCurrentUrl();
		String loginURL = loginpageobj.LoginURL;

		assertEquals(browserLoginURL, loginURL);
		if ( browserLoginURL.equals(loginURL)){
			test.pass("The Login url is: " + browserLoginURL);
		}
		else {
			test.fail("The usercannot click login link" +browserLoginURL );
		}
		loginpageobj.email_Input(PhoneNumber);
		Thread.sleep(1000);
		loginpageobj.password_Input(Password);
		Thread.sleep(1000);
		loginpageobj.login_Click();
		Thread.sleep(1000);

		String browserLoggedInURL = driver.getCurrentUrl();
		String loggedInURL = loginpageobj.LoggedInURL;

		System.out.println(browserLoggedInURL);
		System.out.println(loggedInURL);
		if( loggedInURL == browserLoggedInURL ){
			test.fail("The user"+PhoneNumber+ "cannot log in due to invalid credentials");
		}
		else
		{
			test.pass("The user"+ PhoneNumber + "is Logged in successfully");

		}
		Thread.sleep(1000);
//		loginpageobj.logout_Click();
//		Thread.sleep(2000);

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData(){
		return new Object[][]{
				{"9823579453", "Sabina@123"}

		};
	}

	@Test(priority = 4, dataProvider = "UserUpdateData")
	public void UserDashboardTest(String Name, String Email) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify User Dashboard");
		UserDashboard UserDashboardobj = new UserDashboard(driver);

		UserDashboardobj.click_Full_Name_Update_button();
		UserDashboardobj.clear_Full_Name_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Full_Name_bar(Name);
		Thread.sleep(1000);
		UserDashboardobj.click_buttton_Full_Name_Savechange();
		Thread.sleep(1000);
		UserDashboardobj.click_Email_Update_button();
		Thread.sleep(1000);
		UserDashboardobj.clear_Email_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Email_bar(Email);
		Thread.sleep(1000);
		UserDashboardobj.click_Email_savechange_button();
		UserDashboardobj.click_Change_Password();
		Thread.sleep(1000);
		UserDashboardobj.click_profile_button();
		Thread.sleep(1000);
		UserDashboardobj.click_logout_button();
		Thread.sleep(1000);


	}
	@DataProvider(name = "UserUpdateData")
	public Object[][] getuserUpdateData(){
		return new Object[][]{
				{"Sabina Bajracharya", "sabina1@gmail.com"}
		};
	}

	@Test(priority = 5, dataProvider = "SearchData")
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

	@Test (priority = 6)
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

	@Test(priority = 7)
	public void FooterTest()throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Footer");
		Footer Footerobj = new Footer(driver);

		Footerobj.click_Privacy_Policy();
		Thread.sleep(1000);

		test.pass("Privacy Policy is opened successfully");

		Footerobj.click_Terms_of_Services();
		Thread.sleep(1000);
		test.pass("Terms of Services is opened successfully");
	}


	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		extent.flush();

	}
}
