package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndustriesPage {
    WebDriver driver;

    By browse_all_industries_click = By.xpath("/html[1]/body[1]/main[1]/div[3]/a[1]");
    By back_to_dashboard = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[2]");

    public IndustriesPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_browse_all_industries(){
        driver.findElement(browse_all_industries_click).click();
    }

    public  void click_back_to_dashboard(){
        driver.findElement(back_to_dashboard).click();
    }

    public By getBrowse_all_industries_click() {
        return browse_all_industries_click;
    }

    public By getBack_to_dashboard() {
        return back_to_dashboard;
    }
}
