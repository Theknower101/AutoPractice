package mytests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.MainPage;
import utils.DataBase;
import utils.DriverFactory;
import utils.TestDataGenerator;

public class MyTestCases {
	WebDriver driver;
String url="https://codenboxautomationlab.com/practice/";

	Random rand=new Random();
	MainPage main;
	BookingPage booking;
	DataBase data;
	
	@BeforeTest
	public void setUp() throws SQLException {
		driver = DriverFactory.getDriver(); 
		driver.get(url);
		main = new MainPage(driver);
		booking=new BookingPage(driver);
		data=new DataBase(driver);
		data.getDriverManger();
	}
	@Test(priority=1,enabled=false)
	public void fillData() throws InterruptedException {
	String countries=TestDataGenerator.getCountryRandomly();
	main.fillForm(countries);
	
	}
    @Test(priority=2)
    public void booking() throws InterruptedException,SQLException {
    	booking.fillBookingForm();
    	Thread.sleep(2000);
    	data.addData();
    	Thread.sleep(2000);
    	data.fillData();
    	Thread.sleep(2000);
    	data.updateData();
    	driver.navigate().refresh();
    	Thread.sleep(1000);
    	data.fillData();
    	Thread.sleep(1000);
    
    }
	
	

	@AfterTest
	public void closingWeSite() {
		DriverFactory.killDriver();
	}
}
