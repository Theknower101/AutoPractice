package mytests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MainPage;
import utils.DriverFactory;
import utils.TestDataGenerator;

public class MyTestCases {
	WebDriver driver;
String url="https://codenboxautomationlab.com/practice/";

	Random rand=new Random();
	MainPage main;
	@BeforeTest
	public void setUp() {
		driver = DriverFactory.getDriver(); 
		driver.get(url);
		main = new MainPage(driver);
	}
	@Test(priority=1)
	public void radioButton() throws InterruptedException {
	String countries=TestDataGenerator.getCountryRandomly();
	main.fillForm(countries);
	}
	
	
	
//	@Test(priority=4,enabled=false)
//	public void openWindow() throws InterruptedException {
//		 String originalWindow = driver.getWindowHandle();
//		driver.findElement(By.id("openwindow")).click();
//	 Set<String>widows=driver.getWindowHandles();	
//	 List<String>allWindows=new ArrayList<>(widows);
//	 driver.switchTo().window(allWindows.get(1));
//	 Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@id='menu-item-9680']//a")).click();
//	Thread.sleep(2000);
//	 driver.switchTo().window(originalWindow);
//	}
//	@Test(priority=5,enabled=false)
//	public void openWindowLink() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Open Tab")).click();
//		Set<String>allTabs=driver.getWindowHandles();
//		List<String>allWindows=new ArrayList<>(allTabs);
//		driver.switchTo().window(allWindows.get(1));
//	}
//	@Test(priority=6)
//	public void alert() {
//		String names[]= {"Ahmad","Mohammad","Ali"};
//		driver.findElement(By.id("name")).sendKeys(names[rand.nextInt(names.length)]);
//		driver.findElement(By.id("alertbtn")).click();
//		driver.switchTo().alert().accept();
//		driver.findElement(By.id("name")).sendKeys(names[rand.nextInt(names.length)]);
//		driver.findElement(By.id("confirmbtn")).click();
//		driver.switchTo().alert().accept();
//		}
//	@Test(priority=7)
//	public void table() {
//		WebElement theTable=driver.findElement(By.id("product"));
//		List<WebElement>allData=theTable.findElements(By.tagName("td"));
//		System.out.println(allData.get(0).getText());
//	}
//	@Test(priority=8)
//	public void hideAndShow() {
//		driver.findElement(By.id("hide-textbox")).click();
//		boolean isDisplayed=driver.findElement(By.id("displayed-text")).isDisplayed();
//		Assert.assertEquals(isDisplayed, false);
//		driver.findElement(By.id("show-textbox")).click();
//		Assert.assertEquals(isDisplayed, false);
//		driver.findElement(By.id("displayed-text")).sendKeys("Hi");
//	}
//	@Test(priority=9)
//	public void enabledAndDisabled() {
//		driver.findElement(By.id("disabled-button")).click();
//		driver.findElement(By.id("enabled-button")).click();
//		driver.findElement(By.id("enabled-example-input")).sendKeys("Hi");;
//	}
//	@Test(priority=10)
//	public void mouseHover() throws InterruptedException {
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Top")).click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0,1900)");
//		Thread.sleep(1000);
//		action.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
//		driver.findElement(By.linkText("Reload")).click();
//	}
	@AfterTest
	public void closingWeSite() {
		DriverFactory.killDriver();
	}
}
