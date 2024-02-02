package Test_cases;

import Base_Test.Test_base;
import Web_Elements.*;
import org.testng.annotations.Test;

public class Happy_path extends Test_base {
    @Test
    public void click_makeAppointment()
    {
        Home_page.getInstance().click_makeAppointment();
    }
    @Test(dependsOnMethods = "click_makeAppointment")
    public void signin()
    {
        Login_page.getInstance().validate_user_name_txt_box()
                .validate_password_txt_box()
                .validate_login_button();
    }
    @Test(dependsOnMethods = "signin")
    public void fill_details()
    {
        MakeAppointment.getInstance().select_facility()
                .select_check_box()
                .select_radio_btn()
                .select_date()
                .enter_comments()
                .click_make_appointment_btn();
    }
    @Test(dependsOnMethods = "fill_details")
    public void validate_given_details()
    {
        conformation_page.getInstance().validate_application_details();
    }
    @Test(dependsOnMethods = "validate_given_details")
    public void validate_history()
    {
        History_page.getInstance().click_toggle().click_history().validate_application_is_present();
    }
}
