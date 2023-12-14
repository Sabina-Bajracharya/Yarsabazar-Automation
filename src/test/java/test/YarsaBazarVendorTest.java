package test;

import YBtestData.ReadExcelFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.dashboard;
import pages.loginPage;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class YarsaBazarVendorTest {

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

        @Test(priority = 2, dataProvider = "loginData")
        public void LoginPageTest(String PhoneNumber, String Password) throws InterruptedException {
            ExtentTest test = extent.createTest("Verify the Login");
            loginPage loginpageobj = new loginPage(driver);

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

			ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\OneDrive\\Documents\\Yarsa Office\\My Assessments\\YBtestCredentials.xlsx");

			int rows = config.getRowCount(3);
			Object[][] credentials = new Object[rows - 1 ][2];

			// Assuming the headers are present, use getHeaders to skip the header row
			String[] headers = config.getHeaders(3);

			for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
				credentials[i - 1][0] = config.getData(3, i, 0); // Adjust index to match the data row
				credentials[i - 1][1] = config.getData(3, i, 1);
			}
			return credentials;
		}


    	@Test(priority = 3, dataProvider = "VendorRFQ")
	public void UserDashboardTest(String Rfullname, String Rmobile,  String RproductName, String Rquantity, String Rdesc ) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify User Dashboard");
		UserDashboard UserDashboardobj = new UserDashboard(driver);

		UserDashboardobj.click_account_details();
		Thread.sleep(2000);
            test.pass("Account Details opened successfully");
		UserDashboardobj.click_Full_Name_Update_button();
		UserDashboardobj.clear_Full_Name_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Full_Name_bar("Sabina Bajracharya");
		Thread.sleep(1000);
		UserDashboardobj.click_buttton_Full_Name_Savechange();
		Thread.sleep(1000);
            test.pass("Full Name updated successfully");
		UserDashboardobj.click_Email_Update_button();
		Thread.sleep(1000);
		UserDashboardobj.clear_Email_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Email_bar("sabina1@gmail.com");
		Thread.sleep(1000);
		UserDashboardobj.click_Email_savechange_button();
            test.pass("Email updated successfully");
		UserDashboardobj.click_Change_Password();
		Thread.sleep(1000);
		UserDashboardobj.input_New_Password_field("Sabina12@34");
		Thread.sleep(1000);
		UserDashboardobj.input_confirm_New_Password_field("Sabina12@34");
		Thread.sleep(1000);
		UserDashboardobj.Change_Password_button_click();
		Thread.sleep(1000);
            test.pass("Password updated successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		UserDashboardobj.click_account_details();
		Thread.sleep(1000);
		UserDashboardobj.click_Email_Verify_Button();
		Thread.sleep(1000);
		UserDashboardobj.verify_email_cancel();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		UserDashboardobj.click_help_button();
		UserDashboardobj.drop_Account_information();
		UserDashboardobj.drop_negotiation();
		UserDashboardobj.drop_shopping();
		UserDashboardobj.drop_user_onboarding_process();
		Thread.sleep(2000);
		UserDashboardobj.drop_user_dashboard_help_content();
		Thread.sleep(1000);
		UserDashboardobj.drop_Account_information();
		UserDashboardobj.drop_negotiation();
		UserDashboardobj.drop_shopping();
		Thread.sleep(1000);
		UserDashboardobj.drop_user_onboarding_process();
		Thread.sleep(2000);
		UserDashboardobj.drop_user_dashboard_help_content();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		UserDashboardobj.input_user_dashboard_Search_bar("rose");
		Thread.sleep(3000);
		UserDashboardobj.search_rose_input_click();
		Thread.sleep(1000);
		UserDashboardobj.input_product_name("Red Rose");
		UserDashboardobj.phone_number_input("9823579453");
		UserDashboardobj.full_name_input("Sabina Bajra");
		UserDashboardobj.input_email_address("sabina1@gmail.com");
		UserDashboardobj.input_description("I need Red rose in full fresh condition.");
		UserDashboardobj.input_submit();
		Thread.sleep(1000);
		UserDashboardobj.click_dismiss();
		driver.navigate().to("https://www.yarsabazar.com/vendor/products");
            test.pass("Navigated back to vendor dashboard successfully");
		Thread.sleep(1000);
		UserDashboardobj.click_My_store_page();
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/seller/sabina"))
		{
			test.pass("Navigated to My Store page successfully");
		}
		else {
			test.pass("Didn't navigated to My Store page");
		}
		UserDashboardobj.click_company_info();
		Thread.sleep(2000);
		UserDashboardobj.click_products();
		Thread.sleep(3000);
		UserDashboardobj.click_image_slide_left();
		Thread.sleep(1000);
		UserDashboardobj.click_slide_right();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		UserDashboardobj.click_dashboard();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		UserDashboardobj.click_request_for_quote();
		Thread.sleep(1000);

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
		Thread.sleep(1000);
		UserDashboardobj.click_dismiss_request();
		test.pass("Request submitted successfully");
		driver.navigate().to("https://www.yarsabazar.com/vendor/products");
		test.pass("Navigated back to vendor dashboard successfully");




		///for business infromation section
		UserDashboardobj.click_business_information();
		Thread.sleep(1000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/profile")){
			test.pass("Navigated to Business Profile section");
		}
		else {
			test.fail("Business Profile section didnot opened");
		}
			Thread.sleep(2000);
		UserDashboardobj.edit_busines_details();
		UserDashboardobj.update_business_details();
		UserDashboardobj.click_registration_details();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/registration-details")){
				test.pass("Navigated to Registration Details section");
			}
			else {
				test.fail("Registration Details section didnot opened");
			}
			Thread.sleep(2000);
		UserDashboardobj.edit_registration_Details();
		UserDashboardobj.click_cancel_registration_details();
			Thread.sleep(2000);
		UserDashboardobj.click_industries();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/industries")){
				test.pass("Navigated to Industries section");
			}
			else {
				test.fail("Industries section didnot opened");
			}
//		UserDashboardobj.add_industries();
			Thread.sleep(2000);
		UserDashboardobj.click_branches();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/branches")){
				test.pass("Navigated to Branches section");
			}
			else {
				test.fail("Branches section didnot opened");
			}
			Thread.sleep(2000);
		UserDashboardobj.click_add_branches();
			Thread.sleep(2000);
		UserDashboardobj.click_cancel_add_branches();
			Thread.sleep(2000);
		UserDashboardobj.click_owners();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/owners")){
				test.pass("Navigated to Owners section");
			}
			else {
				test.fail("Owners section didnot opened");
			}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		UserDashboardobj.click_add_owners();
			Thread.sleep(2000);
		UserDashboardobj.click_cancel_add_owners();
			Thread.sleep(2000);
		UserDashboardobj.click_payment_methods();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/payment-methods")){
				test.pass("Navigated to Payment Methods section");
			}
			else {
				test.fail("Payment Methods section didnot opened");
			}
			Thread.sleep(2000);
		UserDashboardobj.click_cash_payement_method();
			Thread.sleep(2000);
		UserDashboardobj.click_store_iamges();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/business/store-images")){
				test.pass("Navigated to Store Images section");
			}
			else {
				test.fail("Store Images section didnot opened");
			}
			Thread.sleep(2000);

			////for Products section
			UserDashboardobj.click_products_active();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products")){
				test.pass("Navigated to Products section");
			}
			else {
				test.fail("Products section didnot opened");
			}
			Thread.sleep(2000);
			UserDashboardobj.click_drafts();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=draft")){
				test.pass("Navigated to Draft section");
			}
			else {
				test.fail("Draft section didnot opened");
			}
			Thread.sleep(2000);
			UserDashboardobj.click_waiting_approval();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=waiting_approval")){
				test.pass("Navigated to Waiting Approval section");
			}
			else {
				test.fail("Waiting Approval section didnot opened");
			}
			Thread.sleep(2000);
			UserDashboardobj.click_rejected();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/vendor/products?status=rejected")){
				test.pass("Navigated to Rejected section");
			}
			else {
				test.fail("Rejected section didnot opened");
			}
			Thread.sleep(2000);

////for logout
		UserDashboardobj.click_back_to_main_site();
			Thread.sleep(2000);
			if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")){
				test.pass("Navigated to Main site");
			}
			else {
				test.fail("Main site didnot opened");
			}
		Thread.sleep(2000);
		test.pass("Navigated to main site");
		UserDashboardobj.click_profile_button();
		Thread.sleep(1000);
		UserDashboardobj.click_logout_button();
		Thread.sleep(1000);
		if(driver.getCurrentUrl().equals("https://www.yarsabazar.com/")){
			test.pass("User logged out successfully");
		}
		else {
			test.fail("User didn't logged out");
		}
	}

	@DataProvider(name = "VendorRFQ")
	public Object[][] getuserUpdateData() {
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\hp\\OneDrive\\Documents\\Yarsa Office\\My Assessments\\YBtestCredentials.xlsx");

		int rows = config.getRowCount(4);
		Object[][] credentials = new Object[rows - 1 ][5];

		// Assuming the headers are present, use getHeaders to skip the header row
		String[] headers = config.getHeaders(4);

		for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
			credentials[i - 1][0] = config.getData(4, i, 0); // Adjust index to match the data row
			credentials[i - 1][1] = config.getData(4, i, 1);
			credentials[i - 1][2] = config.getData(4, i, 2); // Adjust index to match the data row
			credentials[i - 1][3] = config.getData(4, i, 3);
			credentials[i - 1][4] = config.getData(4, i, 4); // Adjust index to match the data row

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
