package Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.BrandPage;
import pageObjects.ProductsPage;

public class ViewBrandTest extends BaseTest{
	WebDriver driver;
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void AddProducts() throws IOException, InterruptedException {
		String confirmation = "Brands";
		//used polo and h&m
		String urlBrand = "https://automationexercise.com/brand_products/Polo";
		String urlBrand2 = "https://automationexercise.com/brand_products/H&M";
		
		ProductsPage products = landingPage.goToProducts();
		assertTrue(products.verifyBrandTxt().equalsIgnoreCase(confirmation));
		BrandPage brand = products.brand();
		assertTrue(brand.verifyUrlAndEle(urlBrand));
		brand.selectBrand();
		assertTrue(brand.verifyUrlAndEle(urlBrand2));
	}
}
