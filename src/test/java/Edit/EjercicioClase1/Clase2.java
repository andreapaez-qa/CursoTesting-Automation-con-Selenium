package Edit.EjercicioClase1; // A que paquete pertenece la clase

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


// import: llamado a librerias de Java

//Clase Principal
public class Clase2 {
	// Metodo Login en Chrome - Web OrangeHRM
	@Test
	public void loginChrome (){
		// 1. Indicar donde esta el driver de Chrome
		System.setProperty("webdriver.chrome.driver","../EjercicioClase1/drivers/chromedriver");
		
		// 2. Abrir la paginas que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Codigo ejemplo Implicito (2, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// 3. Ingresar las credenciales (username y password)
		WebElement txtUsername =  driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");
		txtPassword.sendKeys(Keys.ENTER);
		
		// 4. Hacer click en el boton LOGIN
		//WebElement btnLogin = driver.findElement(By.className("oxd-button"));
		//btnLogin.click();
		driver.close();
	}

	//Metodo Login en Firefox - Web OrangeHRM
	@Test
	public void loginFirefox(){
		// 1. Indicar donde esta el driver de Chrome
		System.setProperty("webdriver.firefox.driver","../EjercicioClase1/drivers/geckodriver");
		
		// 2. Abrir la paginas que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		// 3. Ingresar las credenciales (username y password)
		WebElement txtUsername =  driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");
		
		// 4. Hacer click en el boton LOGIN
		WebElement btnLogin = driver.findElement(By.tagName("button"));
		btnLogin.click();
		driver.close();
	}
}

// Diferentest Selectores
//WebElement element = driver.findElements(By.selector("valor"));
//WebElement element = driver.findElements(By.id("myID"));
//WebElement element = driver.findElements(By.name("myName"));
//WebElement element = driver.findElements(By.className("bold"));
//WebElement element = driver.findElements(By.tagName("input"));
//WebElement element = driver.findElements(By.linkText("https://www.youtube.com"));
//WebElement element = driver.findElements(By.partialLinkText("https://www.youtube.com"));
//XPATH RELATIVO -> //input[@id="myID"] o //*[@id="myID"]
// By.xpath ("//*[@label='Selenium in Twitter' and @class='text-white']")
// By.cssSelector("a[href='/downloads']")
//cropath o selectorsHub extension ayuda a elegir algun selector
//Ejemplos listas despegables: Select drpPais = New Select (driver.findElement(By.name("country"))); o drpPais.selectByValue("1");
