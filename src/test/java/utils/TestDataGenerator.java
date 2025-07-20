package utils;

import java.util.Random;

public class TestDataGenerator {
public static String getCountryRandomly() {
	Random rand=new Random();
	String countries[]= {"Jor","ir","Uni"};
	int countriesIndex=rand.nextInt(countries.length);
	return countries[countriesIndex];
}
}
