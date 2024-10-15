package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.CartPage;

public class VerifySubscription2Test extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void VerifySubscription() throws IOException, InterruptedException {
		String subscriptionText = "SUBSCRIPTION";
		String subSuccessTxt = "You have been successfully subscribed!";
		String email = "test123@adinet.com";
		
		CartPage cart = landingPage.goToCart();
		assertTrue(cart.verifySubText().equalsIgnoreCase(subscriptionText));
		cart.SubscribeEmail(email);
		assertTrue(cart.verifySubSuccessText().equalsIgnoreCase(subSuccessTxt));

	}
}
