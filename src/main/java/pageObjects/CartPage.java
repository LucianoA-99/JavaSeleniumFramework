package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	private WebDriver driver;
	private String productList[];
	
	private By subText = By.xpath("//div[@class='single-widget']/h2");
	private By subSuccessTxt = By.cssSelector(".alert-success.alert");
	private By recommendedItem = By.xpath("//td[@class='cart_description']/h4/a");
	
	@FindBy(id = "subscribe")
	private WebElement subBtn;
	
	@FindBy(xpath = "(//tbody)[1] /tr")
	private List <WebElement> allProductsRows;
	
	@FindBy(xpath = "//td[@class='cart_description']/h4/a")
	private List <WebElement> allNames;
	
	@FindBy(css = "tr[id='product-1'] td[class='cart_total'] p")
	private WebElement firstTotal;

	@FindBy(css = "tr[id='product-2'] td[class='cart_total'] p")
	private WebElement secondTotal;

	@FindBy(css = "a[href='/product_details/1']")
	private WebElement firstProductName;

	@FindBy(css = "a[href='/product_details/2']")
	private WebElement secondProductName;

	@FindBy(xpath = "//u[normalize-space()='Register / Login']")
	private WebElement LoginButton;

	@FindBy(css = "tr[id='product-1'] td[class='cart_price'] p")
	private WebElement firstProductPrice;

	@FindBy(css = "tr[id='product-2'] td[class='cart_price'] p")
	private WebElement secondProductPrice;

	@FindBy(css = "tr[id='product-1'] td[class='cart_quantity'] button")
	private WebElement firstQuantity;

	@FindBy(css = "tr[id='product-2'] td[class='cart_quantity'] button")
	private WebElement secondQuantity;

	@FindBy(xpath = "//tr[@id='product-1']/td/a/i")
	private WebElement removeBtn;

	@FindBy(id = "susbscribe_email")
	private WebElement subscribeEmail;

	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement checkoutBtn;
	
	@FindBy(css=".fa-lock")
	private WebElement LoginRegisterBtn;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage login() {
		LoginRegisterBtn.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public String verifyRecommendedItem () { 
		return getElementTxt(recommendedItem);
	}
	
	public boolean verifyAllNames(List<String> prods) {
		List<String> productNames = new ArrayList<>();
		allNames.forEach(product -> { String Name = product.getText().trim().replaceAll("\\s+", " ");  productNames.add(Name);});
		System.out.println(productNames);
		boolean areNamesEqual = prods.equals(productNames);
		System.out.println("Expected product names: " + prods);
	    System.out.println("Actual product names in cart: " + productNames);
		return areNamesEqual;
	}

	public CheckoutPage proceedCheckout() {
		checkoutBtn.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}

	public LoginPage proceedCheckLog() {
		checkoutBtn.click();
		LoginButton.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}

	public boolean checkQuantity() {
		return firstQuantity.getText().equals("4");
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public String Url() {
		return driver.getCurrentUrl();
	}

	public boolean verifyProductsDetails(String prods[]) {
		this.productList = new String[4];
		this.productList[0] = firstProductPrice.getText().trim();
		this.productList[1] = firstProductName.getText().trim();
		this.productList[2] = secondProductPrice.getText().trim();
		this.productList[3] = secondProductName.getText().trim();
		boolean productsEqual = Arrays.equals(productList, prods);
		boolean quantitiesMatch = firstQuantity.getText().equals("1") && secondQuantity.getText().equals("1");
		boolean totalsMatch = firstTotal.getText().trim().equals(productList[0]) && secondTotal.getText().trim().equals(productList[2]);
		return productsEqual && quantitiesMatch && totalsMatch;
	}

	public boolean RemoveAndCompare() {
		removeBtn.click();
		return allProductsRows.stream().anyMatch(element -> element.getText().equals(firstProductName.getText()));
	}

	public void SubscribeEmail(String email) {
		subscribeEmail.sendKeys(email);
		subBtn.click();
	}

	public String verifySubText() {
		return getElementTxt(subText);
	}

	public String verifySubSuccessText() {
		return getElementTxt(subSuccessTxt);
	}
}