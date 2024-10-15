package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.LoginPage;
public class IncorrectLoginTest extends BaseTest{
	@Test(groups = {"NoPreviousAccountCreationRequired"})
	public void IncorrectLogin () throws IOException {
		String email = "smashpotatoes@adinet.com";
    	String password = "potatoe123";
    	String loginText = "Login to your account";
    	String wrongAcc = "Your email or password is incorrect!";
    	
    	LoginPage login = landingPage.GoToLoginPage();
    	assertTrue(login.verifyLoginToYourAcc().equalsIgnoreCase(loginText));
		login.LogIn(email, password);
		assertTrue(login.verifyIncorrectPassEmail().equalsIgnoreCase(wrongAcc));	
	}
}