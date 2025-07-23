package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;

import com.mysql.cj.xdevapi.Statement;

public class TestDataGenerator {
	
public static String getCountryRandomly() {
	Random rand=new Random();
	String countries[]= {"Jor","ir","Uni"};
	int countriesIndex=rand.nextInt(countries.length);
	return countries[countriesIndex];
}
public static void getData() {}

}
