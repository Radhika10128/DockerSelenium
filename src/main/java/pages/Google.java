
package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Google {

	private WebDriver driver;
	
	public Google(WebDriver driver) {
		this.driver = driver;
	}
	
	public void OpenPageInGoogle(String search) {
		driver.findElement(By.name("q")).sendKeys(search);  
        
	    // Click on the search button  
	    driver.findElement(By.name("btnK")).click(); 
	}
}
