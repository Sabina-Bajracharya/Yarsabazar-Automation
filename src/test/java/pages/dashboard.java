package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboard {
    WebDriver driver;
    private boolean displayed;

    By logo = By.cssSelector(".h-8[height='32']");
    By help_click = By.xpath("//header/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");
    By login_click =By.xpath("//a[contains(text(),'Login')]");
    By signup_click = By.xpath("//a[contains(text(),'Sign Up')]");
    By Yarsa_Bazar_Name_displayed = By.xpath("//body/main[1]/div[1]/img[1]");



public dashboard(WebDriver driver){
    this.driver = driver;
}
    //to display verify login page is opened
    public  boolean isLogoDisplayed() {

    driver.findElement(logo).isDisplayed();
        return displayed;
    }

}

