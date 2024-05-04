package Edit.EjercicioClase1;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Clase5 {
	
	String driverPath = "../EjercicioClase1/drivers/chromedriver";
	String URL = "https://www.saucedemo.com/";
	WebDriver driver;
	File screen;

	@BeforeSuite
	public void setUp(){ //setUp es el nombre que se le pone al metodo tipicamente
		 System.setProperty("webriver.chrome.driver", driverPath);
		 
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");
		 
		 driver = new ChromeDriver(options);
		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
	}
	
	@Test(description = "CP01 - Login Caso Positivo", priority=1) // Estos son anotaciones
	public void login() throws IOException{
		 //Iniciar Sesion
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.xpath("//input[@id='login-button']")).click();
		 
		 //Captura de Pantalla
		 screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screen, new File("../EjercicioClase1/Evidencias/01.beforeLogin.jpg"));
		 
		 //Validar el avance de los productos
		String urlActual = driver.getCurrentUrl();
		String urlEsperada = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(urlActual, urlEsperada);
	}
	@Test(description = "CP02 - Agregar Productos al Carrito", priority=2)
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


	@AfterSuite
	public void tearDown() { //tearDown es el nombre que se le pone al metodo tipicamente
		driver.close();
	}
}



