package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement username;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement useremail;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement userEmailLogin;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement userPassword;
	
	@FindBy(xpath = "//input[4]/following-sibling::button")
	private WebElement signupButton;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginButton;

	private By signupText = By.cssSelector("div[class='signup-form'] h2");

	private By loginText = By.xpath("//div[@class='login-form']/h2");

	private By wrongAccText = By.cssSelector("form[action='/login'] :nth-child(4)");

	private By userAlreadyExist = By.xpath("//p[normalize-space()='Email Address already exist!']");

	public HomePage LogIn(String email, String password) {
		userEmailLogin.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		HomePage home = new HomePage(driver);
		return home;
	}

	public String verifyNewUserSignup() { 
		return getElementTxt(signupText);
	}

	public String verifyIncorrectPassEmail() {
		return getElementTxt(wrongAccText);
	}

	public String verifyAccountExist() {
		return getElementTxt(userAlreadyExist);
	}

	public String verifyLoginToYourAcc() {
		return getElementTxt(loginText);
	}

	public EnterUserInfoPage goToEnterUserInfo() {
		signupButton.click();
		EnterUserInfoPage enterUserInfoPage = new EnterUserInfoPage(driver);
		return enterUserInfoPage;
	}

	public void RegisterUser(String name, String email) {
		waitForWebElementToAppear(username);
		username.sendKeys(name);
		useremail.sendKeys(email);
	}
}