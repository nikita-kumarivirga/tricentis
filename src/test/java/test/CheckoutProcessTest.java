package test;

import org.testng.annotations.Test;

import testCase.demoShopping;
import utility.DriverClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class CheckoutProcessTest {
	WebDriver driver;
	
  @Test
  public void verifyCheckoutProcess() {
	  demoShopping checkout = new demoShopping(driver);
	  checkout.doLogin("email@nikita.test", "nikita123");
	  checkout.orderProduct();
	  checkout.doCheckout();
	  checkout.checkoutProcess();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
  }

}
