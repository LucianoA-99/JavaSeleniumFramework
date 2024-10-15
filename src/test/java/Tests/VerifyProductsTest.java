package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.ProductDetailPage;
import pageObjects.ProductsPage;

public class VerifyProductsTest extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void VerifyProducts() throws IOException, InterruptedException {
		String productsUrl = "https://automationexercise.com/products";

		ProductsPage products = landingPage.goToProducts();
		assertTrue(products.getUrl().equalsIgnoreCase(productsUrl));
		ProductDetailPage details = products.firstProduct();
		assertTrue(details.verifyProducts());
	}
}
