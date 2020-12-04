package webPages;

import static testCases.BuyProduct.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ProdPage {
	private static WebElement elem = null;
	
	public ProdPage(WebDriver driver) {
		super();
	}
	
	public static WebElement selectProd(WebDriver driver, String Prod) throws InterruptedException {
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath("//a[text()='"+Prod+"']"));
			Thread.sleep(1000);
		}
		catch(NoSuchElementException e) {
			elem = null;
			Log.info(Prod+ " is not present");
			e.printStackTrace();
		}
		return elem;
	}

}
