package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".fa-lock")
	private WebElement LoginButton;

	@FindBy(css = "a[href='/test_cases']")
	private WebElement testCasesBtn;

	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	private WebElement contactFormBtn;

	@FindBy(css = "a[href='/products']")
	private WebElement productsBtn;

	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[1]")
	private WebElement cartBtn;

	public LoginPage GoToLoginPage() {
		LoginButton.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

	public TestCasePage GoToTestCases() {
		testCasesBtn.click();
		TestCasePage testCases = new TestCasePage(driver);
		return testCases;
	}

	public ContactFormPage GoToContactForm() {
		contactFormBtn.click();
		ContactFormPage contactPage = new ContactFormPage(driver);
		return contactPage;
	}

	public void GoTo(String url) {
		driver.get(url);
	}

	public HomePage getHome() {
		HomePage home = new HomePage(driver);
		return home;
	}

	public ProductsPage goToProducts() {
		productsBtn.click();
		ProductsPage products = new ProductsPage(driver);
		return products;
	}

	public CartPage goToCart() {
		cartBtn.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
}
