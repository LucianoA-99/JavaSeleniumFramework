package pageObjects;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAbstractComponents.AbstractComponents;

public class ProductDetailPage extends AbstractComponents{
	private WebDriver driver;
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//product detail
	private By ftProductName = By.cssSelector("div[class='product-information'] h2");
	private By productCategory = By.xpath("//div[@class='product-details']//p[1]");
	private By productPrice = By.cssSelector("div[class='product-information'] span span");
	private By productAvailability = By.xpath("//div[@class='product-details']//p[2]");
	private By productCondition = By.xpath("//div[@class='product-details']//p[3]");
	private By productBrand = By.xpath("//div[@class='product-details']//p[4]");
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement reviewName;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement reviewEmail;
	
	@FindBy(xpath="//textarea[@id='review']")
	private WebElement addReviewTxt; 
	
	@FindBy(xpath="//button[@id='button-review']")
	private WebElement submitReview;
	
	@FindBy(xpath="//input[@id='quantity']")
	private WebElement quantity;
	
	@FindBy(css=".cart")
	private WebElement addToCart;
	
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	private WebElement cartBtn;
	
	@FindBy(css="a[href='#reviews']")
	private WebElement reviewTxt;
	
	@FindBy(css="div[class='alert-success alert'] span")
	private WebElement reviewSuccess;
	
	public void addReview() {
		reviewName.sendKeys("Luciano");
		reviewEmail.sendKeys("qatest123@adinet.com");
		addReviewTxt.sendKeys("Lorem ipsum");
		submitReview.click();
	}
	
	public void verifyReviewTxt() {
		 waitForWebElementToAppear(reviewTxt);
	}
	
	public String reviewSuccessTxt() {
		return reviewSuccess.getText();
	}
	
	public boolean verifyProducts() {
		String[] elements = { getElementTxt(ftProductName), getElementTxt(productCategory), getElementTxt(productPrice),
				getElementTxt(productAvailability), getElementTxt(productCondition), getElementTxt(productBrand) };
		return Arrays.stream(elements).allMatch(element -> element != null);
	}
	
	public CartPage increaseQuantity() {
		quantity.clear();
		quantity.sendKeys("4");
		addToCart.click();
		cartBtn.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	
}
