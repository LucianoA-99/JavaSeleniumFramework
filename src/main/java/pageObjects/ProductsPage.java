package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents {
	private WebDriver driver;
	private String products1and2 [];

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fa fa-plus-square'])[1]")
	private WebElement viewFirstProduct;

	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement searchBtn;

	@FindBy(css = "#search_product")
	private WebElement searchProduct;

	@FindBy(xpath = "//div[@class='col-sm-4']/div/div/div/a")
	private List <WebElement> allSearchedProducts; 
	
	@FindBy(xpath = "//div[@class='col-sm-4']/div/div/div/p")
	private List <WebElement> SearchedProdNames;
	
	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[2]")
	private WebElement selectFirstProduct;
	
	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[4]")
	private WebElement selectSecondtProduct;
	
	@FindBy(css = ".btn.btn-success.close-modal.btn-block")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath="(//i[@class='fa fa-shopping-cart'])[1]")
	private WebElement cartBtn;
	
	@FindBy(xpath="//a[@href='/brand_products/Polo']")
	private WebElement brandBtn;
	
	private By searchedText = By.cssSelector(".title.text-center");
	private By productNames = By.xpath("//div[@class='productinfo text-center']//p");
	private By firstProductPrice = By.xpath("(//div[@class='productinfo text-center']//h2)[1]");
	private By secondProdPrice = By.xpath("(//div[@class='productinfo text-center']//h2)[2]");
	private By firstProdName = By.xpath("(//div[@class='productinfo text-center'])[1]/p");
	private By secondProdName = By.xpath("(//div[@class='productinfo text-center'])[2]/p");
	private By brandTxt = By.xpath("//h2[normalize-space()='Brands']");
	
	public BrandPage brand() {
		brandBtn.click();
		BrandPage brand = new BrandPage(driver);
		return brand;
	}
	
	public String verifyBrandTxt() {
		return getElementTxt(brandTxt);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void searchProduct(String product) {
		searchProduct.sendKeys(product);
		searchBtn.click();
	}
	
	public List<String> addAllProducts() {
		allSearchedProducts.forEach(product -> { product.click(); waitForElementToBeClickable(continueShoppingBtn); continueShoppingBtn.click();
		});
		List<String> productNames = new ArrayList<>();
		SearchedProdNames.forEach(product -> { String Name = product.getText().trim().replaceAll("\\s+", " "); productNames.add(Name);});
		return productNames;
	}

	public boolean verifySearchedP(String product) {
		List<WebElement> productList = driver.findElements(productNames);
		return productList.stream().anyMatch(cloth -> cloth.getText().toLowerCase().contains(product.toLowerCase()));
	}

	public String verifySearchedProdText() {
		return getElementTxt(searchedText);
	}

	public ProductDetailPage firstProduct() {
		viewFirstProduct.click();
		ProductDetailPage detail = new ProductDetailPage(driver);
		return detail;
	}
	
	public void addProducts() {
		selectFirstProduct.click();
		continueShoppingBtn.click();
		selectSecondtProduct.click();
		continueShoppingBtn.click();
	}
	
	public String[] getProducts1and2() {
		return products1and2;
	}
	
	public void setProducts1and2() {
		this.products1and2 = new String [4];
		this.products1and2[0] = driver.findElement(firstProductPrice).getText().trim();
		this.products1and2[1] = driver.findElement(firstProdName).getText().trim();
		this.products1and2[2] = driver.findElement(secondProdPrice).getText().trim();
		this.products1and2[3] = driver.findElement(secondProdName).getText().trim();
	}
	
	 public CartPage goToCart() {
		 cartBtn.click();
		 CartPage cart = new CartPage(driver);
		 return cart;
	 }

}
