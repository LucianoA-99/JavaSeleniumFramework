package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.HomePage;

public class ViewCategoryTest extends BaseTest{
	WebDriver driver;
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void ViewCategory() throws IOException{
	String confirmation = "WOMEN -  DRESS PRODUCTS";
	String confirmationMen = "Men -  Tshirts Products";
	
	HomePage home = landingPage.getHome();
	home.chooseWCategory();
	assertTrue(home.confirmCategory().equalsIgnoreCase(confirmation));
	home.chooseMCategory();
	assertTrue(home.confirmCategory().equalsIgnoreCase(confirmationMen));
	
	}
}