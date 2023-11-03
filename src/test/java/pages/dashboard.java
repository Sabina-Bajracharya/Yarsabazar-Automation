package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboard {
    WebDriver driver;
    private boolean displayed;

    By logo = By.cssSelector(".h-8[height='32']");
    By help_click = By.xpath("//header/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");
//    By login_click =By.xpath("//a[contains(text(),'Login')]");
//    By back_click = By.xpath("/html[1]/body[1]/div[2]/div[1]/button[1]");
//    By signup_click = By.xpath("//a[contains(text(),'Sign Up')]");
//    By Yarsa_Bazar_Name = By.xpath("//body/main[1]/div[1]/img[1]");
//    By search_bar = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
//    By search_button_click = By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
//    By industries = By.xpath("//h1[contains(text(),'Industries')]");
//    By see_all_click = By.xpath("//a[contains(text(),'See all')]");
//    By request_here_click = By.xpath("//button[contains(text(),'Request Here')]");
//    By start_selling_click = By.xpath("//body/main[1]/div[2]/div[1]/div[2]/div[1]/button[1]");


public dashboard(WebDriver driver){
    this.driver = driver;
}
    //to display verify login page is opened
    public  boolean isLogoDisplayed() {

    driver.findElement(logo).isDisplayed();
        return displayed;
    }

    public void click_help(){
    driver.findElement(help_click).click();
    }


//    public void click_login(){
//    driver.findElement(login_click).click();
//    }
//
//    public void click_back(){
//    driver.findElement(back_click).click();
//    }
//
//    public void click_signup(){
//    driver.findElement(signup_click).click();
//    }
//
//    public boolean isYarsabazarDisplayed(){
//    driver.findElement(Yarsa_Bazar_Name).isDisplayed();
//    return displayed;
//    }
//
//    public boolean isSearchDisplayed(){
//    driver.findElement(search_bar).isDisplayed();
//    return displayed;
//    }
//
//    public void click_search_button(){
//    driver.findElement(search_button_click);
//    }
//
//    public boolean isIndustriesDisplayed(){
//    driver.findElement(industries).isDisplayed();
//    return displayed;
//    }
//
//    public void click_see_all(){
//    driver.findElement(see_all_click).click();
//    }
//
//    public void click_request_here(){
//    driver.findElement(request_here_click).click();
//    }
//
//    public void click_start_selling(){
//    driver.findElement(start_selling_click).click();
//    }
}

