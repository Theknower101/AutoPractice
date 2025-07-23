package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DataBase {
	WebDriver driver;
	JavascriptExecutor js;
	Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	By firstNameLocator=By.id("name1");
	By lastNameLocator=By.id("secondname1");
	By emailLocator=By.id("email1");
	By phoneLocator=By.id("phone1");
	By detailsLocator=By.id("details1");
	
	public DataBase(WebDriver theDriver) {
		this.driver=theDriver;
		js=(JavascriptExecutor)theDriver;
	}
public void getDriverManger() throws SQLException {
	 con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/classicmodels", "root", "123456"
	        );
}
public void fillData() throws SQLException, InterruptedException {
  stmt=con.createStatement();
  String readQuery="select * from customers where customerNumber=10";
  rs=stmt.executeQuery(readQuery);
	String firstName=null;
	String lastName=null;
	String email=null;
	String phone=null;
	while(rs.next()) {
		firstName=rs.getNString("customerName");
		lastName=rs.getNString("contactLastName");
		email=firstName+lastName+"@gmail.com";
		phone=rs.getNString("phone");
	}

	Thread.sleep(1000);
	driver.findElement(firstNameLocator).sendKeys(firstName);
	Thread.sleep(1000);
	driver.findElement(lastNameLocator).sendKeys(lastName);
	Thread.sleep(1000);
	driver.findElement(emailLocator).sendKeys(email);
	Thread.sleep(1000);
	driver.findElement(phoneLocator).sendKeys(phone);
	Thread.sleep(1000);
	driver.findElement(detailsLocator).sendKeys("Hi");
}
public void addData() throws SQLException {
  stmt=con.createStatement();
   String addQuery="insert into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,city,country)values(10,'ABC','Ahmad','Mohammad','0791314605','Arajan','Amman','Jordan')";
  stmt.executeUpdate(addQuery);
  
}
public void updateData() throws SQLException {
	stmt=con.createStatement();
	String updateQuery="update customers set customerName='Mohammad' where customerNumber='10'";
	stmt.executeUpdate(updateQuery);
}
}
