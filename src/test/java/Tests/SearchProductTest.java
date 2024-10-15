package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import Tests.TestComponents.Retry;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class SearchProductTest extends BaseTest{
	WebDriver driver;
	
	@Test (groups = {"PreviousAccountRequired"}, retryAnalyzer = Retry.class)
	public void SearchProduct() throws IOException, InterruptedException {
		String searchedPText = "SEARCHED PRODUCTS";
		String productsUrl = "https://automationexercise.com/products";
		String productName = "dress";
		String email = "testtest123@adinet.com";
    	String password = "qatest123456789";
    	
		ProductsPage products = landingPage.goToProducts();
		assertTrue(products.getUrl().equalsIgnoreCase(productsUrl));
		products.searchProduct(productName);
		assertTrue(products.verifySearchedProdText().equalsIgnoreCase(searchedPText));
		assertTrue(products.verifySearchedP(productName));
		List<String> prodNames = products.addAllProducts();
		CartPage cart = products.goToCart();
		assertTrue(cart.verifyAllNames(prodNames));
		LoginPage login = cart.login();
		HomePage home = login.LogIn(email, password);
		home.goToCart();
		assertTrue(cart.verifyAllNames(prodNames));
	}
}
