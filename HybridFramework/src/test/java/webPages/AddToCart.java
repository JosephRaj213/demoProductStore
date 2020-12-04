package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static testCases.BuyProduct.OR;

public class AddToCart {
	private static WebElement elem = null;
	
	public AddToCart() {
		super();
	}
	
	public static WebElement addProdToCart(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(1000);
			elem = driver.findElement(By.xpath(OR.getProperty("addProd")));
			Thread.sleep(1000);
			
		}
		catch(NoSuchElementException e) {
			elem = null;
			e.printStackTrace();
		}
		return elem;
	}
}
