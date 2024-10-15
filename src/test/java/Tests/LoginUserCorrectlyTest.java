package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.DeleteAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
public class LoginUserCorrectlyTest extends BaseTest{
	@Test(groups = {"PreviousAccountRequired"})
	public void LoginUserCorrectly () throws IOException { 
		//make sure account is already created
		String email = "testtest123@adinet.com";
    	String password = "qatest123456789";
    	String accountIsLogged = "Logged in as Luciano";
    	String accountIsDeleted = "Account Deleted!";
    	String loginText = "Login to your account";
		
		LoginPage login = landingPage.GoToLoginPage();
		assertTrue(login.verifyLoginToYourAcc().equalsIgnoreCase(loginText));
		HomePage home = login.LogIn(email, password);
    	assertTrue(home.Confirmation().equalsIgnoreCase(accountIsLogged));
    	DeleteAccountPage deleteAccount = home.deleteAccount();
		assertTrue(deleteAccount.getConfirmation().equalsIgnoreCase(accountIsDeleted));
		deleteAccount.continueTo();
	}
}