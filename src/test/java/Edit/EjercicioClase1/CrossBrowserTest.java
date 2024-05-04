package Edit.EjercicioClase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	String chromeDriverPath = "../EjercicioClase1/drivers/chromedriver";
	String firefoxDriverPath = "../EjercicioClase1/drivers/geckodriver";
	String URL = "https://www.saucedemo.com/";
	WebDriver driver;
	

	@BeforeTest
	@Parameters("navegador")
	public void setUp(String navegador){ //setUp es el nombre que se le pone al metodo tipicamente
		if (navegador.equalsIgnoreCase("chrome")) {	
		System.setProperty("webriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		} else if(navegador.equalsIgnoreCase("firefox")){	
				System.setProperty("webriver.gecko.driver", firefoxDriverPath);
				driver = new ChromeDriver();
		}

		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
	}
	
	@Test(description = "CP01 - Login Caso Positivo", priority=1) // Estos son anotaciones
	public void login(){
		 //Iniciar Sesion
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.xpath("//input[@id='login-button']")).click();
		 
		 //Validar el avance de los productos
		String urlActual = driver.getCurrentUrl();
		String urlEsperada = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(urlActual, urlEsperada);
	}
	@Test(description = "CP01 - Login Caso Positivo", priority=2)
 public void CreateOrder(){
	 //Agregar producto al carrito
	 driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
	 driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
	 
	 
	 //Hacer click en Checkout
	 driver.findElement(By.cssSelector("#checkout")).click();
	 
	 // Informacion Personal
	 driver.findElement(By.id("first-name")).sendKeys("Rafael");
	 driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Andres");
	 driver.findElement(By.cssSelector("#postal-code")).sendKeys("1414");
	 driver.findElement(By.cssSelector("#continue")).click();
	 
 }


	@AfterTest
	public void tearDown() { //tearDown es el nombre que se le pone al metodo tipicamente
		driver.close();
	}
}
