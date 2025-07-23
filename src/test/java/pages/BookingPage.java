package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mysql.cj.xdevapi.Statement;

public class BookingPage {
	WebDriver driver;
	JavascriptExecutor js;
	List<String>allWindows;
	
	String  customerName;
	String customerLastName;
	String email;
	String contactNumber;
	By bookingCalenderLocator=By.linkText("Booking Calendar");
	By bookingDayLocator=By.linkText("26");
	By firstNameLocator=By.id("name1");
	By sendButtonLocator=By.cssSelector("button[type='button']");
	public BookingPage(WebDriver theDriver) {
	    this.driver = theDriver;
	    this.js = (JavascriptExecutor) theDriver;
	    
	}
public  void fillBookingForm() throws InterruptedException,SQLException {
	driver.findElement(bookingCalenderLocator).click();
	Set<String>allTabs=driver.getWindowHandles();
	allWindows=new ArrayList<>(allTabs);
	js.executeScript("window.scrollTo(0,2000)");
	Thread.sleep(2000);
	driver.switchTo().window(allWindows.get(1));
	Thread.sleep(2000);
	driver.findElement(bookingDayLocator).click();
	
}



}
