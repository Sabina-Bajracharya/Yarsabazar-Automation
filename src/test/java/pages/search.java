//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class search {
//
//    WebDriver driver;
//    public String searchURL = "https://www.yarsabazar.com/search?q=";
//
//    By search_button_click = By.xpath("(//button[@class='relative z-[1] ml-auto h-full rounded-md bg-tertiary-600 px-8 text-white shadow-sm hover:opacity-90 active:opacity-100 max-sm:hidden'])[1]");
//    By search_bar_input = By.xpath("(//input[@id=':r2g:'])[1]");
//
//    public search(WebDriver driver){
//     this.driver =driver;
//    }
//
//    public void click_search_button(){
//        driver.findElement(search_button_click).click();
//    }
//
//    public void input_search_bar(String text){
//        driver.findElement(search_bar_input).sendKeys(text);
//    }
//}
