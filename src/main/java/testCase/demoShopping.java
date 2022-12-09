package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class demoShopping {
	WebDriver driver;
	//login
	By loginlink = By.linkText("Log in");
	By email = By.id("Email");
	By pass = By.id("Password");
	By loginbtn = By.xpath("//*[@value='Log in']");
	By logoutbtn = By.linkText("Log out");
	
	//order product
	By a_s = By.partialLinkText("Apparel & Shoes");
	By golfbelt = By.linkText("Casual Golf Belt");
	By quantity = By.id("addtocart_40_EnteredQuantity");
	By addtocart = By.id("add-to-cart-button-40");
	By shoppingcartlink = By.partialLinkText("Shopping cart");
	
	//start checkout
	By checkoutbtn = By.id("checkout");
	By tos_chkbox = By.id("termsofservice");
	
	//checkout process
	By ba_continuebtn = By.xpath("//*[@id=\"billing-buttons-container\"]/input");
	By sa_continuebtn = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
	By groundradiobtn = By.id("shippingoption_0");
	By sm_continuebtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
	By creditradiobtn = By.id("paymentmethod_2");
	By pm_continuebtn = By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
	By credittype = By.id("CreditCardType");
	By cardholdername = By.id("CardholderName");
	By cardno = By.id("CardNumber");
	By month = By.id("ExpireMonth");
	By year = By.id("ExpireYear");
	By cardcode = By.id("CardCode");
	By pi_continuebtn = By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");
	By confirmbtn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
	
	//verification for successful order
	By textelement = By.xpath("//*[@class='section order-completed']/div[@class='title']");
	
	public demoShopping(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void doLogin(String eid, String password)
	{
		driver.findElement(loginlink).click();
		driver.findElement(email).sendKeys(eid);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginbtn).click();
	}
	
	public void orderProduct()
	{
		driver.findElement(a_s).click();
		driver.findElement(golfbelt).click();
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("10");
		driver.findElement(addtocart).click();
		
	}
	
	public void doCheckout()
	{
		driver.findElement(shoppingcartlink).click();
		boolean t = driver.findElement(By.id("checkout")).isDisplayed();
		if(t)
		{
			System.out.println("Checkout button exists on the page.");
			driver.findElement(tos_chkbox).click();
			driver.findElement(checkoutbtn).click();
		}
		else
		{
			System.out.println("Checkout button doesn't exist on the page");
		}
	}
	
	public void checkoutProcess()
	{
		driver.findElement(ba_continuebtn).click();
		driver.findElement(sa_continuebtn).click();
		driver.findElement(groundradiobtn).click();
		driver.findElement(sm_continuebtn).click();
		driver.findElement(creditradiobtn).click();
		driver.findElement(pm_continuebtn).click();
		Select credit = new Select(driver.findElement(credittype));
		credit.selectByValue("Visa");
		driver.findElement(cardholdername).sendKeys("Barbara Gordon");
		driver.findElement(cardno).sendKeys("4485564059489345");
		Select emonth = new Select(driver.findElement(month));
		emonth.selectByValue("4");
		Select eyear = new Select(driver.findElement(year));
		eyear.selectByValue("2022");
		driver.findElement(cardcode).sendKeys("123");
		driver.findElement(pi_continuebtn).click();
		driver.findElement(confirmbtn).click();
	}
	
	public void doLogout()
	{
		driver.findElement(logoutbtn).click();
	}

}
