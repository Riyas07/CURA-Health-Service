package uitils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Property_manager {
  private String base_url;
  private String username;
  private String password;
 private static Property_manager propertyManager;
 private Properties properties;
 private Property_manager()
 {
     try {
         InputStream inputStream=new FileInputStream("config/config.properties");
         properties=new Properties();
         properties.load(inputStream);
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
 }
 public static Property_manager getInstance()
 {
     if (propertyManager==null)
     {
         propertyManager=new Property_manager();
         return propertyManager;
     }
     else {
         return propertyManager;
     }
 }
 public String getBase_url()
 {
     return properties.getProperty("Base_url");
 }
 public String getUsername()
 {
     return properties.getProperty("username");
 }
 public String getPassword()
 {
     return properties.getProperty("password");
 }
}
