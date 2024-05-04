package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.InventoryPage;
import paginas.LoginPage;

public class CreateOrderTest {
WebDriver driver;
String driverPath = "../EjercicioClase1/drivers/chromedriver";
String URL = "https://www.saucedemo.com/";

@BeforeSuite
public void setUp(){ //setUp es el nombre que se le pone al metodo tipicamente
	 System.setProperty("webriver.chrome.driver", driverPath);
	 driver = new ChromeDriver();
	 driver.get(URL);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
}

@Test
public void login() {
	LoginPage login = new LoginPage(driver);
	login.fillCredentials("standard_user", "secret_sauce");
	login.clicOnLogin();
	
	InventoryPage inventory = new InventoryPage(driver);
	inventory.addToCart();
	inventory.clicOnCart();
}

@AfterSuite
public void tearDrown() {
	driver.close();
}

}