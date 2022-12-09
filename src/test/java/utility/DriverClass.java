package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
	static WebDriver driver;
	
	public static WebDriver openBrowser(String browName,String url)
	{
		if(browName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikita.h.kumari\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		return driver;
	}


}
