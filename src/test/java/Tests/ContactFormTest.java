package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.ContactFormPage;
import pageObjects.HomePage;
public class ContactFormTest extends BaseTest{
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void contactForm () throws IOException { 
		String getInTouchText = "Get In Touch";
		String email = "johndoe@example.com";
		String name = "John Doe";
		String subject = "Issue with Recent Order #12345";
		String message = "lorem ipsum";
		String alertText = "Success! Your details have been submitted successfully.";
		String homeUrl = "https://automationexercise.com/";
		
		ContactFormPage contactForm = landingPage.GoToContactForm();
		assertTrue(contactForm.verifyGetInTouch().equalsIgnoreCase(getInTouchText));
		contactForm.fillInfo(name, email, subject, message);
		assertTrue(contactForm.verifyAlert().equalsIgnoreCase(alertText));
    	HomePage home = contactForm.goToHome();
    	assertTrue(home.Url().equalsIgnoreCase(homeUrl));
    	
	}
}