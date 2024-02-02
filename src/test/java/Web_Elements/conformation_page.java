package Web_Elements;

import Base_Test.Test_base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class conformation_page extends Test_base {
    @FindBy(xpath = "//div[@class='col-xs-8']//p")
   private List<WebElement> p;
    private static conformation_page page;
   private conformation_page()
    {
        PageFactory.initElements(driver,this);
    }
    public static conformation_page getInstance()
    {
        if (page==null)
        {
            page=new conformation_page();
            return page;
        }
        else
        {
            return page;
        }
    }
    public void validate_application_details()
    {
      Map<String,String>map= MakeAppointment.getInstance().map;

      for (String key:map.keySet())
      {
          switch (key)
          {
              case "Facility": Assert.assertEquals(p.get(0).getText(),map.get(key),"Facility value is not matching");
              break;
              case "Apply for hospital readmission":Assert.assertEquals(p.get(1).getText(),map.get(key),"Apply for hospital readmission -- value is not matching");
              break;
              case "Healthcare Program":Assert.assertEquals(p.get(2).getText(),map.get(key),"Healthcare Program -- value is not matching");
              break;
              case "Visit Date":Assert.assertEquals(p.get(3).getText(),map.get(key),"Visit Date -- value is not matching");
              break;
              case "Comment":Assert.assertEquals(p.get(4).getText(),map.get(key),"Comment -- value is not matching");
              break;
          }
      }
    }
}
