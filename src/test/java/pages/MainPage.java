package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	Random rand=new Random();
	List<String>allTabsArray;
public MainPage(WebDriver theDriver) {
	this.driver=theDriver;
}
By radioLocator=By.cssSelector("div[id='radio-btn-example'] fieldset");
By checkBoxContainerLocator=By.cssSelector("div[id='checkbox-example'] fieldset");
By openWindowLocator=By.id("openwindow");
By contactUsLocator=By.cssSelector("li[id='menu-item-9680'] a");
public  void fillForm(String country) throws InterruptedException {
	List<WebElement>allRadio=driver.findElement(radioLocator).findElements(By.tagName("input"));
	allRadio.get(rand.nextInt(allRadio.size())).click();
	List<WebElement>allCheckBox=driver.findElement(checkBoxContainerLocator).findElements(By.tagName("input"));
	allCheckBox.get(rand.nextInt(allCheckBox.size())).click();
	driver.findElement(By.id("openwindow")).click();
	Set<String>allTabs=driver.getWindowHandles();
    allTabsArray=new ArrayList<>(allTabs);
    driver.switchTo().window(allTabsArray.get(1));
    Thread.sleep(2000);
    driver.findElement(contactUsLocator);
    
}
}
