package Tests;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductsPage;
public class AddProductTest extends BaseTest{
	WebDriver driver;
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void AddProducts() throws IOException, InterruptedException {
		String products12 [];

		ProductsPage products = landingPage.goToProducts();
		products.addProducts();
		products.setProducts1and2();
		products12 = products.getProducts1and2();
		CartPage cart = products.goToCart();
		Assert.assertTrue(cart.verifyProductsDetails(products12));
		
	}
}