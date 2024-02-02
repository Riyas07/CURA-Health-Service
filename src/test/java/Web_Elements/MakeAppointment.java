package Web_Elements;

import Base_Test.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MakeAppointment extends Test_base {
    @FindBy(id = "combo_facility")
    @CacheLookup
  private   WebElement facility;
    @FindBy(id = "chk_hospotal_readmission")
    @CacheLookup
    private   WebElement check_box;
    @FindBy(xpath = "//input[@type='radio']")
    private  List<WebElement> radio_btn;
    @FindBy(className = "input-group-addon")
    @CacheLookup
    private WebElement calender;
    @FindBy(id = "txt_comment")
    @CacheLookup
    private WebElement comment_box;

    @FindBy(id = "btn-book-appointment")
    private WebElement book_btn;
  private static   MakeAppointment makeAppointment;
private MakeAppointment()
 {
     PageFactory.initElements(driver,this);
 }
 public static MakeAppointment getInstance()
 {
     if (makeAppointment ==null)
     {
         makeAppointment=new MakeAppointment();
         return makeAppointment;
     }
     else
     {
         return makeAppointment;
     }
 }
 public Map<String,String> map=new LinkedHashMap<>();
 public MakeAppointment select_facility()
 {
     Select select=new Select(facility);
     select.selectByIndex(1);
     map.put("Facility",select.getFirstSelectedOption().getText());
     return makeAppointment;
 }
 public MakeAppointment select_check_box()
 {
     check_box.click();

     if (check_box.isEnabled())
     {
         map.put("Apply for hospital readmission","Yes");
     }
     else
     {
         map.put("Apply for hospital readmission","No");
     }
     return makeAppointment;
 }
 public MakeAppointment select_radio_btn()
 {
     for (WebElement w:radio_btn)
     {
         w.click();
     }
     for (WebElement w:radio_btn)
     {
         if (w.isSelected())
         {
             map.put("Healthcare Program",w.getAttribute("value"));
         }
     }
     return makeAppointment;
 }
 public MakeAppointment select_date()
 {
   calender.click();
     WebElement cal= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")));
    while (!(cal.getText().equals("August 2024")))
    {
        driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[3]")).click();
    }
    driver.findElement(By.xpath("//tbody//tr[2]//td[6]")).click();
    map.put("Visit Date",driver.findElement(By.id("txt_visit_date")).getAttribute("value"));
     return makeAppointment;
 }
 public MakeAppointment enter_comments()
 {
     comment_box.sendKeys("its working fine");
     map.put("Comment",comment_box.getAttribute("value"));
     return makeAppointment;
 }
 public void click_make_appointment_btn()
 {
     Assert.assertEquals(book_btn.getText(),"Book Appointment","make appointment button text not match");
     book_btn.click();
 }
}
