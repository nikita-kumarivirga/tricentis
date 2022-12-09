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

public class OrderVerificationTest {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = DriverClass.openBrowser("chrome", "https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test
  public void verifyOrder() {
	  demoShopping checkout = new demoShopping(driver);
	  checkout.doLogin("email@nikita.test", "nikita123");
	  checkout.orderProduct();
	  checkout.doCheckout();
	  checkout.checkoutProcess();
	  String msg = driver.findElement(By.xpath("//*[@class='section order-completed']/div[@class='title']")).getText();
	  Assert.assertEquals(msg, "Your order has been successfully processed!");
	  checkout.doLogout();
  }

}
