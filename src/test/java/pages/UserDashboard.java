package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class UserDashboard {
    WebDriver driver;

    By Full_Name_Update_button = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[2]/dl[1]/div[1]/dd[1]/div[1]/button[1]");
    By Full_Name_bar= By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[2]/dl[1]/div[1]/dd[1]/input[1]");
    By Full_Name_Savechange_button = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[2]/dl[1]/div[1]/dd[1]/div[1]/button[1]");
    By Email_Update_button = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/div[2]/button[1]");
    By Email_bar = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[2]/dl[1]/div[3]/dd[1]/input[1]");
    By Email_Savechange_button = By.xpath("//button[contains(text(),'Save Changes')]");
    By Change_Password_button = By.linkText("Change Password");
    By Profile_button_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]");
    By Logout_click = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[2]");


    public UserDashboard(WebDriver drivier){
        this.driver= drivier;
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

    public void click_profile_button(){
        driver.findElement(Profile_button_click).click();
    }

    public void click_logout_button(){
        driver.findElement(Logout_click).click();
    }
}
