package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class search {

    WebDriver driver;

    By search_bar_input = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
//    By dog_food_click = By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]");
    By back_to_dashboard = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[2]");
    By search_icon_click = By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
    public search(WebDriver driver){
        this.driver =driver;
    }

    public void input_search_bar(String text){
        driver.findElement(search_bar_input).sendKeys(text);
    }

//    public void click_dog_food(){
//        driver.findElement(dog_food_click).click();
//    }
    public void click_Search_icon(){
        driver.findElement(search_icon_click).click();
    }
    public void click_back_to_dashborad(){
        driver.findElement(back_to_dashboard).click();
    }

}

