package launchingBrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class LaunchingBrowser {
	
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.xpath("//div[@id='login_dialog']/descendant::a[contains(text(),'Close')]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='topnav_wrapper']//span[contains(text(),'Sale')]"))).perform();
		TakesScreenshot sc =(TakesScreenshot)driver;
		File source= sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/urbanladder.png"));
		
		// comment added from desktop to verify the sync in laptop
		driver.close();

	}

}
