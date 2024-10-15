package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.LoginPage;
public class RegisterAlreadyExistTest extends BaseTest{
    @Test (groups = {"PreviousAccountRequired"})
    public void registerAlreadyExist () throws IOException{
    	String name = "Luciano"; 
    	String email = "testtest123@adinet.com";
    	String newUserSignupText = "New User Signup!";
    	String userExistText = "Email Address already exist!";
    	
		LoginPage login = landingPage.GoToLoginPage();
		assertTrue(login.verifyNewUserSignup().equalsIgnoreCase(newUserSignupText));
		login.RegisterUser(name, email);
		login.goToEnterUserInfo();
		assertTrue(login.verifyAccountExist().equalsIgnoreCase(userExistText));	
    }
}