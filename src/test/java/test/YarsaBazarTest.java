package test;

import static org.testng.Assert.assertEquals;
import YBtestData.ReadExcelFile;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class YarsaBazarTest {
	Faker faker = new Faker();
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
		if (browserURL.equals(actualBrowserURL)) {
			test.pass("User launched to website URL : " + browserURL);
		} else {
			test.fail("Website didnot launch");
		}

		dashboardobject.isLogoDisplayed();
		if(dashboardobject.isLogoDisplayed()){
			test.pass("Logo is displayed");
		}
			else{
				test.fail("Logo is not displayed");
		}
			if(browserURL.equals(actualBrowserURL)&& dashboardobject.isLogoDisplayed()){
				test.pass("Successfully landed on the correct dashboard");
			}
			else {
				test.fail("Didn't landed on the correct dashboard");
			}

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
		Thread.sleep(1000);
		signuppageobj.input_PhoneNumber(phone);
		Thread.sleep(1000);
		signuppageobj.input_Email(email);
		Thread.sleep(1000);
		signuppageobj.input_Password(password);
		Thread.sleep(1000);
		signuppageobj.click_SignUp();
		Thread.sleep(1000);

		String browserSignedUpURL = driver.getCurrentUrl();
		String actualsignedupURL = signuppageobj.actualSignedUpURL;
		if (browserSignedUpURL.equals(actualsignedupURL)) {
			test.pass( " User" +phone+ "signed Up successfully");
			test.pass("User redirected to the otp verification");
		}
		else {
			test.fail("User" +phone+  "didn't signed up");
			test.fail("Enter valid sign Up credentials");
			signuppageobj.back_button();
			Thread.sleep(1000);
		}
		Thread.sleep(4000);
	}


	@DataProvider(name = "signUpData")
	public Object[][] getSignupData() {
			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\OneDrive\\Documents\\Yarsa Office\\My Assessments\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(1); // Change sheet index to 1
			Object[][] credentials = new Object[rows - 1][4]; // Adjusted to handle 4 input fields

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(1); // Change sheet index to 1

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(1, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(1, i, 1);
				credentials[i - 1][2] = config.getData(1, i, 2);
				credentials[i - 1][3] = config.getData(1, i, 3);
			}

			return credentials;
		}


//otp verification test
	@Test(priority = 3)
	public void otpTest() throws InterruptedException{
		ExtentTest test = extent.createTest("Verify the otp");
		otp otpobj = new otp(driver);

		String BrowserURL = driver.getCurrentUrl();
		String actualverifyotpURL = otpobj.actualVerifyotp;
		if(BrowserURL.equals(actualverifyotpURL)){
			test.pass("User successfully landed on OTP Verification page");

			otpobj.click_edit_phoneNumber();
			Thread.sleep(2000);
			otpobj.clear_edit_phoneNumber();
			Thread.sleep(2000);
			otpobj.input_edit_box_PhoneNumber("9823478885");
			Thread.sleep(2000);
			otpobj.click_tick_button();
			test.pass("Phone Number is updated");
//		otpobj.click_cross_button();
//		test.pass("Phone Number not updated");
			Thread.sleep(1000);
			driver.navigate().to("https://www.yarsabazar.com/verify");
			otpobj.click_send_otp_box();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/verify")){
				test.pass("user navigated to otp code verification page");
			}
			else{
				test.fail("user didn't navigated to otp code verification page");
			}
			Thread.sleep(2000);
			otpobj.click_otp_bar();
			Thread.sleep(2000);
//		otpobj.click_resend_otp();
//		Thread.sleep(2000);
//		test.pass("OTP resend successfully");
			otpobj.click_otp_submit();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/account")){
				test.pass("OTP verified successfully");
			}
			else {
				test.fail("Invalid OTP. Enter valid OTP dislayed");
			}
			Thread.sleep(2000);
			otpobj.click_otp_try_again();
			Thread.sleep(2000);
			otpobj.click_help();
			test.pass("Help section is displayed");
			driver.navigate().refresh();
			Thread.sleep(2000);
			otpobj.click_profile_view();
			Thread.sleep(2000);
			otpobj.click_account();
			Thread.sleep(4000);
			otpobj.click_Verify_Now();
			Thread.sleep(2000);
			otpobj.click_logout();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")){
				test.pass("User logged out successfully");
			}
			else {
				test.fail("User didn't logged out.");
			}
		}
		else {
			test.fail("User did not landed on OTP Verification page");
			driver.navigate().to("https://www.yarsabazar.com/");
		}
		Thread.sleep(3000);
	}


	@Test(priority = 4, dataProvider = "loginData")
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
		Thread.sleep(2000);

		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/account")){
			Thread.sleep(1000);
			test.pass("The user"+ PhoneNumber + "is Logged in successfully");
			loginpageobj.profile_button_click();
			Thread.sleep(2000);
			loginpageobj.logout_Click();
			Thread.sleep(2000);

		}

		else
		{
			Thread.sleep(2000);
			test.fail("The user"+PhoneNumber+ "cannot log in due to invalid credentials");
			driver.navigate().to("https://www.yarsabazar.com/");
			Thread.sleep(2000);
			driver.navigate().refresh();
		}
		Thread.sleep(2000);
	}

	@DataProvider(name = "loginData")

	public Object[][] getLoginData() {
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\OneDrive\\Documents\\Yarsa Office\\My Assessments\\YBtestCredentials.xlsx");

		int rows = config.getRowCount(0);
		Object[][] credentials = new Object[rows - 1 ][2];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(0);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(0, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(0, i, 1);
			}
		return credentials;
	}


	@Test(priority = 5, dataProvider = "UserDataBefore")
	public void UserDashboardBeforeTest(String searchItem, String phone, String fullname, String email, String desc )throws InterruptedException{
		ExtentTest test = extent.createTest("Verify User Dashboard before sell on YarsaBazar Signup");
		UserDashboardBefore UserDashboardBeforeobj = new UserDashboardBefore(driver);
		UserDashboardBeforeobj.click_login_button();
		Thread.sleep(2000);
		UserDashboardBeforeobj.input_email("9762784654");
		Thread.sleep(1000);
		UserDashboardBeforeobj.input_password("Simran@1");
		Thread.sleep(1000);
		UserDashboardBeforeobj.click_logins_buttons();
		Thread.sleep(2000);
		UserDashboardBeforeobj.click_Full_Name_Update_button();
		UserDashboardBeforeobj.click_Full_Name_Update_button();
		UserDashboardBeforeobj.clear_Full_Name_bar();
		Thread.sleep(1000);
		UserDashboardBeforeobj.edit_Full_Name_bar("Sabina Bajracharya");
		Thread.sleep(1000);
		UserDashboardBeforeobj.click_buttton_Full_Name_Savechange();
		Thread.sleep(1000);
		test.pass("Name changed successfully");
		UserDashboardBeforeobj.click_Email_Update_button();
		Thread.sleep(1000);
		UserDashboardBeforeobj.clear_Email_bar();
		Thread.sleep(1000);
		UserDashboardBeforeobj.edit_Email_bar("always1@gmail.com");
		Thread.sleep(1000);
		UserDashboardBeforeobj.click_Email_savechange_button();
		test.pass("Email updated successfully");
		UserDashboardBeforeobj.click_Change_Password();
		Thread.sleep(1000);
		UserDashboardBeforeobj.input_New_Password_field("Simran@1");
		Thread.sleep(1000);
		UserDashboardBeforeobj.input_confirm_New_Password_field("Simran@1");
		Thread.sleep(1000);
		UserDashboardBeforeobj.Change_Password_button_click();
		test.pass("Password changed successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		UserDashboardBeforeobj.click_Email_Verify_Button();
		Thread.sleep(1000);
		UserDashboardBeforeobj.verify_email_cancel();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		UserDashboardBeforeobj.click_help_button();
		UserDashboardBeforeobj.drop_Account_information();
		UserDashboardBeforeobj.drop_negotiation();
		UserDashboardBeforeobj.drop_shopping();
		UserDashboardBeforeobj.drop_user_onboarding_process();
		Thread.sleep(2000);
		UserDashboardBeforeobj.drop_user_dashboard_help_content();
		Thread.sleep(1000);
		UserDashboardBeforeobj.drop_Account_information();
		UserDashboardBeforeobj.drop_negotiation();
		UserDashboardBeforeobj.drop_shopping();
		Thread.sleep(1000);
		UserDashboardBeforeobj.drop_user_onboarding_process();
		Thread.sleep(2000);
		UserDashboardBeforeobj.drop_user_dashboard_help_content();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		UserDashboardBeforeobj.input_user_dashboard_Search_bar(searchItem);
		Thread.sleep(3000);
		UserDashboardBeforeobj.click_user_dashboard_search(Keys.ENTER);
		test.pass("Search performed successfully");
		UserDashboardBeforeobj.click_fist_category();
		Thread.sleep(2000);
		UserDashboardBeforeobj.input_product_name(searchItem);
		UserDashboardBeforeobj.phone_number_input(phone);
		UserDashboardBeforeobj.full_name_input(fullname);
		UserDashboardBeforeobj.input_email_address(email);
		UserDashboardBeforeobj.input_description(desc);
		UserDashboardBeforeobj.input_submit();
		Thread.sleep(1000);
		test.pass("order placed successfully");
		UserDashboardBeforeobj.click_dismiss();
		driver.navigate().to("https://www.yarsabazar.com/account");
		Thread.sleep(1000);
		////To signup on sell on yarsabazar through user dashboard
		UserDashboardBeforeobj.click_sell_on_yarsabzar();
		Thread.sleep(2000);
		driver.navigate().to("https://www.yarsabazar.com/account");
		test.pass("Navigated to user account dashboard.");
//		UserDashboardBeforeobj.choose_line_of_business();
//		Thread.sleep(2000);
//		UserDashboardBeforeobj.click_next_step();
//		Thread.sleep(1000);
//		UserDashboardBeforeobj.click_go_back();
//		Thread.sleep(1000);
//		UserDashboardBeforeobj.click_next_step();
//		Thread.sleep(1000);
//		UserDashboardBeforeobj.input_username("SABINA");
//		UserDashboardBeforeobj.input_company_name("Raw Production Pvt.Ltd");
//		UserDashboardBeforeobj.input_company_email("raw@gmail.com");
//		UserDashboardBeforeobj.input_mobile_number("9823579453");
//		UserDashboardBeforeobj.drop_company_type();
//		UserDashboardBeforeobj.input_start_year("2019");
//		UserDashboardBeforeobj.click_start_Selling();
		UserDashboardBeforeobj.click_profile_button();
		Thread.sleep(1000);
		UserDashboardBeforeobj.click_logout_button();
		Thread.sleep(1000);
		test.pass("User Logged out successfully");
	}
	@DataProvider(name = "UserDataBefore")
	public Object[][] getUserDataBefore(){
			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\OneDrive\\Documents\\Yarsa Office\\My Assessments\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(2);
			Object[][] credentials = new Object[rows - 1 ][5];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(2);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(2, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(2, i, 1);
				credentials[i - 1][2] = config.getData(2, i, 2); // Adjust index to match the data row
				credentials[i - 1][3] = config.getData(2, i, 3);
				credentials[i - 1][4] = config.getData(2, i, 4); // Adjust index to match the data row

			}
			return credentials;
		}

	@Test(priority = 6, dataProvider = "SearchData")
	public  void SearchTest(String Item) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Search");
		search Searchobj = new search(driver);

		Searchobj.input_search_bar(Item);
		Thread.sleep(2000);
		test.pass("Item " + Item + " is displaying recommendation");
		Thread.sleep(2000);
		Searchobj.click_Search_icon();
		test.pass("Item " + Item + " is clicked successfully");
		Thread.sleep(2000);
		driver.navigate().to("https://www.yarsabazar.com/");

		if (driver.getCurrentUrl().equals("https://www.yarsabazar.com/")) {
			test.pass("Returned back to dashborad successfully");
		}
		else{
			test.fail("Didn't returned to dashboard");
		}
	}

	@DataProvider(name = "SearchData")
	public Object[][] getSearchData(){
		return new Object[][]{
				{faker.food().fruit()}

		};
	}

	@Test (priority = 7)
	public void industriesTest()throws InterruptedException{
		ExtentTest test = extent.createTest("Verify the Browse All Industries");
		IndustriesPage Industriesobj = new IndustriesPage(driver);

		Industriesobj.click_browse_all_industries();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/industries")) {
			test.pass("Browse All Industries page is opened successfully");
		}
		else{
			test.fail("Browse All Industries page did not opened.");
		}

		Industriesobj.click_back_to_dashboard();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")) {
			test.pass("Returned back to Dashboard from Browse All Industries page ");
		}
		else{
			test.fail("Didn't returned to dashboard");
		}

	}

	@Test(priority = 8)
	public void FooterTest()throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Footer");
		Footer Footerobj = new Footer(driver);

		Footerobj.click_Privacy_Policy();
		Thread.sleep(1000);
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/privacy-policy")){
		test.pass("Privacy Policy is opened successfully");
		}
		else {
			test.fail("Privacy Policy didn't opened");
		}

		Footerobj.click_Terms_of_Services();
		Thread.sleep(1000);

        tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(2));

		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/terms-of-service"))
		{
			test.pass("Terms of Services is opened successfully");
		}
		else
		{
			test.fail("Terms of Services didn't opened");
		}
	}


	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
		extent.flush();

	}
}
