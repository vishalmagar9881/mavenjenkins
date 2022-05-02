package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
from selenium.webdriver.chrome.options import Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest 
{

	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName)
	{
		System.out.println("Parameter value is "+browserName);
		WebDriver driver=null;
		
		if(browserName.contains("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			chrome_options = Options();
			chrome_options.add_argument("--disable-extensions");
			chrome_options.add_argument("--disable-gpu");
			chrome_options.add_argument("--no-sandbox");
			options.add_argument("--disable-dev-shm-usage");
			driver=new ChromeDriver(options=chrome_options);
		}
		else if(browserName.contains("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match");
		driver.quit();
	}
	
	
}
