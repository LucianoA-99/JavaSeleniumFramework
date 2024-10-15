package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
public class LogOutTest extends BaseTest{	
	@Test (groups = {"PreviousAccountRequired"})
	public void LogOut () throws IOException { 
		String email = "testtest123@adinet.com";
    	String password = "qatest123456789";
    	String accountIsLogged = "Logged in as Luciano";
    	String loginText = "Login to your account";
		String loginOut = "https://automationexercise.com/logout";
		
		LoginPage login = landingPage.GoToLoginPage();
		assertTrue(login.verifyLoginToYourAcc().equalsIgnoreCase(loginText));
		HomePage home = login.LogIn(email, password);
    	assertTrue(home.Confirmation().equalsIgnoreCase(accountIsLogged));
    	home.LogOut();
    	assertTrue(driver.getCurrentUrl().equalsIgnoreCase(loginOut));
	}
}