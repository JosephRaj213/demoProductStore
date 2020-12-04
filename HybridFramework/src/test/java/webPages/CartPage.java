package webPages;

import static testCases.BuyProduct.OR;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	private static WebElement elem = null;

	public CartPage() {
		super();
	}

	public static WebElement PlaceOrder(WebDriver driver) throws InterruptedException {
		try {
			driver.findElement(By.xpath(OR.getProperty("clickCart"))).click();
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty("placeOrder")));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}

	public static WebElement userDetails(WebDriver driver, String userInfo) throws InterruptedException{
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty(userInfo)));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}

	public static WebElement Purchase(WebDriver driver) throws InterruptedException{
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty("purchase")));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}

	public static WebElement Close(WebDriver driver, String close) throws InterruptedException{
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty(close)));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}

	public static WebElement ConfirmOkButton(WebDriver driver) throws InterruptedException{
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty("OkPurchase")));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}
}
