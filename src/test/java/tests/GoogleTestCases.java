package tests;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Google;
import tests.Base;

public class GoogleTestCases extends Base {
	
	@Test
	public void searchJavaPoint() {
		Google home = new Google(driver);
		launchUrl();
		home.OpenPageInGoogle("javatpoint tutorials");
	}
	
	@Test
	public void searchGmail() {
		Google home = new Google(driver);
		launchUrl();
		home.OpenPageInGoogle("Gmail");
	}
}
