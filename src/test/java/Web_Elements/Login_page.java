package Web_Elements;

import Base_Test.Test_base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import uitils.Property_manager;

public class Login_page extends Test_base {


    @FindBy(id = "txt-username")
    @CacheLookup
   private  WebElement username_txtbox;


    @FindBy(id = "txt-password")
    @CacheLookup
  private     WebElement password_txtbox;



    @FindBy(id = "btn-login")
    @CacheLookup
  private     WebElement login_tbn;
    private static Login_page loginPage;
   private Login_page()
    {
        PageFactory.initElements(driver,this);
    }
    public static Login_page getInstance()
    {
        loginPage=new Login_page();
        return  loginPage;
    }
    public Login_page validate_user_name_txt_box()
    {

        if(username_txtbox.isEnabled())
        {
            Assert.assertEquals(username_txtbox.getAttribute("placeholder"),"Username","login : username titile is not valid");
            username_txtbox.sendKeys(Property_manager.getInstance().getUsername());
        }
        else {
            System.out.println("username txt box is not enabled");
        }
        return loginPage;
    }
    public Login_page validate_user_name_txt_box(String name)
    {

     // wait.until(ExpectedConditions.visibilityOf(username_txtbox));
        if(username_txtbox.isEnabled())
        {
            Assert.assertEquals(username_txtbox.getAttribute("placeholder"),"Username","login : username titile is not valid");
            username_txtbox.sendKeys(name);
        }
        else {
            System.out.println("username txt box is not enabled");
        }
        return loginPage;
    }
    public Login_page validate_password_txt_box()
    {
        if (password_txtbox.isEnabled())
        {
            Assert.assertEquals(password_txtbox.getAttribute("placeholder"),"Password","login : password titile is not valid");
            password_txtbox.sendKeys(Property_manager.getInstance().getPassword());

        }
        else {
            System.out.println("password txt box is not enabled");
        }
        return loginPage;
    }
    public Login_page validate_password_txt_box(String pass)

    {
        //wait.until(ExpectedConditions.visibilityOf(password_txtbox));
        if (password_txtbox.isEnabled())
        {
            Assert.assertEquals(password_txtbox.getAttribute("placeholder"),"Password","login : password titile is not valid");
            password_txtbox.sendKeys(pass);

        }
        else {
            System.out.println("password txt box is not enabled");
        }
        return loginPage;
    }
    public void validate_login_button()
    {
        Assert.assertEquals(login_tbn.getText(),"Login","Login button name is not valid");
        System.out.println(login_tbn.getSize().height+" - "+login_tbn.getSize().width);
        login_tbn.click();
    }
}
