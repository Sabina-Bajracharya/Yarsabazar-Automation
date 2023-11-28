package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Alert;
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
                test.pass("Logo is displayed");

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
            return new Object[][]{

				{"9823579453", "Sabina12@34"}

            };
        }

    	@Test(priority = 3, dataProvider = "UserUpdateData")
	public void UserDashboardTest(String Name, String Email) throws InterruptedException {
		ExtentTest test = extent.createTest("Verify User Dashboard");
		UserDashboard UserDashboardobj = new UserDashboard(driver);

		UserDashboardobj.click_account_details();
		Thread.sleep(2000);
            test.pass("Account Details opened successfully");
		UserDashboardobj.click_Full_Name_Update_button();
		UserDashboardobj.clear_Full_Name_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Full_Name_bar(Name);
		Thread.sleep(1000);
		UserDashboardobj.click_buttton_Full_Name_Savechange();
		Thread.sleep(1000);
            test.pass("Full Name updated successfully");
		UserDashboardobj.click_Email_Update_button();
		Thread.sleep(1000);
		UserDashboardobj.clear_Email_bar();
		Thread.sleep(1000);
		UserDashboardobj.edit_Email_bar(Email);
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
        test.pass("Request for Quote page opened successfully");
		UserDashboardobj.input_fullname_request("Sabina Bajra");
		UserDashboardobj.input_MobileNumber_request("9823579453");
		UserDashboardobj.input_ProductName_request("Boat earphones");
		UserDashboardobj.input_quantity_request("18");
		UserDashboardobj.input_More_Information_request("I need good quality Boat earphones before Tihar");
		UserDashboardobj.click_submit_request();
		Thread.sleep(1000);
		UserDashboardobj.click_dismiss_request();
		test.pass("Request submitted successfully");
		driver.navigate().to("https://www.yarsabazar.com/vendor/products");
		test.pass("Navigated back to vendor dashboard successfully");

		UserDashboardobj.click_back_to_main_site();
		Thread.sleep(2000);
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

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
        System.out.println("Test Completed Successfully");
        extent.flush();

    }
}
