package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.ProductDetailPage;
import pageObjects.ProductsPage;
public class AddReviewTest extends BaseTest{
	WebDriver driver;
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void AddReview() throws IOException, InterruptedException {
		String productsUrl = "https://automationexercise.com/products";
		String reviewTxt = "Thank you for your review.";
		
		ProductsPage products = landingPage.goToProducts();
		assertTrue(products.getUrl().equalsIgnoreCase(productsUrl));
		ProductDetailPage details = products.firstProduct();
		details.verifyReviewTxt();
		details.addReview();
		assertTrue(details.reviewSuccessTxt().equalsIgnoreCase(reviewTxt));
		
	}
}