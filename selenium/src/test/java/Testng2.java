import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testng2 {
  
  private WebDriver driver;

  @Parameters({ "browser" })
  @BeforeTest
  public void openBrowser(String browser) {
  		System.out.println("Aqui va el browser");
  		System.out.println(browser);
  		System.out.println("Termino el browser");
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/lib/chromedriver");
				driver = new ChromeDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

  @Test(description = "Open create account page")
  public void title() throws InterruptedException{
    driver.get("http://huli-phr#login");
    driver.get("http://huli-phr#login");
    System.out.println("Viene el body");
    System.out.println(driver.findElement( By.tagName("body")).getText());
    Thread.sleep(4000);
    WebElement boton = driver.findElement(By.id("register-action"));
    boton.click();
    Thread.sleep(4000);
    WebElement boton2 = driver.findElement(By.id("back-action"));
    System.out.println(boton2.getText());
    Assert.assertEquals("Ya tengo una cuenta", boton2.getText(),"The account creation page wasn't opened correctly");
    /*driver.get("http://www.google.com");
    String titles = driver.getTitle();
    Assert.assertEquals(titles, "Google"); 
    System.out.println("Numero 1");*/
  }
 
}