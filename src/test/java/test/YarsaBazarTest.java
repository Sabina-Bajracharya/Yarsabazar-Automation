package test;

import static org.testng.Assert.assertEquals;
import YBtestData.ReadExcelFile;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class YarsaBazarTest{
	public static WebDriver driver = null;
	Faker faker = new Faker();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	String actualBrowserURL = "https://www.yarsabazar.com/";


	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws Exception{
		System.out.println("Browser:" + browser);
		//Check if parameter passed from TestNg is "chrome"
		if
		(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\YarsaBazar_Automation\\drivers\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if
			////Check if parameter passed from TestNg is "edge"
		(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\hp\\YarsaBazar_Automation\\drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			//If no browser passed throw exception
			throw new Exception("Incorrect Browser");
		}

		extent.attachReporter(spark);
		driver.get("https://www.yarsabazar.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void dashboardTest() throws InterruptedException {
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
				test.fail("Didn't land on the correct dashboard");
			}
		Thread.sleep(3000);
	}



	@Test(priority = 2, dataProvider = "signUpData")

	public void SignUpPageTest(String name, String phone, String email, String password) throws InterruptedException {

		ExtentTest test = extent.createTest("Verify SignUp");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		signUpPage signuppageobj = new signUpPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getclick_SignUp_Button()));
		signuppageobj.click_SignUp_Button();
		Thread.sleep(1000);

		String browserSignUpURL = driver.getCurrentUrl();
		String actualsignupURL = signuppageobj.actualSignUpURL;
		assertEquals(browserSignUpURL, actualsignupURL);

		test.pass("User Redirected to Sign Up URL as: " + browserSignUpURL);
		test.pass("Sign Up Page Redirection Verified");
		wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getinput_Name()));
		signuppageobj.input_Name(name);
		wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getInput_PhoneNumber()));
		signuppageobj.input_PhoneNumber(phone);
		wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getInput_Email()));
		signuppageobj.input_Email(email);
		wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getInput_Password()));
		signuppageobj.input_Password(password);
		signuppageobj.click_SignUp();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String browserSignedUpURL = driver.getCurrentUrl();
		String actualsignedupURL = signuppageobj.actualSignedUpURL;
		if (browserSignedUpURL.equals(actualsignedupURL)) {
			test.pass( " User" +phone+ "signed Up successfully");
			test.pass("User redirected to the otp verification");
		}
		else {
			test.fail("User" +phone+  "didn't sign up");
			test.fail("Enter valid sign Up credentials");
			wait.until(ExpectedConditions.elementToBeClickable(signuppageobj.getBack_button()));
			signuppageobj.back_button();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		}
	}


	@DataProvider(name = "signUpData")
	public Object[][] getSignupData() {
			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\YarsaBazar_Automation\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(0); // Change sheet index to 1
			Object[][] credentials = new Object[rows - 1][4]; // Adjusted to handle 4 input fields

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(0); // Change sheet index to 1

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(0, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(0, i, 1);
				credentials[i - 1][2] = config.getData(0, i, 2);
				credentials[i - 1][3] = config.getData(0, i, 3);
			}

			return credentials;
		}


//otp verification test
	@Test(priority = 3)
	public void otpTest() throws InterruptedException{
		ExtentTest test = extent.createTest("Verify the otp");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		otp otpobj = new otp(driver);

		String BrowserURL = driver.getCurrentUrl();
		String actualverifyotpURL = otpobj.actualVerifyotp;
		if(BrowserURL.equals(actualverifyotpURL)){
			test.pass("User successfully landed on OTP Verification page");

			otpobj.click_edit_phoneNumber();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getEdit_box_PhoneNumber()));
			otpobj.clear_edit_phoneNumber();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getEdit_box_PhoneNumber()));
			otpobj.input_edit_box_PhoneNumber("9823578878");
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getTick_button()));
			otpobj.click_tick_button();
			test.pass("Phone Number is updated");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().to("https://www.yarsabazar.com/verify");
			otpobj.click_send_otp_box();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/verify")){
				test.pass("user navigated to otp code verification page");
			}
			else{
				test.fail("user didn't navigated to otp code verification page");
			}
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getOtp_bar()));
			otpobj.click_otp_bar();
//		otpobj.click_resend_otp();
//		Thread.sleep(2000);
//		test.pass("OTP resend successfully");
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getOtp_submit()));
			otpobj.click_otp_submit();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/account")){
				test.pass("OTP verified successfully");
			}
			else {
				test.fail("Invalid OTP. Enter valid OTP dislayed");
			}
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getOtp_try_again()));
			otpobj.click_otp_try_again();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getHelp()));
			otpobj.click_help();
			test.pass("Help section is displayed");
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getProfile_view()));
			otpobj.click_profile_view();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getAccount()));
			otpobj.click_account();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getVerfiy_Now()));
			otpobj.click_Verify_Now();
			wait.until(ExpectedConditions.elementToBeClickable(otpobj.getLogout()));
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	@Test(priority = 4, dataProvider = "loginData")
	public void LoginPageTest(String PhoneNumber, String Password) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		loginPage loginpageobj = new loginPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://www.yarsabazar.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getEmail_input()));
		loginpageobj.email_Input(PhoneNumber);
		wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getPassword_input()));
		loginpageobj.password_Input(Password);
		wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getlogin_Click()));
		loginpageobj.login_Click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/account")){
			test.pass("The user"+ PhoneNumber + "is Logged in successfully");
			driver.navigate().to("https://www.yarsabazar.com/account");
			loginpageobj.profile_button_click();
			wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getlogout_Click()));
			loginpageobj.logout_Click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}

		else
		{

			test.fail("The user"+PhoneNumber+ "cannot log in due to invalid credentials");
			driver.navigate().to("https://www.yarsabazar.com/login");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().refresh();
		}
	}

	@DataProvider(name = "loginData")

	public Object[][] getLoginData() {
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\YarsaBazar_Automation\\YBtestCredentials.xlsx");

		int rows = config.getRowCount(0);
		Object[][] credentials = new Object[rows - 1 ][2];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(1);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(0, i, 1); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(0, i, 3);
			}
		return credentials;
	}


	@Test(priority = 5, dataProvider = "UserDataBefore")
	public void UserDashboardBeforeTest(String searchItem, String phone, String fullname, String email, String desc )throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9000));
		ExtentTest test = extent.createTest("Verify User Dashboard before sell on YarsaBazar Signup");
		UserDashboardBefore UserDashboardBeforeobj = new UserDashboardBefore(driver);
		driver.navigate().to("https://www.yarsabazar.com/");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getLogin_button_click()));
		UserDashboardBeforeobj.click_login_button();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getEmail_input()));
		UserDashboardBeforeobj.input_email("9762784654");
		UserDashboardBeforeobj.input_password("Simran@1");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getClick_logins_button()));
		UserDashboardBeforeobj.click_logins_buttons();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/account")){
			test.pass("The user 9762784654 is Logged in successfully");
		} else {
			test.fail("The user 9762784654 cannot log in due to invalid credentials");
		}
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getFull_Name_Update_button()));
		UserDashboardBeforeobj.click_Full_Name_Update_button();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getFull_Name_bar()));
		UserDashboardBeforeobj.clear_Full_Name_bar();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getFull_Name_bar()));
		UserDashboardBeforeobj.edit_Full_Name_bar(faker.name().fullName());
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getFull_Name_Savechange_button()));
		UserDashboardBeforeobj.click_buttton_Full_Name_Savechange();
		test.pass("Name changed successfully");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getEmail_Update_button()));
		UserDashboardBeforeobj.click_Email_Update_button();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getEmail_bar()));
		UserDashboardBeforeobj.clear_Email_bar();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getEmail_bar()));
		UserDashboardBeforeobj.edit_Email_bar(faker.internet().emailAddress());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.pass("Email updated successfully");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getChange_Password_button()));
		UserDashboardBeforeobj.click_Change_Password();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getNew_Password_field()));
		UserDashboardBeforeobj.input_New_Password_field("Simran@1");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getConfirm_New_Password_field()));
		UserDashboardBeforeobj.input_confirm_New_Password_field("Simran@1");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getChange_Password_click()));
		UserDashboardBeforeobj.Change_Password_button_click();
		test.pass("Password changed successfully");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getEmail_verify_button_click()));
		UserDashboardBeforeobj.click_Email_Verify_Button();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getCancel_email_verify()));
		UserDashboardBeforeobj.verify_email_cancel();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getHelp_button_click()));
		UserDashboardBeforeobj.click_help_button();

		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getAccount_information_drop()));
		UserDashboardBeforeobj.drop_Account_information();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getNegotiation_drop()));
		UserDashboardBeforeobj.drop_negotiation();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getShopping_drop()));
		UserDashboardBeforeobj.drop_shopping();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getUser_onboarding_process_drop()));
		UserDashboardBeforeobj.drop_user_onboarding_process();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getUser_dashboard_help_content_drop()));
		UserDashboardBeforeobj.drop_user_dashboard_help_content();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getAccount_information_drop()));
		UserDashboardBeforeobj.drop_Account_information();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getNegotiation_drop()));
		UserDashboardBeforeobj.drop_negotiation();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getShopping_drop()));
		UserDashboardBeforeobj.drop_shopping();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getUser_onboarding_process_drop()));
		UserDashboardBeforeobj.drop_user_onboarding_process();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getUser_dashboard_help_content_drop()));
		UserDashboardBeforeobj.drop_user_dashboard_help_content();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		UserDashboardBeforeobj.input_user_dashboard_Search_bar(searchItem);
		Thread.sleep(2000);
		UserDashboardBeforeobj.click_user_dashboard_search(Keys.ENTER);
		test.pass("Search performed successfully");
		UserDashboardBeforeobj.click_fist_category();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getProduct_name()));
		UserDashboardBeforeobj.input_product_name(searchItem);
		UserDashboardBeforeobj.phone_number_input(phone);
		UserDashboardBeforeobj.full_name_input(fullname);
		UserDashboardBeforeobj.input_email_address(email);
		UserDashboardBeforeobj.input_description(desc);
		UserDashboardBeforeobj.input_submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.pass("order placed successfully");
		UserDashboardBeforeobj.click_dismiss();
		driver.navigate().to("https://www.yarsabazar.com/account");
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getSell_on_Yarsabazar()));
		////To signup on sell on yarsabazar through user dashboard
		UserDashboardBeforeobj.click_sell_on_yarsabzar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getProfile_button_click()));
		UserDashboardBeforeobj.click_profile_button();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardBeforeobj.getLogout_click()));
		UserDashboardBeforeobj.click_logout_button();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.pass("User Logged out successfully");
	}
	@DataProvider(name = "UserDataBefore")
	public Object[][] getUserDataBefore(){
			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\YarsaBazar_Automation\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(1);
			Object[][] credentials = new Object[rows - 1 ][5];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(1);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(1, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(1, i, 1);
				credentials[i - 1][2] = config.getData(1, i, 2); // Adjust index to match the data row
				credentials[i - 1][3] = config.getData(1, i, 3);
				credentials[i - 1][4] = config.getData(1, i, 4); // Adjust index to match the data row

			}
			return credentials;
		}

	@Test(priority = 6, dataProvider = "SearchData")
	public  void SearchTest(String Item) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify the Search");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		search Searchobj = new search(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Searchobj.getSearch_bar_input()));

		Searchobj.input_search_bar(Item);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.pass("Item " + Item + " is displaying recommendation");
		wait.until(ExpectedConditions.elementToBeClickable(Searchobj.getSearch_icon_click()));
		Searchobj.click_Search_icon();
		test.pass("Item " + Item + " is clicked successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://www.yarsabazar.com/");

		if (driver.getCurrentUrl().equals("https://www.yarsabazar.com/")) {
			test.pass("Returned back to dashborad successfully");
		}
		else{
			test.fail("Didn't returned to dashboard");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		IndustriesPage Industriesobj = new IndustriesPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Industriesobj.getBrowse_all_industries_click()));
		Industriesobj.click_browse_all_industries();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/industries")) {
			test.pass("Browse All Industries page is opened successfully");
		}
		else{
			test.fail("Browse All Industries page did not opened.");
		}
		wait.until(ExpectedConditions.elementToBeClickable(Industriesobj.getBack_to_dashboard()));
		Industriesobj.click_back_to_dashboard();
		Thread.sleep(3000);
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/privacy-policy")){
		test.pass("Privacy Policy is opened successfully");
		}
		else {
			test.fail("Privacy Policy didn't opened");
		}

		Footerobj.click_Terms_of_Services();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(2));

		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/terms-of-service"))
		{
			test.pass("Terms of Services is opened successfully");
		}
		else
		{
			test.fail("Terms of Services didn't open");
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
