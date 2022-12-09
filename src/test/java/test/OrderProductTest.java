package test;

import org.testng.annotations.Test;

import testCase.demoShopping;
import utility.DriverClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class OrderProductTest {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
  }
 
  @Test
  public void verifyOrder() {
	  demoShopping order = new demoShopping(driver);
	  order.doLogin("email@nikita.test", "nikita123");
	  order.orderProduct();
	  String text = driver.findElement(By.partialLinkText("Shopping cart")).getText();
	  if(text.contains("(10)"))
	  {
		  System.out.println("Item added to the cart");
	  }
	  else
	  {
		  System.out.println("Item is not added");
	  }
  }

}
