package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class TestCasePage extends AbstractComponents{
	private WebDriver driver;
	
	public TestCasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	 public String Url () {
		 return driver.getCurrentUrl();
	 }
}