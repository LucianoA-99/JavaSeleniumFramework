package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	private WebDriver driver;
	
	private By userIsLogged = By.xpath("//div/ul/li[10]/a");
	private By subscriptionText = By.xpath("//div[@class='single-widget']/h2");
	private By subscriptionSuccessTxt = By.cssSelector(".alert-success.alert");
	private By categoryText = By.cssSelector(".title.text-center");
	private By recommendedTxt = By.xpath("//h2[normalize-space()='recommended items']");
	
	@FindBy(xpath = "(//p[contains(text(),'Stylish Dress')])[3]")
	private WebElement itemTxt;

	@FindBy(css = ".fa.fa-angle-up")
	private WebElement scrollArrowBtn;
	
	@FindBy(css = "a[href='/logout']")
	private WebElement logOutBtn;

	@FindBy(css = ".fa-trash-o")
	private WebElement deleteBtn;

	@FindBy(id = "subscribe")
	private WebElement subscribeBtn;
	
	@FindBy(css=".btn.btn-success.close-modal.btn-block")
	private WebElement continueShoppingBtn;

	@FindBy(xpath = "(//a[normalize-space()='Add to cart'])[72]")
	private WebElement recommendedItem;

	@FindBy(xpath = "//a[normalize-space()='Women']/span/i")
	private WebElement womanCategory;

	@FindBy(xpath = "//a[normalize-space()='Men']/span/i")
	private WebElement manCategory;

	@FindBy(xpath = "//a[normalize-space()='Tshirts']")
	private WebElement manSubCategory;

	@FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
	private WebElement womanSubCategory;

	@FindBy(id = "susbscribe_email")
	private WebElement subscribeEmail;

	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[1]")
	private WebElement cartBtn;

	@FindBy(css = "a[href='/products']")
	private WebElement productsBtn;

	@FindBy(xpath = "//div[@class='item active']/div/h2")
	private WebElement automationTxt;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAutomationText() {
		return automationTxt.isDisplayed();
	}

	public void ScrollUsingArrow() {
		scrollArrowBtn.click();
	}

	public String addRecomendedItem() {
		recommendedItem.click();
		continueShoppingBtn.click();
		return itemTxt.getText();
	}

	public String getRecommendedItemName() {
		return itemTxt.getText();
	}

	public String verifyRecommendedTxt() {
		return getElementTxt(recommendedTxt);
	}

	public DeleteAccountPage deleteAccount() {
		deleteBtn.click();
		DeleteAccountPage deleteAPage = new DeleteAccountPage(driver);
		return deleteAPage;
	}

	public void chooseWCategory() {
		womanCategory.click();
		womanSubCategory.click();
	}

	public void chooseMCategory() {
		manCategory.click();
		manSubCategory.click();
	}

	public String confirmCategory() {
		return getElementTxt(categoryText);
	}

	public String Confirmation() {
		return getElementTxt(userIsLogged);
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

	public void LogOut() {
		logOutBtn.click();
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void ScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

	public String Url() {
		return driver.getCurrentUrl();
	}

	public String verifySubscriptionText() {
		return getElementTxt(subscriptionText);
	}

	public String verifySubscriptionSuccess() {
		return getElementTxt(subscriptionSuccessTxt);
	}

	public void SubscribeEmail(String email) {
		subscribeEmail.sendKeys(email);
		subscribeBtn.click();
	}
}