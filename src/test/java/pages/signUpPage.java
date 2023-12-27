package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUpPage {
    WebDriver driver;

    public String actualSignUpURL = "https://www.yarsabazar.com/signup";
    public String actualSignedUpURL = "https://www.yarsabazar.com/verify";

    By click_SignUp_Button = By.xpath("//a[contains(text(),'Sign Up')]");
    By input_Name = By.xpath("(//input[@id='name'])[1]");
    By input_PhoneNumber = By.xpath("(//input[@id='phone'])[1]");
    By input_Email = By.xpath("(//input[@id='email'])[1]");
    By input_Password = By.xpath("(//input[@id='password'])[1]");
    By click_SignUp = By.xpath("(//button[normalize-space()='Sign Up'])[1]");
    By back_button = By.xpath("(//button[normalize-space()='Back to Yarsa Bazar'])[1]");

    public signUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_SignUp_Button() {
        driver.findElement(click_SignUp_Button).click();
    }

    public void input_Name(String text) {
        driver.findElement(input_Name).sendKeys(text);
    }

    public void input_PhoneNumber(String text) {
        driver.findElement(input_PhoneNumber).sendKeys(text);
    }

    public void input_Email(String text) {
        driver.findElement(input_Email).sendKeys(text);
    }

    public void input_Password(String text) {
        driver.findElement(input_Password).sendKeys(text);
    }

    public void click_SignUp() {
        driver.findElement(click_SignUp).click();
    }

    public void back_button(){
        driver.findElement(back_button).click();
    }

    public By getclick_SignUp_Button(){
        return click_SignUp_Button;
    }

    public By getinput_Name(){
        return input_Name;
    }

    public  By getInput_PhoneNumber(){
        return input_PhoneNumber;
    }

    public By getInput_Email(){
        return input_Email;
    }

    public By getInput_Password(){
        return input_Password;
    }

    public By getBack_button(){
        return back_button;
    }
}