import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriverException;
public class Testng {
  
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

  @Test 
  public void title() {
    driver.get("http://www.google.com");
   	String titles = driver.getTitle();
    Assert.assertEquals(titles, "Google"); 
    System.out.println("Numero 1");
  }
 
}