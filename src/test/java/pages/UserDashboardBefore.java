package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDashboardBefore {
    WebDriver driver;

    By Full_Name_Update_button = By.xpath("//button[contains(text(),'Update')]");
    By Full_Name_bar= By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[1]/dd[1]/input[1]");
    By Full_Name_Savechange_button = By.xpath("//button[contains(text(),'Save Changes')]");
    By Email_Update_button = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/div[2]/button[1]");
    By Email_bar = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/input[1]");
    By Email_Savechange_button = By.xpath("//button[contains(text(),'Save Changes')]");
    By Change_Password_button = By.linkText("Change Password");
    By New_Password_field = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By Confirm_New_Password_field = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]");
    By Change_Password_click = By.xpath("//button[contains(text(),'Change Password')]");
    By Email_verify_button_click =By.xpath("//button[contains(text(),'Verify')]");
    By cancel_email_verify = By.xpath("//button[contains(text(),'Cancel')]");
    By help_button_click = By.xpath("//header/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");
    By account_information_drop = By.xpath("//span[contains(text(),'Account Information')]");
    By negotiation_drop = By.xpath("//span[contains(text(),'Negotiation')]");
    By shopping_drop = By.xpath("//span[contains(text(),'Shopping')]");
    By user_onboarding_process_drop = By.xpath("//span[contains(text(),'User Onboarding Process')]");
    By user_dashboard_help_content_drop = By.xpath("//span[contains(text(),'User Dashboard Help Content')]");
    By user_dashboard_search_bar = By.tagName("input");
    By rose_input_search = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]/span[1]");
    By product_name = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/input[1]");
    By phone_number = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/input[1]");
    By full_name = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]");
    By email_address = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[2]/input[1]");
    By description = By.tagName("textarea");
    By Profile_button_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]");
    By submit_click = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/button[1]");
    By dismiss_click = By.xpath("//button[contains(text(),'Dismiss')]");

    ////To signup on sell on yarsabazar through user dashboard
    By sell_on_Yarsabazar = By.linkText("Sell on Yarsa Bazar");
//    By line_of_business = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/button[4]");
//    By next_step = By.xpath("//span[contains(text(),'Next Step')]");
//    By go_back= By.xpath("//button[contains(text(),'Go Back')]");
//    By username = By.cssSelector("#userName");
//    By companyname = By.xpath("//body/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]");
//    By company_email = By.xpath("//body/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]");
//    By mobile_number = By.xpath("//body/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[4]/input[1]");
//    By company_type =By.xpath("select");
//    By start_year = By.xpath("//body/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[6]/input[1]");
//    By start_Selling = By.xpath("//body/div[2]/div[2]/div[1]/div[2]/button[2]");

    By Logout_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[2]");

    public UserDashboardBefore(WebDriver driver) {
        this.driver = driver;
    }

    public void click_Full_Name_Update_button(){
        driver.findElement(Full_Name_Update_button).click();
    }

    public void clear_Full_Name_bar(){
        driver.findElement(Full_Name_bar).clear();
    }

    public void edit_Full_Name_bar(String text){
        driver.findElement(Full_Name_bar).sendKeys(text);
    }

    public void click_buttton_Full_Name_Savechange(){
        driver.findElement(Full_Name_Savechange_button).click();
    }

    public void click_Email_Update_button(){
        driver.findElement(Email_Update_button).click();

    }

    public void clear_Email_bar(){
        driver.findElement(Email_bar).clear();
    }

    public void edit_Email_bar(String text){
        driver.findElement(Email_bar).sendKeys(text);
    }

    public void click_Email_savechange_button(){
        driver.findElement(Email_Savechange_button).click();
    }

    public void click_Change_Password(){
        driver.findElement(Change_Password_button).click();
    }

    public void input_New_Password_field(String text){
        driver.findElement(New_Password_field).sendKeys(text);
    }

    public  void input_confirm_New_Password_field(String text){
        driver.findElement(Confirm_New_Password_field).sendKeys(text);
    }

    public void Change_Password_button_click(){
        driver.findElement(Change_Password_click).click();
    }

    public  void click_Email_Verify_Button(){
        driver.findElement(Email_verify_button_click).click();
    }

    public void verify_email_cancel(){
        driver.findElement(cancel_email_verify).click();
    }

    public void click_help_button(){
        driver.findElement(help_button_click).click();
    }

    public void drop_Account_information(){
        driver.findElement(account_information_drop).click();
    }

    public void drop_negotiation(){
        driver.findElement(negotiation_drop).click();
    }

    public void drop_shopping(){
        driver.findElement(shopping_drop).click();
    }

    public void drop_user_onboarding_process(){
        driver.findElement(user_onboarding_process_drop).click();
    }

    public void drop_user_dashboard_help_content(){
        driver.findElement(user_dashboard_help_content_drop).click();
    }

    public void input_user_dashboard_Search_bar(String text){
        driver.findElement(user_dashboard_search_bar).sendKeys("rose");
    }

    public void search_rose_input_click(){
        driver.findElement(rose_input_search).click();
    }

    public void input_product_name(String text){
        driver.findElement(product_name).sendKeys("Red Rose");
    }

    public void phone_number_input(String text){
        driver.findElement(phone_number).sendKeys("9762784654");
    }

    public  void full_name_input(String text){
        driver.findElement(full_name).sendKeys("Simran Bajra");
    }

    public void input_email_address(String text){
        driver.findElement(email_address).sendKeys("xyz@gmail.com");
    }

    public void input_description(String text){
        driver.findElement(description).sendKeys("I need Red rose in full fresh condition.");
    }

    public void input_submit(){
        driver.findElement(submit_click).click();
    }

    public void click_dismiss(){
        driver.findElement(dismiss_click).click();
    }

    ////To signup on sell on yarsabazar through user dashboard
    public void click_sell_on_yarsabzar(){
        driver.findElement(sell_on_Yarsabazar).click();
    }
//    public void choose_line_of_business(){
//        driver.findElement(line_of_business).click();
//    }
//    public void click_next_step(){
//        driver.findElement(next_step).click();
//    }
//    public void click_go_back(){
//        driver.findElement(go_back).click();
//    }
//    public void input_username(String text){
//        driver.findElement(username).sendKeys("SABINA");
//    }
//    public void input_company_name(String text){
//        driver.findElement(companyname).sendKeys("Raw Production Pvt.Ltd");
//    }
//    public void input_company_email(String text){
//        driver.findElement(company_email).sendKeys("raw@gmail.com");
//    }
//    public void input_mobile_number(String text){
//        driver.findElement(mobile_number).sendKeys("9823579453");
//    }
//    public void drop_company_type(){
//        driver.findElement(company_type).click();
//    }
//    public void input_start_year(String text){
//        driver.findElement(start_year).sendKeys("2019");
//    }
//    public void click_start_Selling(){
//        driver.findElement(start_Selling).click();
//    }

    public void click_profile_button(){
        driver.findElement(Profile_button_click).click();
    }

    public void click_logout_button(){
        driver.findElement(Logout_click).click();
    }
}

