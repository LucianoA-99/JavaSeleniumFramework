package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class DeleteAccountPage extends AbstractComponents {
	private WebDriver driver;

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".title.text-center")
	private WebElement confirmation;

	@FindBy(css = ".btn-primary")
	private WebElement continueBtn;

	public String getConfirmation() {
		return confirmation.getText();
	}

	public void continueTo() {
		continueBtn.click();
	}
}
