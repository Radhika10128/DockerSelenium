package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {

	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public static WebDriver setupDriver(String browser) throws MalformedURLException {
		String host = "localhost";
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectPath+"/chrome/chromedriver.exe");

		String completeURL = "http://127.0.0.1:4444";
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		if(browser.equalsIgnoreCase("chrome")) {
			capabilities.setPlatform(Platform.LINUX);
			capabilities.setBrowserName(BrowserType.CHROME);
		} else {
			capabilities.setPlatform(Platform.LINUX);
			capabilities.setBrowserName(BrowserType.FIREFOX);
		}
		driver = new RemoteWebDriver(new URL(completeURL), capabilities);
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
	
	public void launchUrl() {
		this.driver.get("http://www.google.com/");
		System.out.print("Opened React App");
	}
}
