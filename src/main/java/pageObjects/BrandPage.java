package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAbstractComponents.AbstractComponents;

public class BrandPage extends AbstractComponents {
	private WebDriver driver;

	private By brandTxt = By.cssSelector(".title.text-center");

	@FindBy(css = "a[@href='/brand_products/Polo']")
	private WebElement poloBrand;

	@FindBy(css = "a[href='/brand_products/H&M']")
	private WebElement hmBrand;

	public BrandPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUrlAndEle(String url) {
		boolean products = driver.findElement(brandTxt).isDisplayed();
		boolean allShown;
		System.out.println(driver.getCurrentUrl());
		if (products && driver.getCurrentUrl().equalsIgnoreCase(url))
			allShown = true;
		else
			allShown = false;
		return allShown;
	}

	public void selectBrand() {
		hmBrand.click();
	}
}