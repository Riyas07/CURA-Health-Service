package Base_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import uitils.Property_manager;

import java.time.Duration;

public class Test_base {

   public static WebDriver driver;
   public static Wait<WebDriver> wait;
    @BeforeClass
     public void base()
     {
         EdgeOptions options=new EdgeOptions();
         options.addArguments("start-maximized");
         //options.addArguments("--headless");
         options.addArguments("disable-gpu");
         driver=new EdgeDriver(options);
         driver.get(Property_manager.getInstance().getBase_url());
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         wait=new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofSeconds(5))
                 .ignoring(StaleElementReferenceException.class);
     }

     @AfterClass
    public void logout()
     {
         //Logout
         driver.findElement(By.id("menu-toggle")).click();
         driver.findElement(By.linkText("Logout")).click();
         driver.quit();
     }
}
