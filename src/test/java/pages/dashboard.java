package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboard {
    WebDriver driver;
    private boolean displayed;

    By logo = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");



    public dashboard(WebDriver driver){
        this.driver = driver;
    }
    //to display verify login page is opened
    public  boolean isLogoDisplayed() {

        driver.findElement(logo).isDisplayed();
        return displayed;
    }
}
