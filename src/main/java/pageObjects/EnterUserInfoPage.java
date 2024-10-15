package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestAbstractComponents.AbstractComponents;

public class EnterUserInfoPage extends AbstractComponents {
	private WebDriver driver;
	
	public EnterUserInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#first_name")
	private WebElement firstName;

	@FindBy(css = "#last_name")
	private WebElement lastName;

	@FindBy(css = "#company")
	private WebElement company;

	@FindBy(css = "#address1")
	private WebElement address1;

	@FindBy(css = "#address2")
	private WebElement address2nd;

	@FindBy(css = "#country")
	private WebElement country;

	@FindBy(css = "#state")
	private WebElement state;

	@FindBy(css = "#city")
	private WebElement city;

	@FindBy(css = "#zipcode")
	private WebElement zipcode;

	@FindBy(css = "#mobile_number")
	private WebElement mobileNumber;

	@FindBy(css = "#password")
	private WebElement userPassword;

	@FindBy(css = "#days")
	private WebElement Bday;

	@FindBy(css = "#months")
	private WebElement Bmonth;

	@FindBy(css = "#years")
	private WebElement Byear;
	
	@FindBy(css = "#optin")
	private WebElement specialOffers;
	
	@FindBy(css = "#newsletter")
	private WebElement newsletter;
	
	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	private WebElement createAccount;
	
	@FindBy(css = "#id_gender1")
	private WebElement title;

	private By enterAccInfo = By.cssSelector("h2.title.text-center");

	public String enterAccountInfoTxt() {
		return getElementTxt(enterAccInfo);
	}

	public void fillDetails(String name, String password, String day, String month, String year, String firstN,String lastN, String companyN, String address, String address2, String countryN, String stateN,String cityN, String zipcodeN, String mobileN) {
		Select dropdownDay = new Select(Bday);
		Select dropdownMonth = new Select(Bmonth);
		Select dropdownYear = new Select(Byear);
		Select dropdownCountry = new Select(country);

		title.click();
		dropdownDay.selectByValue(day);
		dropdownMonth.selectByValue(month);
		dropdownYear.selectByValue(year);
		userPassword.sendKeys(password);
		newsletter.click();
		specialOffers.click();
		createAccount.click();
		firstName.sendKeys(firstN);
		lastName.sendKeys(lastN);
		company.sendKeys(companyN);
		address1.sendKeys(address);
		address2nd.sendKeys(address2);
		state.sendKeys(stateN);
		city.sendKeys(cityN);
		zipcode.sendKeys(zipcodeN);
		mobileNumber.sendKeys(mobileN);
		dropdownCountry.selectByValue(countryN);
	}

	public ConfirmationUserPage createAccount() {
		createAccount.click();
		ConfirmationUserPage confirmation = new ConfirmationUserPage(driver);
		return confirmation;
	}
}