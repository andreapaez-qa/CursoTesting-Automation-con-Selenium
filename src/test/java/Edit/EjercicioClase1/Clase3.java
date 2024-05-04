package Edit.EjercicioClase1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class Clase3 {
	
	String driverPath = "../EjercicioClase1/drivers/chromedriver";
	String URL = "https://www.saucedemo.com/";
	
	@Test
 public void CreateOrder(){
	 System.setProperty("webriver.chrome.driver", driverPath);
	 
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--incognito");
	 
	 WebDriver driver = new ChromeDriver(options);
	 driver.get(URL);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 //Iniciar Sesion
	 driver.findElement(By.id("user-name")).sendKeys("standard_user");
	 driver.findElement(By.id("password")).sendKeys("secret_sauce");
	 driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 
	 //Agregar producto al carrito
	 driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
	 driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
	 
	 
	 //Hacer click en Checkout
	 driver.findElement(By.cssSelector("#checkout")).click();
	 
	 // Informacion Personal
	 driver.findElement(By.id("first-name")).sendKeys("Rafael");
	 driver.findElement(By.xpath("//input[@id='last-name']"));
	 driver.findElement(By.cssSelector("#postal-code"));
	 driver.findElement(By.cssSelector("#continue")).click();
	 
	 //Cerrar
	 driver.close();
	 
 }
}
