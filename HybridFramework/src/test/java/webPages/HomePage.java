package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

import static testCases.BuyProduct.OR;

public class HomePage {
	private static WebElement elem = null;
	
	public HomePage(WebDriver driver) {
		super();
	}
	public static WebElement LoginPage(WebDriver driver) {
		try {
			elem = driver.findElement(By.xpath(OR.getProperty("login")));
			Log.info("Login button found on Home Page");
		}
		catch(NoSuchElementException e) {
			elem = null;
			Log.error("Login button not found on Home Page");
			e.printStackTrace();
		}
		return elem;
	}
	
	public static WebElement Logoutpage(WebDriver driver) {
		try {
			elem = driver.findElement(By.xpath(OR.getProperty("logout")));
			Log.info("Logout button found");
		}
		catch(NoSuchElementException e) {
			elem=null;
			Log.error("Logout button not found");
			e.printStackTrace();
		}
		return elem;
	}
	
	public static WebElement Categories(WebDriver driver, String Category) {
		try {
			elem = driver.findElement(By.xpath(OR.getProperty(Category)));
			Log.info("Phones button found on home page");
		}
		catch(NoSuchElementException e ) {
			elem = null;
			Log.error("Phones button not found");
			e.printStackTrace();
		}
		return elem;
	}
}
