package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class browser {
WebDriver driver;

@Parameters("browser")
public void setup(String browser) throws Exception {
if (browser.equalsIgnoreCase("firefox")) {
driver = new FirefoxDriver();
} else if (browser.equalsIgnoreCase("chrome")) {
driver = new ChromeDriver();
} else if (browser.equalsIgnoreCase("Edge")) {
driver = new EdgeDriver();
} else {
throw new Exception("Incorrect Browser");
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}


}
