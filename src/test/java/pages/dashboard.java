package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard {
    WebDriver driver;
    private boolean displayed;
    By logo = By.cssSelector(".h-8[height='32']");

public dashboard(WebDriver driver){
    this.driver = driver;
}
    //to display verify login page is opened
    public  boolean isLogoDisplayed() {

    driver.findElement(logo).isDisplayed();
        return displayed;
    }

}

