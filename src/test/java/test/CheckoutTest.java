package test;

import org.testng.annotations.Test;

import testCase.demoShopping;
import utility.DriverClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class CheckoutTest {
	WebDriver driver;
	
  @Test
  public void verifyCheckout() {
	  demoShopping check = new demoShopping(driver);
	  check.doLogin("email@nikita.test", "nikita123");
	  check.orderProduct();
	  check.doCheckout();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
  }

}
