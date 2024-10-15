package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import Tests.TestComponents.Retry;
import pageObjects.CartPage;
import pageObjects.HomePage;
public class AddRecomendedTest extends BaseTest{
	WebDriver driver;
	
	
	@Test(retryAnalyzer = Retry.class, groups = {"NoPreviousAccountCreationRequired"})
	public void AddRecomended() throws IOException, InterruptedException {
		String recommendedTxt = "recommended items";
		String itemName;
		
		HomePage home = landingPage.getHome();
		home.ScrollDown();
		assertTrue(home.verifyRecommendedTxt().equalsIgnoreCase(recommendedTxt));
		home.addRecomendedItem(); 
		itemName = home.getRecommendedItemName();
		CartPage cart = home.goToCart();
		assertTrue(cart.verifyRecommendedItem().equalsIgnoreCase(itemName));	
	}
}