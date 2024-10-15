package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.HomePage;

public class VerifySubscriptionTest extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void VerifySubscription() throws IOException, InterruptedException {
		String subscriptionText = "SUBSCRIPTION";
		String subSuccessTxt = "You have been successfully subscribed!";
		String email = "test123@adinet.com";
		
		HomePage home = landingPage.getHome();
		home.ScrollDown();
		assertTrue(home.verifySubscriptionText().equalsIgnoreCase(subscriptionText));
		home.SubscribeEmail(email);
		assertTrue(home.verifySubscriptionSuccess().equalsIgnoreCase(subSuccessTxt));

	}
}
