package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class ConfirmationUserPage extends AbstractComponents {
	private WebDriver driver;

	public ConfirmationUserPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".title.text-center")
	private WebElement confirmationTxt;

	@FindBy(css = ".btn-primary")
	private WebElement continueBtn;

	public String getConfirmation() {
		String confirmMessage = confirmationTxt.getText();
		return confirmMessage;
	}

	public HomePage continueTo() {
		continueBtn.click();
		HomePage home = new HomePage(driver);
		return home;
	}
}