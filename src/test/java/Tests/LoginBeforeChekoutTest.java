package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.DeleteAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;
public class LoginBeforeChekoutTest extends BaseTest{
	@Test(groups = {"PreviousAccountRequired"})
	public void LoginBeforeCheckout () throws IOException { 
		//make sure account is already created with the following info
		String email = "testtest123@adinet.com";
    	String password = "qatest123456789";
    	String accountIsLogged = "Logged in as Luciano";
    	String accountIsDeleted = "Account Deleted!";
    	String confirmationPymnt = "Congratulations! Your order has been confirmed!";
    	String firstname = "Luciano";
    	String lastname = "Alonso";
    	String company = "Testing";
    	String address = "BuddyStreet";
    	String address2 = "123";
    	String country = "United States";
    	String state ="Texas";
    	String city = "Houston";
    	String zipcode = "12345";
    	String mobile = "486215379";
    	
		LoginPage login = landingPage.GoToLoginPage();
		HomePage home = login.LogIn(email, password);
    	assertTrue(home.Confirmation().equalsIgnoreCase(accountIsLogged));
    	ProductsPage products = home.goToProducts();
		products.addProducts();
		CartPage cart = products.goToCart();
		CheckoutPage checkout = cart.proceedCheckout();
		checkout.verifyDetails(firstname, lastname, company, address, address2, country, state, city, zipcode, mobile);
		PaymentPage payment = checkout.commentAndPlaceOrder();
		payment.fillCardInfo();
		assertTrue(payment.verifyPayment().equalsIgnoreCase(confirmationPymnt));
		DeleteAccountPage deleteAccount = payment.deleteAccount();
		assertTrue(deleteAccount.getConfirmation().equalsIgnoreCase(accountIsDeleted));
		deleteAccount.continueTo();
	}
}