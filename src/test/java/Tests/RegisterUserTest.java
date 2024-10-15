package Tests;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Tests.TestComponents.BaseTest;
import pageObjects.ConfirmationUserPage;
import pageObjects.DeleteAccountPage;
import pageObjects.EnterUserInfoPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class RegisterUserTest extends BaseTest{
    @Test(dataProvider="getData", groups= {"NoPreviousAccountCreationRequired"})
    public void registerUserTest (HashMap<String,String> input) throws IOException{
    	String name = input.get("name"); 
    	String email = input.get("email");
    	String password = input.get("password"); 
    	String day = input.get("day"); 
    	String month = input.get("month");
    	String year = input.get("year");
    	String firstN = input.get("firstname");
    	String lastN = input.get("lastname");
    	String companyN = input.get("company");
    	String address = input.get("address");
    	String address2 = input.get("address2");
    	String countryN = input.get("country");
    	String stateN = input.get("state");
    	String cityN = input.get("city");
    	String zipcodeN = input.get("zipcode");
    	String mobileN  = input.get("mobile");
    	String confirmationString = "ACCOUNT CREATED!";
    	String accountIsLogged = "Logged in as " + name;
    	String accountIsDeleted = "Account Deleted!";
    	String newUserSignupText = "New User Signup!";
    	String enterAccInfoText = "ENTER ACCOUNT INFORMATION";
    	
    	
		LoginPage login = landingPage.GoToLoginPage();
		assertTrue(login.verifyNewUserSignup().equalsIgnoreCase(newUserSignupText));
		login.RegisterUser(name, email);
		EnterUserInfoPage enterUserInfo = login.goToEnterUserInfo();
		assertTrue(enterUserInfo.enterAccountInfoTxt().equalsIgnoreCase(enterAccInfoText));
		enterUserInfo.fillDetails(name, password, day, month, year, firstN, lastN, companyN, address, address2, countryN, stateN, cityN, zipcodeN, mobileN);
		ConfirmationUserPage confirm = enterUserInfo.createAccount();
		assertTrue(confirm.getConfirmation().equalsIgnoreCase(confirmationString));
		HomePage home = confirm.continueTo();
		assertTrue(home.Confirmation().equalsIgnoreCase(accountIsLogged));
		DeleteAccountPage deleteAccount = home.deleteAccount();
		assertTrue(deleteAccount.getConfirmation().equalsIgnoreCase(accountIsDeleted));
		deleteAccount.continueTo();
		
    }
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserAndProductsInfo.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}