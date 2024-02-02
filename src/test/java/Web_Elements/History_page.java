package Web_Elements;

import Base_Test.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class History_page extends Test_base {
    @FindBy(id = "menu-toggle")
    WebElement toggle;
    @FindBy(linkText = "History")
    WebElement history_link;
    private static History_page page;
  private   History_page()
    {
        PageFactory.initElements(driver,this);
    }
    public static History_page getInstance()
    {
        if (page==null)
        {
            page=new History_page();
            return page;
        }
        else {
            return page;
        }
    }
    public History_page click_toggle()
    {
        toggle.click();
        return  page;
    }
    public History_page click_history()
    {
        history_link.click();
        return page;
    }
    public void validate_application_is_present()
    {
       Map<String,String>map= MakeAppointment.getInstance().map;
       String date= map.get("Visit Date");
       String xpath="//div[contains(text(),"+"\""+date+"\""+")]";
    String s=   driver.findElement(By.xpath(xpath)).getText();
        System.out.println(s);
        Assert.assertEquals(false,s.isEmpty(),"application not present in history");
    }
}
