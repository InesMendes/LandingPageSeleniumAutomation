import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver", "C://Users/inme/Desktop/Selenium Course/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Login loginCase= new Login();
		loginCase.loggingIn(driver);*/
		//driver.close();
		System.setProperty("webdriver.gecko.driver", "C://Users/inme/Desktop/Selenium Course/geckodriver.exe");
		WebDriver driverb= new FirefoxDriver();
		Login loginCase2= new Login();
		loginCase2.loggingIn(driverb);
	}
}
