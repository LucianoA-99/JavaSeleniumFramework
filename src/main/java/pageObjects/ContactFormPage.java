package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAbstractComponents.AbstractComponents;

public class ContactFormPage extends AbstractComponents{
	private WebDriver driver;
	
	public ContactFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By getInTouchText = By.xpath("//h2[normalize-space()='Get In Touch']");
	
	private By uploadFileBtn = By.cssSelector("input[name='upload_file']");
	
	private By alertText = By.cssSelector(".status.alert");
	
	@FindBy(css="input[placeholder='Name']")
	private WebElement inputName;
	
	@FindBy(css="input[placeholder='Email']")
	private WebElement inputEmail;
	
	@FindBy(css="input[placeholder='Subject']")
	private WebElement inputSubject;
	
	@FindBy(css="#message")
	private WebElement inputMessage;
	
	@FindBy(css="input[value='Submit']")
	private WebElement submitBtn;
	
	@FindBy(css=".btn.btn-success")
	private WebElement homeBtn;
	
	public String verifyAlert() {
		return getElementTxt(alertText);
	}

	public HomePage goToHome() {
		homeBtn.click();
		HomePage home = new HomePage(driver);
		return home;
	}
	
	public void fillInfo(String name, String email, String subject, String message) {
		inputName.sendKeys(name);
		inputEmail.sendKeys(email);
		inputSubject.sendKeys(subject);
		inputMessage.sendKeys(message);
		uploadFile(uploadFileBtn);
		submitBtn.click();
		driver.switchTo().alert().accept();
	}
	
	public String verifyGetInTouch() {
		return getElementTxt(getInTouchText);
	}
}