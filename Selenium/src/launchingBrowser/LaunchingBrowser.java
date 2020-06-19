package launchingBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchingBrowser {
	
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.xpath("//div[@id='login_dialog']/descendant::a[contains(text(),'Close')]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='topnav_wrapper']//span[contains(text(),'Sale')]"))).perform();
		Thread.sleep(3000);
		driver.close();

	}

}
