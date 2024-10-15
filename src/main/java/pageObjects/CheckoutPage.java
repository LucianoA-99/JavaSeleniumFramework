package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	private WebDriver driver;
	
	private By billingNames = By.xpath("//div[2]/ul/li[2]");
	private By billingCompany = By.xpath("//div[2]/ul/li[3]");
	private By billingAddress1 = By.xpath("//div[2]/ul/li[4]");
	private By billingAddress2 = By.xpath("//div[2]/ul/li[5]");
	private By billingCity = By.xpath("//div[2]/ul/li[6]");
	private By billingCountry = By.xpath("//div[2]/ul/li[7]");
	private By billingPhone = By.xpath("//div[2]/ul/li[8]");
	
	private By deliveryAddress1 = By.xpath("//ul[@class='address item box']/li[4]");
	private By deliveryAddress2 = By.xpath("//ul[@class='address item box']/li[5]");
	
	private By deleteAccountBtn = By.cssSelector(".fa-trash-o");
	
	@FindBy(css = "tr[id='product-1'] td[class='cart_total'] p")
	private WebElement  firstTotal;

	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement checkoutBtn;
	
	@FindBy(css=".form-control")
	private WebElement commentBox;
	
	@FindBy(css=".check_out")
	private WebElement placeOrderBtn;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage commentAndPlaceOrder() {
		commentBox.sendKeys("Lorem ipsum");
		placeOrderBtn.click();
		PaymentPage payment = new PaymentPage(driver);
		return payment;
	}
	
	public LoginPage proceedCheckLog() {
		checkoutBtn.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public boolean verifyAddress(String firstAddress, String secondAddress) {
		/*boolean[] matches = new boolean[4];
	    matches[0] = driver.findElement(billingAddress1).getText().equalsIgnoreCase(firstAddress);
	    matches[1] = driver.findElement(billingAddress2).getText().equalsIgnoreCase(secondAddress);
	    matches[2] = driver.findElement(deliveryAddress1).getText().equalsIgnoreCase(firstAddress);
	    matches[3] = driver.findElement(deliveryAddress2).getText().equalsIgnoreCase(secondAddress);*/
		boolean[] matches = new boolean[4];
		matches[0] = checkAddress(billingAddress1, firstAddress);
		matches[1] = checkAddress(billingAddress2, secondAddress);
		matches[2] = checkAddress(deliveryAddress1, firstAddress);
		matches[3] = checkAddress(deliveryAddress2, secondAddress);
				
	    for (boolean match : matches) {
	        if (!match) return false; 
	    	}
	    return true;
	}
	
	public boolean verifyDetails(String firstName, String lastName, String companyName, String address, String address2, String countryName, String stateName, String cityName, String zipcodeNumber, String phoneNumber) {
		/*boolean[] matches = new boolean[7];
	    matches[0] = driver.findElement(billingNames).getText().equalsIgnoreCase("Mr. " + firstName + " " + lastName);
	    matches[1] = driver.findElement(billingCompany).getText().equalsIgnoreCase(companyName);
	    matches[2] = driver.findElement(billingAddress1).getText().equalsIgnoreCase(address);
	    matches[3] = driver.findElement(billingAddress2).getText().equalsIgnoreCase(address2);
	    matches[4] = driver.findElement(billingCity).getText().equalsIgnoreCase(cityName + " " + stateName + " " + zipcodeNumber);
	    matches[5] = driver.findElement(billingCountry).getText().equalsIgnoreCase(countryName);
	    matches[6] = driver.findElement(billingPhone).getText().equalsIgnoreCase(phoneNumber);*/
		boolean[] matches = new boolean[7];
		matches[0] = checkText(billingNames, "Mr. " + firstName + " " + lastName);
		matches[1] = checkText(billingCompany, companyName);
		matches[2] = checkText(billingAddress1, address);
		matches[3] = checkText(billingAddress2, address2);
		matches[4] = checkText(billingCity, cityName + " " + stateName + " " + zipcodeNumber);
		matches[5] = checkText(billingCountry, countryName);
		matches[6] = checkText(billingPhone, phoneNumber);
		
	    for (boolean match : matches) {
	        if (!match) return false; 
	    	}
	    return true;
	}
	
	public DeleteAccountPage deleteAccount() {
		driver.findElement(deleteAccountBtn).click();
		DeleteAccountPage deleteAPage = new DeleteAccountPage(driver);
		return deleteAPage;
	}
	
	private boolean checkAddress(By locator, String expectedText) {
        return driver.findElement(locator).getText().trim().equalsIgnoreCase(expectedText.trim());
    }

    private boolean checkText(By locator, String expectedText) {
        return driver.findElement(locator).getText().trim().equalsIgnoreCase(expectedText.trim());
    }
}
