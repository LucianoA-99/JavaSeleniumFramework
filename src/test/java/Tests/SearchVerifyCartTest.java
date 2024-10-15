package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.ProductsPage;

public class SearchVerifyCartTest extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void SearchVerifyCart() throws IOException, InterruptedException {
		String searchedPText = "SEARCHED PRODUCTS";
		String productsUrl = "https://automationexercise.com/products";
		String productName = "dress";

		ProductsPage products = landingPage.goToProducts();
		assertTrue(products.getUrl().equalsIgnoreCase(productsUrl));
		products.searchProduct(productName);
		assertTrue(products.verifySearchedProdText().equalsIgnoreCase(searchedPText));
		assertTrue(products.verifySearchedP(productName));
		
	}
}
