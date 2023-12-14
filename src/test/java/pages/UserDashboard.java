package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDashboard {
    WebDriver driver;

    ////for account details

    By account_Details_click = By.xpath("//span[contains(text(),'Account Details')]");
    By Full_Name_Update_button = By.xpath("//button[contains(text(),'Update')]");
    By Full_Name_bar= By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[1]/dd[1]/input[1]");
    By Full_Name_Savechange_button = By.xpath("//button[contains(text(),'Save Changes')]");
    By Email_Update_button = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/div[2]/button[1]");
    By Email_bar = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/input[1]");
    By Email_Savechange_button = By.xpath("//button[contains(text(),'Save Changes')]");

    ////for change password

    By Change_Password_button = By.linkText("Change Password");
    By New_Password_field = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By Confirm_New_Password_field = By.xpath("//body/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]");
    By Change_Password_click = By.xpath("//button[contains(text(),'Change Password')]");
    By Email_verify_button_click =By.xpath("//button[contains(text(),'Verify')]");
    By cancel_email_verify = By.xpath("//button[contains(text(),'Cancel')]");

    //// for help field on main site

    By help_button_click = By.xpath("//header/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");
    By account_information_drop = By.xpath("//span[contains(text(),'Account Information')]");
    By negotiation_drop = By.xpath("//span[contains(text(),'Negotiation')]");
    By shopping_drop = By.xpath("//span[contains(text(),'Shopping')]");
    By user_onboarding_process_drop = By.xpath("//span[contains(text(),'User Onboarding Process')]");
    By user_dashboard_help_content_drop = By.xpath("//span[contains(text(),'User Dashboard Help Content')]");

    //// for user search bar

    By user_dashboard_search_bar = By.tagName("input");
    By rose_input_search = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]/span[1]");
    By product_name = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/input[1]");
    By phone_number = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/input[1]");
    By full_name = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]");
    By email_address = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[2]/input[1]");
    By description = By.tagName("textarea");
    By submit_click = By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/button[1]");
    By dismiss_click = By.xpath("//button[contains(text(),'Dismiss')]");

    ////for help field on dashboard
    By click_help_dashboard =By.xpath("//body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]/span[1]");

    ////for my store page
    By My_Store_Page_click = By.linkText("My Store Page");
    By Company_Info_click = By.xpath("//span[contains(text(),'Company Info')]");
    By products_click = By.xpath("//span[contains(text(),'Products')]");
//    By phone_click = By.xpath("//span[contains(text(),'Phone')]");
//    By Email_click = By.xpath("//span[contains(text(),'Email')]");
    By image_slide_left_click = By.xpath("//body/main[1]/div[1]/div[1]/button[1]");
    By image_slide_right_click = By.xpath("//body/main[1]/div[1]/div[1]/button[2]");
    By Dashboard_click = By.linkText("Dashboard");

    ////for request for quote secttion

    By request_for_quote_click = By.linkText("Request for Quote");
    By request_fullname_input = By.xpath("//body/div[2]/div[2]/div[1]/form[1]/fieldset[1]/div[1]/input[1]");
    By request_MobileNumber_input = By.xpath("//body/div[2]/div[2]/div[1]/form[1]/fieldset[1]/div[2]/input[1]");
    By request_ProductName_input = By.xpath("//body/div[2]/div[2]/div[1]/form[1]/fieldset[1]/div[3]/div[1]/input[1]");
    By request_quantity_input = By.xpath("//body/div[2]/div[2]/div[1]/form[1]/fieldset[1]/div[3]/div[2]/input[1]");
    By reuest_More_Information_input = By.tagName("textarea");
    By request_submit = By.xpath("//button[contains(text(),'Submit')]");
    By request_dismiss_click = By.xpath("//button[contains(text(),'Dismiss')]");

    ////for business information section
    By Busines_Information_click = By.linkText("Business Information");
    By Edit_Business_Information_Details = By.xpath("//button[contains(text(),'Edit Details')]");
    By Update_Business_Information_Details = By.xpath("//body/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/button[2]");
    By Registration_Details = By.linkText("Registration Details");
    By Edit_Registration_Details = By.xpath("//button[contains(text(),'Edit')]");
    By Cancel_Registration_Details = By.xpath("//body/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]");
    By Industries = By.linkText("Industries");
    By Add_Industries = By.xpath("//body/div[2]/div[2]/div[3]/div[1]/button[1]");
//    By Add_Food_Industry = By.xpath("//body/div[@id='radix-:rho:']/div[2]/div[1]/button[4]");
    By Branches = By.linkText("Branches");
    By Add_Branches = By.xpath("//button[contains(text(),'Add Branch')]");
    By Cancel_Add_Branches = By.xpath("//body/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]");
    By Owners = By.linkText("Owners");
    By Add_Owners = By.xpath("//button[contains(text(),'Add Owner')]");
    By Cancel_Add_Owners = By.xpath("//body/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]");
    By Payment_Methods = By.linkText("Payment Methods");
    By Cash_Payment_Mehtods = By.xpath("//body/div[2]/div[2]/div[3]/div[2]/button[1]");
    By Store_Images = By.linkText("Store Images");


    ////for Products

    By Products = By.linkText("Products");
    By Draft =By.linkText("Draft");
    By Waiting_Approval = By.linkText("Waiting Approval");
    By Rejected = By.linkText("Rejected");
//    By products_Add_Product = By.linkText("Add Product");
//    By product_Product_name = By.xpath("//input[@id=':rca:-form-item']");
//    By Category_drop_click = By.xpath("//span[contains(text(),'Choose product category')]");
//    By Ring_Category = By.xpath("//div[contains(text(),'Blue Topaz Ring')]");
//    By highlight_name = By.xpath("//input[@id=':rcg:']");
//    By highlight_value = By.xpath("//input[@id=':rch:-form-item']");
//    By highlight_extra_info = By.xpath("//input[@id=':rci:-form-item']");
//    By add_highlight = By. xpath("//body/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]");
//    By highlight_delete = By.xpath("//body/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/button[1]");
//    By highlight_choose_image = By.xpath("//body/div[2]/div[2]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[1]/div[1]");
//    By highlight_create = By.xpath("//button[contains(text(),'Create')]");
//
//    By product_tag = By.xpath("//input[@id=':rcn:']");
//    By description_product = By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[2]/div[1]/p[1]");
//    By minimum_orders =By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[2]/div[1]/p[1]");
//    By Add_pricing = By.xpath("//button[contains(text(),'Add Pricing')]");
//    By currency = By.xpath("//span[contains(text(),'Choose choose currency')]");
//    By currency_nepalese_Rupee = By.xpath("//div[contains(text(),'Nepalese Rupee')]");
//    By price = By.xpath("//input[@id=':reu:-form-item']");
//    By Unit = By.xpath("//body/div[2]/div[2]/div[1]/div[2]/form[1]/div[6]/div[1]/div[1]/div[3]/button[1]/span[1]");
//    By back_to_products = By.xpath("//span[contains(text(),'Back to Products')]");

    ////For directing to main site
    By back_to_main_site = By.xpath("//span[contains(text(),'Goto main site')]");

    ////for logout

    By Profile_button_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]");
    By Logout_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[2]");


////for Account Details Section

    public UserDashboard(WebDriver drivier){
        this.driver= drivier;
    }

    public void click_account_details(){
        driver.findElement(account_Details_click).click();
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

    ////for Change Password Section
    public void click_Change_Password(){
        driver.findElement(Change_Password_button).click();
    }

    public void input_New_Password_field(String text){
        driver.findElement(New_Password_field).sendKeys("Sabina12@34");
    }

    public  void input_confirm_New_Password_field(String text){
        driver.findElement(Confirm_New_Password_field).sendKeys("Sabina12@34");
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

    ////for Help Section
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

    ////for Search Bar Section

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
        driver.findElement(phone_number).sendKeys("9823579453");
    }

    public  void full_name_input(String text){
        driver.findElement(full_name).sendKeys("Sabina Bajra");
    }

    public void input_email_address(String text){
        driver.findElement(email_address).sendKeys("sabina1@gmail.com");
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

    ////for My Store Page Section
    public void click_My_store_page(){
        driver.findElement(My_Store_Page_click).click();
    }
    public void click_company_info(){
        driver.findElement(Company_Info_click).click();
    }

    public void click_products(){
        driver.findElement(products_click).click();
    }

//    public void click_phone(){
//        driver.findElement(phone_click).click();
//    }
//
//    public void click_email(){
//        driver.findElement(Email_click).click();
//    }

    public void click_image_slide_left(){
        driver.findElement(image_slide_left_click).click();
    }

    public void click_slide_right(){
        driver.findElement(image_slide_right_click).click();
    }

    public void click_dashboard(){
        driver.findElement(Dashboard_click).click();
    }

    public void click_request_for_quote(){
        driver.findElement(request_for_quote_click).click();
    }

    public void input_fullname_request(String text){
        driver.findElement(request_fullname_input).sendKeys(text);
    }

    public void input_MobileNumber_request(String text){
        driver.findElement(request_MobileNumber_input).sendKeys(text);
    }

    public void input_ProductName_request(String text){
        driver.findElement(request_ProductName_input).sendKeys(text);
    }

    public void input_quantity_request(String text){
        driver.findElement(request_quantity_input).sendKeys(text);
    }

    public void input_More_Information_request(String text){
        driver.findElement(reuest_More_Information_input).sendKeys(text);
    }

    public void click_submit_request(){
        driver.findElement(request_submit).click();
    }

    public void click_dismiss_request(){
        driver.findElement(request_dismiss_click).click();
    }

////for business information section
    public void click_business_information(){
        driver.findElement(Busines_Information_click).click();
    }

    public void edit_busines_details(){
        driver.findElement(Edit_Business_Information_Details).click();
    }

    public void update_business_details(){
        driver.findElement(Update_Business_Information_Details).click();
    }

    public void click_registration_details(){
        driver.findElement(Registration_Details).click();
    }

    public void edit_registration_Details(){
        driver.findElement(Edit_Registration_Details).click();
    }

    public void click_cancel_registration_details(){
        driver.findElement(Cancel_Registration_Details).click();
    }

    public void click_industries(){
        driver.findElement(Industries).click();
    }

    public void add_industries(){
        driver.findElement(Add_Industries).click();
    }

    public void click_branches(){
        driver.findElement(Branches).click();
    }

    public void click_add_branches(){
        driver.findElement(Add_Branches).click();
    }

    public void click_cancel_add_branches(){
        driver.findElement(Cancel_Add_Branches).click();
    }

    public void click_owners(){
        driver.findElement(Owners).click();
    }

    public void click_add_owners(){
        driver.findElement(Add_Owners).click();
    }

    public void click_cancel_add_owners(){
        driver.findElement(Cancel_Add_Owners).click();
    }

    public void click_payment_methods(){
        driver.findElement(Payment_Methods).click();
    }

    public void click_cash_payement_method(){
        driver.findElement(Cash_Payment_Mehtods).click();
    }

    public void click_store_iamges(){
        driver.findElement(Store_Images).click();
    }

    ////for products

    public void click_products_active(){
        driver.findElement(Products).click();
    }

    public void click_drafts(){
        driver.findElement(Draft).click();
    }

    public void click_waiting_approval(){
        driver.findElement(Waiting_Approval).click();
    }

    public void click_rejected(){
        driver.findElement(Rejected).click();
    }



    ////for logout section

    public void click_back_to_main_site(){
        driver.findElement(back_to_main_site).click();
    }

    public void click_profile_button(){
        driver.findElement(Profile_button_click).click();
    }

    public void click_logout_button(){
        driver.findElement(Logout_click).click();
    }
}
