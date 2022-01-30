package nineTestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class popUp {
	
	private static Logger log = Logger.getLogger(popUp.class);
	
	public WebDriver driver;
	public File scrFile;
	public WebElement popup;
	
	//Open Browser
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.afr.com/policy/foreign-affairs/capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9");
		driver.manage().window().maximize();
	}
	
	//Close Browser
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	//Checking if the pop-up is available
	@Test
	public void popup_appear() throws IOException, InterruptedException {
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		popup = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/article[1]/div[4]/div[2]/div[1]/button[1]"));
		if(!(popup.isDisplayed())) {
			log.info("No Popup displayed");			
			FileUtils.copyFile(scrFile, new File("screenshots\\NoPopup.jpg"));
		}
		else
		{
			log.info("Popup displayed");
			FileUtils.copyFile(scrFile, new File("screenshots\\popup.jpg"));
		}
		Thread.sleep(3000);	
		
		//Scrolling to the bottom of the page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(5000);
		
		Assert.assertEquals("© Copyright 2022 The Australian Financial Review",driver.findElement(By.xpath("//body/div[@id='root']/div[1]/footer[1]/div[3]/div[1]/ul[1]/li[1]")).getText());
		
		//Checking pop-up is NOT available
			
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		if(!(popup.isDisplayed())) {
			log.info("No Popup displayed");	
			FileUtils.copyFile(scrFile, new File("screenshots\\NoPopup.jpg"));
		}
		else
		{
			log.info("Popup displayed");	
			FileUtils.copyFile(scrFile, new File("screenshots\\popup.jpg"));
		}
		
	}
	
	

}
