package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    public String LoginURL = "https://www.yarsabazar.com/login";
    public String LoggedInURL = "https://www.yarsabazar.com/account";

    By login_button_click = By.xpath("//a[contains(text(),'Login')]");
    By email_input = By.xpath("//input[@id='username']");
    By password_input = By.xpath("//input[@id='password']");
    By login_click = By.xpath("//button[normalize-space()='Login']");

//    By incorrect_Credentials = By.xpath("//div[contains(text(),'Email or phone is incorrect')]");
//    By invalid_Credentials = By.xpath("//div[contains(text(),'Invalid Credentials')]");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_login_button(){
        driver.findElement(login_button_click).click();
    }

    public void email_Input(String text){
        driver.findElement(email_input).sendKeys(text);
    }

    public void password_Input(String text){
        driver.findElement(password_input).sendKeys(text);
    }

    public void login_Click(){
        driver.findElement(login_click).click();
    }
}
