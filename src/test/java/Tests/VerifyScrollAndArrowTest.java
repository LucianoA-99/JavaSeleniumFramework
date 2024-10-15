package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.HomePage;

public class VerifyScrollAndArrowTest extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void VerifySubscription() throws IOException, InterruptedException {
		String subscriptionText = "SUBSCRIPTION";
		
		HomePage home = landingPage.getHome();
		home.ScrollDown();
		assertTrue(home.verifySubscriptionText().equalsIgnoreCase(subscriptionText));
		home.ScrollUsingArrow();
		assertTrue(home.verifyAutomationText());

	}
}
