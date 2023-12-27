package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    public String LoginURL = "https://www.yarsabazar.com/login";
    public String LoggedInURL ="https://www.yarsabazar.com/verify?redirectTo=/account";

    By login_button_click = By.xpath("//a[contains(text(),'Login')]");
    By email_input = By.xpath("(//input[@id='username'])[1]");
    By password_input = By.xpath("(//input[@id='password'])[1]");
    By login_click = By.xpath("//button[normalize-space()='Login']");
    By profile_button = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]");
    By logout_click = By.xpath("//div[@id=':rg:']");


    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_login_button() {
        driver.findElement(login_button_click).click();
    }

    public void email_Input(String text) {
        driver.findElement(email_input).sendKeys(text);
    }

    public void password_Input(String text) {
        driver.findElement(password_input).sendKeys(text);
    }

    public void login_Click() {

        driver.findElement(login_click).click();
    }

    public  void profile_button_click(){
        driver.findElement(profile_button).click();
    }

    public void logout_Click() {
        driver.findElement(logout_click).click();
    }

    public By getEmail_input(){
        return email_input;
    }

    public By getPassword_input(){
        return password_input;
    }

    public By getlogin_Click(){
        return  login_click;
    }

    public By getlogout_Click(){
        return logout_click;
    }

}