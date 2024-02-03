package Test_cases;

import Base_Test.Test_base;
import Web_Elements.Login_page;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UnHappy_path extends Test_base {
    @Test
    public void invalid_login_credentials() {
        Login_page.getInstance()
                .validate_user_name_txt_box("riyas")
                .validate_password_txt_box("riyas")
                .validate_login_button();
      WebElement warn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12 text-center']//following::p[@class='lead text-danger']")));
     String msg="Login failed! Please ensure the username and password are valid.";
      if(warn.getText().equals(msg))
      {
        TakesScreenshot takesScreenshot=  (TakesScreenshot)driver;
      File from= takesScreenshot.getScreenshotAs(OutputType.FILE);
      File to=new File("src/main/resources/screenShot/loginerror.png");
          try
          {
              FileHandler.copy(from,to);
          }
          catch (Exception e)
          {
              e.printStackTrace();
          }
      }
    }
}
