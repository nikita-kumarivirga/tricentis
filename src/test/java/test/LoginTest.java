package test;

import org.testng.annotations.Test;

import testCase.demoShopping;
import utility.DriverClass;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  @Test
  public void verifyLogin() {
	  
	  demoShopping login = new demoShopping(driver);
	  login.doLogin("email@nikita.test", "nikita123");
	  String text = driver.findElement(By.linkText("Log out")).getText();	  
	  Assert.assertEquals(text, "Log out");
	  if(text.equalsIgnoreCase("Log out"))
	  {
		  System.out.println("Successful Login!");
	  }
	  else
	  {
		  System.out.println("Invalid Login");
	  }
  }

}
