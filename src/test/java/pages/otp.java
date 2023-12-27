package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class otp {
    WebDriver driver;

    public String actualVerifyotp = "https://www.yarsabazar.com/verify";
//    public String actualVerifiedotp = "";

    By edit_phoneNumber = By.xpath("//body/div[2]/div[1]/div[1]/button[2]");
    By edit_box_PhoneNumber = By.xpath("//body/div[2]/div[1]/div[1]/form[1]/fieldset[1]/input[1]");
    By tick_button = By.xpath("//body/div[2]/div[1]/div[1]/form[1]/fieldset[1]/button[1]");
    By cross_button = By.xpath("//body/div[2]/div[1]/div[1]/form[1]/fieldset[1]/button[2]");
    By send_otp_box = By.xpath("//body/div[2]/div[1]/div[1]/button[1]");
    By otp_bar = By.xpath("//body/div[2]/form[1]/input[2]");
    By resend_otp = By.xpath("//button[contains(text(),'Resend')]");
    By otp_submit = By.xpath("//button[contains(text(),'Submit')]");
    By otp_try_again = By.xpath("//button[contains(text(),'Try again')]");
    By help = By.xpath("//span[contains(text(),'Help')]");
    By profile_view = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]");
    By account = By.linkText("Account");
    By verfiy_Now = By.linkText("Verify Now");
    By logout = By.xpath("//button[contains(text(),'Logout')]");

    public otp(WebDriver driver){
        this.driver =driver;
    }

    public void click_edit_phoneNumber(){
        driver.findElement(edit_phoneNumber).click();
    }

    public void clear_edit_phoneNumber(){
        driver.findElement(edit_box_PhoneNumber).clear();
    }

    public void input_edit_box_PhoneNumber(String text){
        driver.findElement(edit_box_PhoneNumber).sendKeys("9809803452");
    }


    public void click_tick_button(){
        driver.findElement(tick_button).click();
    }

    public void click_cross_button(){
        driver.findElement(cross_button).click();
    }
    public void click_send_otp_box(){
        driver.findElement(send_otp_box).click();
    }

    public void click_otp_bar(){
        driver.findElement(otp_bar).click();
    }

    public void click_resend_otp(){
        driver.findElement(resend_otp).click();
    }

    public void click_otp_submit(){
        driver.findElement(otp_submit).click();
    }

    public void click_otp_try_again(){
        driver.findElement(otp_try_again).click();
    }

    public void click_help(){
        driver.findElement(help).click();
    }

    public void click_profile_view(){
        driver.findElement(profile_view).click();
    }

    public void click_account(){
        driver.findElement(account).click();
    }

    public void click_Verify_Now(){
        driver.findElement(verfiy_Now).click();
    }

    public void click_logout(){
        driver.findElement(logout).click();
    }

    public By getEdit_box_PhoneNumber(){
        return edit_box_PhoneNumber;
    }

    public By getTick_button(){
        return tick_button;
    }

    public By getOtp_bar(){
        return otp_bar;
    }

    public By getOtp_submit(){
        return otp_submit;
    }
    public By getOtp_try_again(){
        return otp_try_again;
    }

    public By getHelp(){
        return help;
    }

    public By getProfile_view(){
        return profile_view;
    }

    public By getAccount(){
        return account;
    }

    public  By getVerfiy_Now(){
        return verfiy_Now;
    }

    public By getLogout(){
        return logout;
    }
}
