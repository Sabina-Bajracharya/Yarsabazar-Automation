package test;

import YBtestData.ReadExcelFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.UserDashboard;
import pages.dashboard;
import pages.loginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class YarsaBazarVendorTest {

        public static WebDriver driver = null;
		Faker faker = new Faker();
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
        String actualBrowserURL = "https://www.yarsabazar.com/";
//	WebDriverWait wait = new WebDriverWait(driver,20, 12 );

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
			//Check if parameter passed from TestNg is "edge"
			else if
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

        @Test(priority = 2, dataProvider = "loginData")
        public void LoginPageTest(String PhoneNumber, String Password) throws InterruptedException {
            ExtentTest test = extent.createTest("Verify the Login");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
            loginPage loginpageobj = new loginPage(driver);

			wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getLogin_button_click()));
			loginpageobj.click_login_button();
            Thread.sleep(1000);
            String browserLoginURL = driver.getCurrentUrl();
            String loginURL = loginpageobj.LoginURL;

            assertEquals(browserLoginURL, loginURL);
            if ( browserLoginURL.equals(loginURL)){
                test.pass("The Login url is: " + browserLoginURL);
            }
            else {
                test.fail("The user cannot click login link" +browserLoginURL );
            }
			wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getEmail_input()));
            loginpageobj.email_Input(PhoneNumber);
			wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getPassword_input()));
            loginpageobj.password_Input(Password);
			wait.until(ExpectedConditions.elementToBeClickable(loginpageobj.getlogin_Click()));
            loginpageobj.login_Click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        public Object[][] getLoginData() {

			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\YarsaBazar_Automation\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(2);
			Object[][] credentials = new Object[rows - 1 ][2];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(2);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(2, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(2, i, 1);
			}
			return credentials;


		}


    	@Test(priority = 3, dataProvider = "VendorRFQ")
	public void UserDashboardTest(String Rfullname, String Rmobile,  String RproductName, String Rquantity, String Rdesc ) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify User Dashboard");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		UserDashboard UserDashboardobj = new UserDashboard(driver);

		UserDashboardobj.click_account_details();
		Thread.sleep(2000);
            test.pass("Account Details opened successfully");
		UserDashboardobj.click_Full_Name_Update_button();
		UserDashboardobj.clear_Full_Name_bar();
		wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getFull_Name_bar()));
		UserDashboardobj.edit_Full_Name_bar(faker.name().fullName());
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getFull_Name_Savechange_button()));
			UserDashboardobj.click_buttton_Full_Name_Savechange();
		Thread.sleep(1000);
            test.pass("Full Name updated successfully");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEmail_Update_button()));
			UserDashboardobj.click_Email_Update_button();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEmail_bar()));
			UserDashboardobj.clear_Email_bar();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEmail_bar()));
			UserDashboardobj.edit_Email_bar(faker.internet().emailAddress());
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEmail_Savechange_button()));
			UserDashboardobj.click_Email_savechange_button();
            test.pass("Email updated successfully");
		UserDashboardobj.click_Change_Password();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getNew_Password_field()));
			UserDashboardobj.input_New_Password_field("Sabina12@34");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getConfirm_New_Password_field()));
			UserDashboardobj.input_confirm_New_Password_field("Sabina12@34");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getChange_Password_button()));
		UserDashboardobj.Change_Password_button_click();
		Thread.sleep(1000);
            test.pass("Password updated successfully");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getMy_details_click()));
		UserDashboardobj.click_my_details();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEmail_verify_button_click()));
		UserDashboardobj.click_Email_Verify_Button();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCancel_email_verify()));
		UserDashboardobj.verify_email_cancel();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getHelp_button_click()));
		UserDashboardobj.click_help_button();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getAccount_information_drop()));
			UserDashboardobj.drop_Account_information();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getNegotiation_drop()));
			UserDashboardobj.drop_negotiation();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getShopping_drop()));
			UserDashboardobj.drop_shopping();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getUser_onboarding_process_drop()));
			UserDashboardobj.drop_user_onboarding_process();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getUser_dashboard_search_bar()));
		UserDashboardobj.input_user_dashboard_Search_bar(faker.commerce().color());
			Thread.sleep(1000);
		UserDashboardobj.item_searched_click(Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCategory_first()));
			UserDashboardobj.first_Category_click();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getProduct_name()));
			UserDashboardobj.input_product_name(faker.food().fruit());
		UserDashboardobj.phone_number_input("9823579453");
		UserDashboardobj.full_name_input(faker.name().fullName());
		UserDashboardobj.input_email_address(faker.internet().emailAddress());
		UserDashboardobj.input_description(faker.lorem().word());
		UserDashboardobj.input_submit();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getDismiss_click()));
		UserDashboardobj.click_dismiss();
		driver.navigate().to("https://www.yarsabazar.com/vendor/products");
            test.pass("Navigated back to vendor dashboard successfully");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getMy_Store_Page_click()));
		UserDashboardobj.click_My_store_page();
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/seller/sabina"))
		{
			test.pass("Navigated to My Store page successfully");
		}
		else {
			test.pass("Didn't navigated to My Store page");
		}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCompany_Info_click()));
			UserDashboardobj.click_company_info();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getProducts_click()));
		UserDashboardobj.click_products();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getImage_slide_left_click()));
		UserDashboardobj.click_image_slide_left();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getImage_slide_right_click()));
		UserDashboardobj.click_slide_right();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getDashboard_click()));
		UserDashboardobj.click_dashboard();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getRequest_for_quote_click()));
		UserDashboardobj.click_request_for_quote();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

		//RFQ section
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/rfq")){
			test.pass("Request for Quote page opened successfully");
		}
		else {
			test.fail("Request for Quote page didn't opened");
		}

		UserDashboardobj.input_fullname_request(Rfullname);
		UserDashboardobj.input_MobileNumber_request(Rmobile);
		UserDashboardobj.input_ProductName_request(RproductName);
		UserDashboardobj.input_quantity_request(Rquantity);
		UserDashboardobj.input_More_Information_request(Rdesc);
		UserDashboardobj.click_submit_request();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getRequest_dismiss_click()));
		UserDashboardobj.click_dismiss_request();
		test.pass("Request submitted successfully");
		driver.navigate().to("https://www.yarsabazar.com/vendor/products");
		test.pass("Navigated back to vendor dashboard successfully");


		///for business infromation section
		UserDashboardobj.click_business_information();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/profile")){
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			test.pass("Navigated to Business Profile section");
		}
		else {
			test.fail("Business Profile section didnot opened");
		}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEdit_Business_Information_Details()));
		UserDashboardobj.edit_busines_details();
		UserDashboardobj.update_business_details();
		UserDashboardobj.click_registration_details();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/registration-details")){
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				test.pass("Navigated to Registration Details section");
			}
			else {
				test.fail("Registration Details section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getEdit_Registration_Details()));
			UserDashboardobj.edit_registration_Details();
		UserDashboardobj.click_cancel_registration_details();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getIndustries()));
		UserDashboardobj.click_industries();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/industries")){
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				test.pass("Navigated to Industries section");
			}
			else {
				test.fail("Industries section didnot opened");
			}
//		UserDashboardobj.add_industries();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getBranches()));
		UserDashboardobj.click_branches();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/branches")){
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				test.pass("Navigated to Branches section");
			}
			else {
				test.fail("Branches section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getAdd_Branches()));
		UserDashboardobj.click_add_branches();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCancel_Add_Branches()));
		UserDashboardobj.click_cancel_add_branches();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getOwners()));
		UserDashboardobj.click_owners();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/owners")){
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				test.pass("Navigated to Owners section");
			}
			else {
				test.fail("Owners section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getAdd_Owners()));
		UserDashboardobj.click_add_owners();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCancel_Add_Owners()));
			UserDashboardobj.click_cancel_add_owners();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getPayment_Methods()));
		UserDashboardobj.click_payment_methods();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/payment-methods")){
				test.pass("Navigated to Payment Methods section");
			}
			else {
				test.fail("Payment Methods section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getCash_Payment_Mehtods()));
		UserDashboardobj.click_cash_payement_method();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getStore_Images()));
		UserDashboardobj.click_store_iamges();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/store-images")){
				test.pass("Navigated to Store Images section");
			}
			else {
				test.fail("Store Images section didnot opened");
			}
			Thread.sleep(2000);

			////for Products section
			UserDashboardobj.click_products_active();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products")){
				test.pass("Navigated to Products section");
			}
			else {
				test.fail("Products section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getDraft()));
			UserDashboardobj.click_drafts();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=draft")){
				test.pass("Navigated to Draft section");
			}
			else {
				test.fail("Draft section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getWaiting_Approval()));
			UserDashboardobj.click_waiting_approval();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=waiting_approval")){
				test.pass("Navigated to Waiting Approval section");
			}
			else {
				test.fail("Waiting Approval section didnot opened");
			}
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getRejected()));
			UserDashboardobj.click_rejected();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=rejected")){
				Thread.sleep(1000);
				test.pass("Navigated to Rejected section");
			}
			else {
				test.fail("Rejected section didnot opened");
			}
			Thread.sleep(1000);

////for logout
		UserDashboardobj.click_back_to_main_site();
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")){
				Thread.sleep(1000);
				test.pass("Navigated to Main site");
			}
			else {
				test.fail("Main site didnot opened");
			}
		Thread.sleep(1000);
		test.pass("Navigated to main site");
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getProfile_button_click()));
			UserDashboardobj.click_profile_button();
			wait.until(ExpectedConditions.elementToBeClickable(UserDashboardobj.getLogout_click()));
		UserDashboardobj.click_logout_button();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")){
			test.pass("User logged out successfully");
		}
		else {
			test.fail("User didn't logged out");
		}
	}

	@DataProvider(name = "VendorRFQ")
	public Object[][] getuserUpdateData() {
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\YarsaBazar_Automation\\YBtestCredentials.xlsx");

		int rows = config.getRowCount(1);
		Object[][] credentials = new Object[rows - 1 ][5];

		// Assuming the headers are present, use getHeaders to skip the header row
		String[] headers = config.getHeaders(1);

		for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
			credentials[i - 1][0] = config.getData(1, i, 2); // Adjust index to match the data row
			credentials[i - 1][1] = config.getData(1, i, 1);
			credentials[i - 1][2] = config.getData(1, i, 5); // Adjust index to match the data row
			credentials[i - 1][3] = config.getData(1, i, 6);
			credentials[i - 1][4] = config.getData(1, i, 4); // Adjust index to match the data row

		}
		return credentials;

	}

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
        System.out.println("Test Completed Successfully");
        extent.flush();

    }
}
