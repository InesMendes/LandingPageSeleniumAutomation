import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Login {
	public void loggingIn(WebDriver driver){
		driver.manage().window().maximize();
		driver.get("http://www.play.tv2.dk");
		WebDriverWait wait= new WebDriverWait(driver, 15);
		
		//Test case 1: Login pop-up shows when selecting "Log Ind"
		driver.findElement(By.cssSelector(".navgroup.right > ul > li:last-child > a")).click();
		driver.findElement(By.cssSelector("#loginframe")).isDisplayed();
		
		
		//Test case 2: Try Incorrect Login: not possible to login and error message shows
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#loginframe")));
		driver.findElement(By.cssSelector("#username")).sendKeys("hp_1");
		driver.findElement(By.cssSelector(".step.login #password")).sendKeys("test");
		driver.findElement(By.cssSelector(".step.login #login-form button[type=submit]")).click();
		driver.findElement(By.cssSelector(".step.login .alert.alert-danger")).isDisplayed();
		driver.getPageSource().contains("Ukendt brugernavn eller adgangskode. Prøv igen.");
		
		//Test case 3: Try correct Login: User is logged in and is taken to Forside
		//Go to iframe
		driver.findElement(By.cssSelector("#username")).clear();
		driver.findElement(By.cssSelector("#username")).sendKeys("hp_1");
		driver.findElement(By.cssSelector(".step.login #password")).clear();
		driver.findElement(By.cssSelector(".step.login #password")).sendKeys("argen10na");
		driver.findElement(By.cssSelector(".step.login #login-form button[type=submit]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#profile-link")));
		driver.findElement(By.cssSelector("#username-anchor")).equals("hp_1");

		System.out.println("Test cases passed");
		driver.close();
	}
}
