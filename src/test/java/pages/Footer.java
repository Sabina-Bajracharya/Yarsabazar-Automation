package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer {
    WebDriver driver;

    By Privacy_Policy_click = By.xpath("//a[contains(text(),'Privacy Policy')]");
    By Terms_of_Services_click = By.xpath("//a[contains(text(),'Terms of Service')]");
    By Sell_on_Yarsa_Bazar_click = By.xpath("//button[contains(text(),'Sell on Yarsa Bazar')]");

    public Footer(WebDriver driver){
        this.driver = driver;
    }

    public void click_Privacy_Policy(){
        driver.findElement(Privacy_Policy_click).click();
    }

    public void click_Terms_of_Services(){
        driver.findElement(Terms_of_Services_click).click();
    }

//    public void click_Sell_on_Yarsa_Bazar(){
//        driver.findElement(Sell_on_Yarsa_Bazar_click).click();
//
}
