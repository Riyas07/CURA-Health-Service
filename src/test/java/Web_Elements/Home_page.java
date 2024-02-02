package Web_Elements;

import Base_Test.Test_base;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home_page extends Test_base {
    @CacheLookup
    @FindBy(linkText = "Make Appointment")
  private   WebElement makeAppointment_link;
    private static Home_page homePage;
   private Home_page()
    {
        PageFactory.initElements(driver,this);
    }
    public static Home_page getInstance()
    {
        if (homePage==null)
        {
            homePage=new Home_page();
            return homePage;
        }
        else {
            return homePage;
        }
    }
    public void click_makeAppointment()
    {
        String s=makeAppointment_link.getCssValue("background-color");
        Assert.assertEquals(s,"rgba(115, 112, 181, 0.8)","make appointment color is different");
        Point point= makeAppointment_link.getLocation();
        System.out.println(point.getX()+" : "+point.getY());
        makeAppointment_link.click();
    }
}
