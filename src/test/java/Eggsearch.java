import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Eggsearch {

    public static WebDriver driver; // Setting Global WebDriver Object


        @DataProvider (name = "data-provide")
        public Object[][] dpMathod(){
            return new Object[][]{{"egg"}};

    }

        @Test(dataProvider = "data-provide")
        public void chromeTest(String b){

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            Map<String, Object> profile = new HashMap<String, Object>();
            Map<String, Integer> contentSettings = new HashMap<String, Integer>();

            contentSettings.put("notifications",2);
            contentSettings.put("geolocation",2);
            profile.put("managed_default_content_settings",contentSettings);
            prefs.put("profile",profile);
            options.setExperimentalOption("prefs",prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Max wait 10s but find
            // and hit asa
            driver.get("https://chaldal.com/");
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//*[@name=\"search_term_string\"]")).sendKeys(b);
            driver.findElement(By.xpath("//*[@name=\"search_term_string\"]")).sendKeys(Keys.ENTER);
            System.out.println("This is example: " + b);
        }
        //driver.findElement(By.xpath("//*[@name=\"search_term_string\"]")).click();

}