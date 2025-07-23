package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MainPage {
	WebDriver driver;
	JavascriptExecutor js;
    Actions action;
	Random rand=new Random();
	List<String>allTabsArray;
	
	   public MainPage(WebDriver theDriver) {
	        this.driver = theDriver;
	        this.js = (JavascriptExecutor) theDriver;
	        this.action = new Actions(theDriver);
	    }
By radioLocator=By.cssSelector("div[id='radio-btn-example'] fieldset");
By checkBoxContainerLocator=By.cssSelector("div[id='checkbox-example'] fieldset");
By openWindowLocator=By.id("openwindow");
By contactUsLocator=By.cssSelector("li[id='menu-item-9680'] a");
By alertField =By.id("name");
By alertButton =By.id("alertbtn");
By table=By.id("product");
By hideButton=By.id("hide-textbox");
By textField=By.id("displayed-text");
By showButton=By.id("show-textbox");
By enableButton=By.id("enabled-button");
By mouseHoverButton=By.id("mousehover");
By topButton=By.linkText("Top");
By refreshButton=By.linkText("Reload");
public  void fillForm(String country) throws InterruptedException {
	List<WebElement>allRadio=driver.findElement(radioLocator).findElements(By.tagName("input"));
	allRadio.get(rand.nextInt(allRadio.size())).click();
	List<WebElement>allCheckBox=driver.findElement(checkBoxContainerLocator).findElements(By.tagName("input"));
	allCheckBox.get(rand.nextInt(allCheckBox.size())).click();
//	driver.findElement(By.id("openwindow")).click();
//	Set<String>allTabs=driver.getWindowHandles();
//    allTabsArray=new ArrayList<>(allTabs);
//    driver.switchTo().window(allTabsArray.get(1));
//    Thread.sleep(2000);
//    driver.findElement(contactUsLocator);
    driver.findElement(alertField).sendKeys("Ahmad");
    driver.findElement(alertButton).click();
    driver.switchTo().alert().accept();
    driver.findElement(alertField).sendKeys("Ahmad");
    driver.findElement(alertButton).click();
    driver.switchTo().alert().accept();
    List<WebElement>allData=driver.findElement(table).findElements(By.tagName("td"));
    System.out.println(allData.get(0).getText());
    driver.findElement(hideButton).click();
    Thread.sleep(1000);
    Assert.assertEquals(verifyTheTextField(), false,"The textfield isn't displayed");
    Thread.sleep(1000);
    driver.findElement(showButton).click();
    Assert.assertEquals(verifyTheTextField(), true,"The textfield is displayed");
    Thread.sleep(1000);
    driver.findElement(enableButton).click();
    Thread.sleep(2000);
    Actions action=new Actions(driver);
   
    js.executeScript("window.scrollTo(0,1900)");
    Thread.sleep(1000);
    action.moveToElement(driver.findElement(mouseHoverButton)).build().perform();
    driver.findElement(topButton).click();
    js.executeScript("window.scrollTo(0,1900)");
    action.moveToElement(driver.findElement(mouseHoverButton)).build().perform();
    driver.findElement(refreshButton).click();
    Thread.sleep(1000);
    js.executeScript("window.scrollTo(0,1900)");
    }
public  boolean verifyTheTextField() {
	return driver.findElement(textField).isDisplayed();
}
}
