package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebElement btnAddtoCart;
	WebElement linkCart;
	WebDriver driver;
	
	public InventoryPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void addToCart() {
		btnAddtoCart.click();
	}
	
	public void clicOnCart() {
		linkCart.click();
	}
}
