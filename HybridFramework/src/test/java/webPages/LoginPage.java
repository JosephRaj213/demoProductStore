package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import static testCases.BuyProduct.OR;

public class LoginPage {
	
private static WebElement elem = null;
	
	public LoginPage(WebDriver driver) {
		super();
	}
	
	public static WebElement getUser(WebDriver driver) throws InterruptedException{
		try{
			Thread.sleep(5000);
			System.out.println(OR.getProperty("userName"));
			elem = driver.findElement(By.xpath(OR.getProperty("userName")));
			Log.info("UserName text box is present");
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			Log.info("UserName text box not found");
			e.printStackTrace();
		}
		return elem;
	}

	public static WebElement getPwd(WebDriver driver) throws InterruptedException{
		try{
			Thread.sleep(5000);
			elem = driver.findElement(By.xpath(OR.getProperty("password")));
			Log.info("Password text box is present");
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			Log.info("Password text box not found");
			e.printStackTrace();
		}
		return elem;
	}
	
	public static WebElement getLogin(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(5000);
			elem = driver.findElement(By.xpath(OR.getProperty("login_button")));
			Log.info("Login Button present");
			Thread.sleep(2000);
		}
		catch(NoSuchElementException e){
			elem = null;
			Log.info("Login Button is not enabled or active");
			e.printStackTrace();
		}
		return elem;
	}
	
	public static WebElement getLoginClose(WebDriver driver)throws InterruptedException {
		try {
			Thread.sleep(5000);
			elem = driver.findElement(By.xpath(OR.getProperty("login_close")));
			Log.info("Close Button present");
			Thread.sleep(2000);
		}
		catch(NoSuchElementException e){
			elem = null;
			Log.info("Close button is not enabled or active");
			e.printStackTrace();
		}
		return elem;
	}
	
	public static WebElement getLogOut(WebDriver driver) throws InterruptedException{
		try {
			Thread.sleep(5000);
			elem = driver.findElement(By.xpath(OR.getProperty("logout")));
			Log.info("Logout button present");
		}
		catch(Exception e) {
			Log.info("Logout button not found");
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}
	
}
