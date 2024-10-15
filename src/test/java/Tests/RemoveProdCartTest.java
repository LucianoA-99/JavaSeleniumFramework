package Tests;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductsPage;

public class RemoveProdCartTest extends BaseTest{
	WebDriver driver;
	
	@Test(groups = {"NoPreviousAccountCreationRequired"})
	public void AddProducts() throws IOException, InterruptedException {

		ProductsPage products = landingPage.goToProducts();
		products.addProducts();
		CartPage cart = products.goToCart();
		Assert.assertFalse(cart.RemoveAndCompare());
	}
	
}
